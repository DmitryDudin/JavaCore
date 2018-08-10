package ua.com.javatrainig.treadCreation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadCreation {

    public static void main(String[] args) {
        System.out.println("ThreadCreation thread= " + Thread.currentThread().getName());

        new ChildThread().start();

        new Thread(new RunnableImpl()).start();

        new Thread(() -> System.out.println("lambdaRunnable thread= " + Thread.currentThread().getName()))
                .start();

        FutureTask futureTask = new FutureTask<>(new CallableImpl());
        new Thread(futureTask).start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new CallableImpl());
        executorService.shutdown();

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        Callable callable = () -> {
            System.out.println("lambdaCallable thread= " + Thread.currentThread().getName());
            return new Object();
        };
        newFixedThreadPool.submit(callable);
        newFixedThreadPool.shutdown();
    }

}
