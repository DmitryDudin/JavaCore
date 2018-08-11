package ua.com.javatrainig.concurrent.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMainClass {
//    В параллельном API поддерживается также средство, называемое испмпителем
//    и предназначенное для создания потоков исполнения и управления ими. В этом
//    отношении исполнитель служит альтернативой управлению потоками исполне­
//    ния средствами класса Thread.

//    Интерфейс ExecutorService расширяет интерфейс Executor , дополняя его
//    методами, помогающими управлять исполнением потоков и контролировать их.

//      интерфейс ExecutorService
//      интерфейс ScheduledExecutorService
//      ThreadPoolExecutor
//      ScheduledThreadPoolExecutor
//      ForkJoinPool

//    вспомогательный класс Executors

    public static void main(String[] args) {
        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Запуск потоков.");
        executorService.submit(myThread(cdl1, "A"));
        executorService.submit(myThread(cdl2, "B"));
        executorService.submit(myThread(cdl3, "C"));
        executorService.submit(myThread(cdl4, "D"));
        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("Стоп потоков.");
    }

    private static Runnable myThread(CountDownLatch cdl, String name) {
        return () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + " : " + i);
                cdl.countDown();
            }
        };
    }

}
