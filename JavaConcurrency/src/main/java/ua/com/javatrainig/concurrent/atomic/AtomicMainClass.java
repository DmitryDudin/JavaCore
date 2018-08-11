package ua.com.javatrainig.concurrent.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMainClass {

    // обезпечивают аттомарность
//Это означает, что для выполнения такой операции не требуется ни блокировка, ни любой другой механизм синхронизации.

//    Atomicinteger
//    AtomicLomg

//    DouЬleAccumulator
//    DouЬleAdder
//    LongAccumulator
//    LongAdder

    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        new Thread(customThread("A")).start();
        new Thread(customThread("B")).start();
        new Thread(customThread("C")).start();

    }

    private static Runnable customThread(String name) {
        return () -> {
            System.out.println("Start Thread - " + name);
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread - " + name + " getAndSet=" + count.getAndIncrement());
            }
        };
    }

}
