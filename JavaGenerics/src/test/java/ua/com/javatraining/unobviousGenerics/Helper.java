package ua.com.javatraining.unobviousGenerics;

import java.util.Arrays;
import java.util.List;

public class Helper<T> {

    public List<Integer> numbers () {
        return Arrays.asList(1, 2, 3);
    }

    public static void main(String[] args) {
        Helper helper = new Helper<>();
//        for (Integer number: helper.numbers()) {//not compile
//
//        }

        List numbers = helper.numbers();//java erasure all generics in class

        for (Object number2: helper.numbers()) {//ok

        }

        Helper helper2 = new Helper<String>();
        List numbers2 = helper2.numbers();//java erasure all generics in class
//        for (Integer number : helper2.numbers()) {//not compile too
//        }

        Helper<?> helper3 = new Helper<>();
        for (Integer number : helper3.numbers()) {//!!!!!!!!!!!!!! working

        }

    }

}
