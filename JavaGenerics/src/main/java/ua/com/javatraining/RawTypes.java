package ua.com.javatraining;

import java.util.ArrayList;

public class RawTypes {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();

        ArrayList arrayList = new ArrayList();

        arrayList = strings; // Ok

        strings = arrayList; // Unchecked assignment

        arrayList.add(1); //unchecked call

    }
}
