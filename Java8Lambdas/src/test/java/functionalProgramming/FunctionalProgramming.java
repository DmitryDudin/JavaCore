package functionalProgramming;

import org.junit.Test;

import java.util.function.Function;

public class FunctionalProgramming {

    @Test
    public void simpleFunction() {
        Function<Integer, Integer> add1 = x -> x + 1;
        Function<String, String> concat = x -> x + 1;

        System.out.println(add1.apply(9));
        System.out.println(concat.apply("0 + 1= "));
    }

    @Test
    public void simpleFuncWithMethodReferense() {
        class Utils {
            Integer add1(Integer x) {
                return x + 1;
            }

            String concat1(String x) {
                return x + 1;
            }

        }

        //methods in this class are compatible with our original function definitions, so we could use them
        //as "method references" to create the same functions we did before with lambda expressions
        Function<Integer, Integer> add1 = new Utils()::add1;
        Function<String, String> concat = new Utils()::concat1;
        System.out.println(add1.apply(9));
        System.out.println(concat.apply("0 + 1= "));


        Function<Integer, Integer> add11 = FunctionalProgramming.Utils::add1;
        Function<String, String> concat1 = FunctionalProgramming.Utils::concat1;

    }

    public static class Utils {
        public static Integer add1(Integer x) {
            return x + 1;
        }

        public static String concat1(String x) {
            return x + 1;
        }
    }
}
