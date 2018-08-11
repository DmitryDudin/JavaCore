package ua.com.javatrainig.concurrent.cусlicBarriеr;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class СусlicBarriеrMainClass {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarAction());
        System.out.println("Start threads.");

        new CustomThread(cyclicBarrier, "A");
        new CustomThread(cyclicBarrier, "B");
        new CustomThread(cyclicBarrier, "C");

//        new CustomThread(cyclicBarrier, "X");//Класс CyclicBarrier можно использовать повторно
//        new CustomThread(cyclicBarrier, "Y");
//        new CustomThread(cyclicBarrier, "Z");

        System.out.println("Finish main thread.");

    }


    static class CustomThread implements Runnable {

        private final String name;

        private final CyclicBarrier cyclicBarrier;

        public CustomThread(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
            new Thread(this).start();
        }

        @Override
        public void run() {
//            delaySeconds((int) (Math.random()*10));
            delaySeconds(1);
            System.out.println(name);
            try {
                int await = cyclicBarrier.await();
                System.out.println(name+" await= " + await);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Finish thread = " + name);
        }

        private void delaySeconds(int value) {
            try {
                TimeUnit.SECONDS.sleep(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class BarAction implements Runnable {

        @Override
        public void run() {
            System.out.println("Cyclic barrier is done.");
        }
    }


}
