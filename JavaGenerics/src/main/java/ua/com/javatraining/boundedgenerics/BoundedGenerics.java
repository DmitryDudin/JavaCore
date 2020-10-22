package ua.com.javatraining.boundedgenerics;

import ua.com.javatraining.genericswildcards.entity.Vehicle;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class BoundedGenerics {

    public static <T extends Number> List<T> arrayToListBoundedMethod(T[] arr) {
        return Arrays.asList(arr);
    }

    public static <T extends Comparable> List<T> arrayToListImplementsBoundedMethod(T[] arr) {
        return Arrays.asList(arr);
    }

    public static <T extends Number & Comparable & Serializable> List<T> multipleBoundedMethod(T[] arr) {
        return Arrays.asList(arr);
    }

    public static void main(String[] args) {
//        Number[] arr = new Number[3]; //ok
//        Integer[] arr = new Integer[3];//ok
        Long[] arr = new Long[3];//ok
        arr[0] = 3L;

        System.out.println("boundedList = " + arrayToListBoundedMethod(arr));
        System.out.println("arrayToListImplementsBoundedMethod = " + arrayToListImplementsBoundedMethod(arr));
        System.out.println("multipleBoundedMethod = " + multipleBoundedMethod(arr));

    }

    //    void multiBoundedParameter(List<? extends Number & Comparable> numbers) {non compliant
    void multiBoundedParameter(List<? extends Number> numbers) {
    }

}
