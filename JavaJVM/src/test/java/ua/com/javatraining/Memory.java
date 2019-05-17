package ua.com.javatraining;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Memory {

    @Test
    public void name() {
        System.out.println(getMemory());
        List<User> memory = IntStream.range(0, 1_000_000)
                .mapToObj(i -> new User(i, Character.getName(i)))
                .collect(toList());
        System.out.println(getMemory());
    }

    public static String getMemory() {
        return "memory = " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class User {
        long id;
        String text;
    }

}
