package ua.com.javatraining;

import java.util.ArrayList;
import java.util.List;

public class ReifiableTypes {

    public static void main(String[] args) {
// differences in <?> and <? extends Object>.
        List someList = new ArrayList<>();
        boolean instanceTest = someList instanceof List<?>;
        System.out.println("instanceTest" + instanceTest);

        List anotherList = new ArrayList<>();
//        boolean instanceTest2 = anotherList instanceof List<? extends Object>;//not compile

        List<?>[] arrayOfList = new List<?>[1];
//        List<? extends Object>[] arrayOfAnotherList = new List<? extends Object>[1];////not compile  "Generic array creation."

    }

    /*class MyException<T> extends Exception { // Generic class may not extend ‘java.lang.Throwable’
        T t;
    }*/
}
