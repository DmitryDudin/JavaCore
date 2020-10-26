package ua.com.javatraining.unobviousGenerics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapPollution {

    @Test
    public void warningHeapPollution() {
        method(new ArrayList<String>(), new ArrayList<String>());
    }

    //possible heap pollution from parameterized vararg type
    public void method(List<String>... stringList) {
        Object[] objectsArr = stringList;
        objectsArr[0] = Arrays.asList(42);
        System.out.println("objectsArr = " + Arrays.toString(objectsArr));
        String string0 = stringList[0].get(0);//ClassCastException
    }

    @Test
    public void heapPollutionMethod() {
        List l = new ArrayList<Number>();
        l.add(1);
        List<String> ls = l;
        ls.add("");
        ls.add("someText");
        System.out.println(l);
        System.out.println(ls);
    }

    @Test
    public void heapPollutionMethod2() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        List list = ints;
        List<Number> nums = list;
        nums.add(3.3d);

        System.out.println("ints = " + ints);

//        Integer intValue1 = ints.get(1);//ClassCastException т.к. компилятор заботливо послтавил cast to Integer
//        Integer intValue2 = (Integer) ints.get(1);//ClassCastException
    }

    @Test
    public void heapPollutionMethod3() {
//        List<Number>[] numList = new ArrayList<Number>[10];// no compliant because of might throw RuntimeException
        List<?>[] wildcardList = new ArrayList<?>[10];
    }

}
