package ua.com.javatraining.genericmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class GenericMethods {

    public static <T> List<T> arrayToList(T[] arr) {
        //method to convert an array to a list:
        //In the example, the <T> in the method signature implies that the method will be dealing with generic type T.
        //This is needed even if the method is returning void.

//        return Arrays.stream(arr).collect(Collectors.toList());

        /*List<T> result = new ArrayList<>();
        for (T elem : arr) {
            result.add(elem);
        }
        return  result;*/

        return Arrays.asList(arr);
    }

    public static <T, G> List<G> moreThanOneGenericType(T[] arr, Function<T, G> mapperFunction) {
//        converts an array with the elements of type T to list with elements of type G.
        return Arrays.stream(arr)
                .map(mapperFunction)
                .collect(toList());
    }


}
