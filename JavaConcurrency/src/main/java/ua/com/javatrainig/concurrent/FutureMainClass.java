package ua.com.javatrainig.concurrent;

import java.util.concurrent.*;

public class FutureMainClass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable callable = () -> {
            System.out.println("start thread= " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("lambdaCallable thread= " + Thread.currentThread().getName());
            return new Object();
        };

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        Future future = newFixedThreadPool.submit(callable);
        System.out.println("future.get= " + future.get());

        Future secondFuture = newFixedThreadPool.submit(callable);
        Thread.sleep(2000);
        secondFuture.cancel(true);

        newFixedThreadPool.shutdown();
    }


}
