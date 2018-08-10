package ua.com.javatrainig.volataile;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class VolatileMainClass {

    static volatile int volatileVariable = 0;
//    static AtomicInteger volatileVariable = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> IntStream.range(0, 1_000_000).forEach(j -> volatileVariable++)).start();
//            new Thread(() -> IntStream.range(0, 1_000_000).forEach(j -> volatileVariable.addAndGet(1))).start();
        }
        Thread.sleep(10000);
        System.out.println("volatileVariable= " + volatileVariable);
    }
}
