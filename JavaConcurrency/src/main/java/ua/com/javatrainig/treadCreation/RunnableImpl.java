package ua.com.javatrainig.treadCreation;

public class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println("RunnableImpl thread= " + Thread.currentThread().getName());
    }

}
