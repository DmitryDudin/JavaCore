package ua.com.javatraining.genericswildcards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProducerExtendsConsumerSuper {

    public static void main(String[] args) {
        List<Number> nums = Arrays.<Number>asList(4.1F, 0.2F);
        List<Integer> ints = Arrays.asList(1, 2);

        System.out.println("before nums = " + nums);
        System.out.println("before ints = " + ints);

        Collections.copy(nums, ints);

        System.out.println("after nums = " + nums);
        System.out.println("after ints = " + ints);

//        Collections.copy(ints, nums);// Compile-time error
    }

}
