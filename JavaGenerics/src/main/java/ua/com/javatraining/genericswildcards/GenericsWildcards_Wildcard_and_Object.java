package ua.com.javatraining.genericswildcards;

import java.util.Arrays;
import java.util.List;

public class GenericsWildcards_Wildcard_and_Object {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);

//        printListObject(intList);//not compile   -   The method printListObject(List<Object>) is not applicable for the arguments (List<Integer>)
        printListWildCard(intList);
        printListWildCardExtendsObject(intList);

    }

    public static void printListObject(List<Object> list) {
        for (Object element : list) {
            System.out.println(element + " ");
        }
    }

    public static void printListWildCard(List<?> list) {
        for (Object element : list) {
            System.out.println(element + " ");
        }
    }

    public static void printListWildCardExtendsObject(List<? extends Object> list) {
        for (Object element : list) {
            System.out.println(element + " ");
        }
    }

}
