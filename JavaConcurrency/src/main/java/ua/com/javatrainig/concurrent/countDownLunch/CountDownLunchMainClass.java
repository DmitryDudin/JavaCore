package ua.com.javatrainig.concurrent.countDownLunch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CountDownLunchMainClass {

//    CountDownLatch - реализуюет самоблокировку с обратным отсчетом.
//    Объект этого класса изначально создается с количеством событий, которые должны произойти до
//    того момента, как будет снята самоблокировка.
//    Всякий раз, когда происходит событие, значение счетчика уменьшается.
//    Как только значение счетчика достигнет нуля, самоблокировка будет снята.

//    Для ожидания по самоблокировке в потоке исполнения вызывается метод await().
//    Чтобы известить о событии, следует вызвать метод countDown().


    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(5);

        System.out.println("Start of custom thread.");

        new CustomThread(countDownLatch);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish of custom thread.");
    }

    static class CustomThread implements Runnable {

        private CountDownLatch countDownLatch;

        public CustomThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            new Thread(this).start();

        }

        @Override
        public void run() {
            IntStream.range(0, 10).forEach(value -> {
//                Thread.sleep(1000);
                System.out.println(value);
                delaySeconds(1);
                countDownLatch.countDown();
            });
        }

        private void delaySeconds(int value) {
            try {
                TimeUnit.SECONDS.sleep(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
