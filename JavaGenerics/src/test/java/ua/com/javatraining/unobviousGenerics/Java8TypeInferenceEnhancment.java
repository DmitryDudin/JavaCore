package ua.com.javatraining.unobviousGenerics;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8TypeInferenceEnhancment {

//java 1.8.25: compile error
//java 1.8.73: ok

    public void run1() {
        reduce(
                Stream.of("1", "2", "3")
                        .collect(Collectors.toMap(Function.identity(), t -> t.length()))
        );
    }

    public void run2() {
        reduce(
                Stream.of("1", "2", "3")
                        .collect(Collectors.toMap(Function.identity(), String::length))
        );
    }

    public void run3() {
        reduce(
                Stream.of("1", "2", "3")
                        .collect(Collectors.toMap(t -> t, t -> t.length()))
        );
    }

    private <T> T reduce(Map<T, ?> map) {
        return null;
    }

}
