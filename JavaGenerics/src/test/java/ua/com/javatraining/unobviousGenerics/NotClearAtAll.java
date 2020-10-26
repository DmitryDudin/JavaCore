package ua.com.javatraining.unobviousGenerics;

import java.util.ArrayList;
import java.util.List;

public class NotClearAtAll {

//bug in java generics

    public static void main(String[] args) {
        String list = newList();
        System.out.println("list = " + list);
    }

    private static <T extends List> T newList() {
        return (T) new ArrayList<>();
    }

}
