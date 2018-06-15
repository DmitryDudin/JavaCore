package ua.com.javatrainig;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimpleExecutor {

    public static void main(String[] args) {
//        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.scheduleAtFixedRate(SimpleExecutor::myTask, 0, 1, TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(SimpleExecutor::myTask, 0, 1, TimeUnit.SECONDS);
    }

    private static void myTask() {
        System.out.println(Thread.currentThread().getName() + " - " + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(10);
//            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
