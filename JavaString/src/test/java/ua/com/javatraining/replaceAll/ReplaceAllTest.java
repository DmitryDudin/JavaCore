package ua.com.javatraining.replaceAll;

import org.junit.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class ReplaceAllTest {

    @Test
    public void removeWhiteSpaces() {
        String pattern = "(\\w)(\\s+)([\\.,])";
        String EXAMPLE_TEST_1 ="some new sentence 1    .";
        String EXAMPLE_TEST_2 ="some new sentence j2     , and another one    .";

        System.out.println(EXAMPLE_TEST_1.replaceAll(pattern, "$1$2"));//
        System.out.println(EXAMPLE_TEST_2.replaceAll(pattern, "$1$2"));
        System.out.println();
        //replace "(\\w)(\\s+)([\\.,])"  --->  "(\\w)([\\.,])"
        //  "1    ."  --->  "1."
        System.out.println(EXAMPLE_TEST_1.replaceAll(pattern, "$1$3"));
        System.out.println(EXAMPLE_TEST_2.replaceAll(pattern, "$1$3"));
        System.out.println();
        System.out.println(EXAMPLE_TEST_1.replaceAll(pattern, "$2$3"));
        System.out.println(EXAMPLE_TEST_2.replaceAll(pattern, "$2$3"));
        System.out.println();
        System.out.println(EXAMPLE_TEST_1.replaceAll(pattern, "$1$2$3"));
        System.out.println(EXAMPLE_TEST_2.replaceAll(pattern, "$1$2$3"));

        System.out.println();
        System.out.println(EXAMPLE_TEST_2.replaceAll(pattern, "$1"));
        System.out.println(EXAMPLE_TEST_2.replaceAll(pattern, "$2"));
        System.out.println(EXAMPLE_TEST_2.replaceAll(pattern, "$3"));
        System.out.println(EXAMPLE_TEST_2.replaceAll(pattern, "$3---ABC---"));
        System.out.println(EXAMPLE_TEST_2.replaceAll(pattern, "###"));
        System.out.println(EXAMPLE_TEST_2.replaceAll(pattern, "---ABC---"));

        System.out.println();
        System.out.println( Pattern
                .compile(pattern)
                .matcher(EXAMPLE_TEST_2)
                .replaceAll("$3---ABC---")
        );
    }

}
