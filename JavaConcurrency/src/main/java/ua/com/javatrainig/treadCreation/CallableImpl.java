package ua.com.javatrainig.treadCreation;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("CallableImpl thread= " + Thread.currentThread().getName());
        return null;
    }

}
