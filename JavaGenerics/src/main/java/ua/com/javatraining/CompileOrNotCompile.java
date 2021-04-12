package ua.com.javatraining;

import java.util.ArrayList;
import java.util.List;

public class CompileOrNotCompile {

    /*public class Algorithm {

        public static <T> T max(T x, T y) {
            return x > y ? x : y;
        }

    }*/



    List<? extends Integer> intList = new ArrayList<>();
    List<? extends Number> numList = intList;

}
