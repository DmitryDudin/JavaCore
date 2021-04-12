package ua.com.javatraining.liskovSubstitutionPrinciple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LiskovSubstitutionPrinciple {

    public static void main(String[] args) {

        Number n = Integer.valueOf(42);
        List<Number> aList = new ArrayList<>();
        Collection<Number> aCollection = aList;
        Iterable<Number> iterable = aCollection;

        //Collection<Number> aCollection1 = new ArrayList<Long>();//non compile

    }

}
