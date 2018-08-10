package functionalProgramming;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

public class Currying {
//    Partial Function Application or Currying
//    In most functional programming languages it is possible to create partially applied functions.
//    That is, if a function is receiving multiple arguments, we can partially invoke the function providing
//    just a few arguments and receive a partially applied function out of it. This is typically called currying.


    @Test
    public void currying() {
        Consumer consumer = o -> {
        };

        Function<Integer, Function<Integer, Integer>> sum = x -> {
            return y -> {
                return x + y;
            };
        };

        Function<Integer, Integer> apply1 = sum.apply(5);//is a partially applied function
        Integer apply = sum.apply(5).apply(10);
        System.out.println(apply);
    }

    @Test
    public void test2() {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> func = x -> {
            return y -> {
                return z -> {
                    return x + y + z;
                };
            };
        };

        Integer result = func.apply(1)
                .apply(2)
                .apply(3);
        System.out.println(result);
    }

    @Test
    public void unaryFunctionsTest() {
//        argument and return value are of this same type
//        UnaryOperator<T> == Function<T,T>.
        UnaryOperator<Integer> add1 = x -> x + 1;
        UnaryOperator<String> concat1 = s -> s + 1;
        Function<Integer, UnaryOperator<Integer>> sum = x -> y -> x + y;
        UnaryOperator<Integer> sum10 = sum.apply(10);
        System.out.println("result= "+ sum10.apply(9));
    }

    @Test
    public void primitiveTypeFunctionsTest() {
        IntFunction<Integer> intF = x -> x + 1;
        System.out.println(intF.apply(20));
    }

    @Test
    public void primitiveTypeFunctionsTest2() {
        IntFx add1 = n -> n + 1;
        IntFunction<IntFx> sum = x -> y -> x + y;
        IntFx sum10 = sum.apply(10);
        System.out.println(sum10.cutomApply(4));
    }

    interface IntFx {
        public int cutomApply(int value);
    }
}
