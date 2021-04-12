package ua.com.javatraining.genericsAndPrimitiveDataTypes;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndPrimitiveDataTypes {

    public static void main(String[] args) {

//        List<int> list = new ArrayList<>();//non compliant

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        System.out.println(intList);

    }

}
