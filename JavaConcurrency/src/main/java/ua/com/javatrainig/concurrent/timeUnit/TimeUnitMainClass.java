package ua.com.javatrainig.concurrent.timeUnit;

import java.util.concurrent.TimeUnit;

public class TimeUnitMainClass {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("1");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("2");
    }

}
