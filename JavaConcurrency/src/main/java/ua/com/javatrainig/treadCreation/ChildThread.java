package ua.com.javatrainig.treadCreation;

public class ChildThread extends Thread {

    @Override
    public void run() {
        System.out.println("ChildThread thread= " + Thread.currentThread().getName());
    }

}
