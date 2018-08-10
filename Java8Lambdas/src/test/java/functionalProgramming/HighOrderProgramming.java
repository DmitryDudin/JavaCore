package functionalProgramming;

import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class HighOrderProgramming {
//    This type of functions that operate on (or produce new) functions are typically called high order functions
//    and the programming style based on exploiting this powerful feature is called, unsurprisingly,
//    high order programming.


    @Test
    public void functionsThatCreateFunctions() {
        Function<Integer, Function<Integer, Integer>> makeAdder =    //x -> y -> x + y;
                x -> {
                    return y -> {
                        return x + y;
                    };
                };

        System.out.println("result= " + makeAdder.apply(1).apply(9));
    }

    @Test
    public void functionsThatReceiveFunctionsAsArguments() {
//        (f,g) -> x -> g( f(x) )
//        This is a classical example of what is called function composition.
        Function<Integer, Integer> add1 = x -> x + 1;
        Function<Integer, Integer> mul3 = x -> x * 3;
        System.out.println("result= " + mul3.apply(add1.apply(9)));
    }

    @Test
    public void binaryFunctionExample() {
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        Integer res = sum.apply(1, 2); // yields 3
        System.out.println(res);
    }

    @Test
    public void functionCompositionStrategy1() {
//        more difficult strategy
        Function<Integer, Integer> add1 = x -> x + 1;
        Function<Integer, Integer> mul3 = x -> x * 3;

        //first execute f(), an then g()
        BinaryOperator<Function<Integer, Integer>> compose = (f, g) -> x -> g.apply(f.apply(x));//compound function

        Function<Integer, Integer> h = compose.apply(add1, mul3);//combine two unary integer functions
//        Function<Integer, Integer> h = compose.apply(mul3, add1);
        Integer res = h.apply(10); //yields 33
        System.out.println("result= " + res);
    }

    @Test
    public void functionCompositionStrategy2() {
//        all Function objects have a method called compose that allows us to very easily compose two functions together.
        Function<Integer, Integer> add1 = x -> x + 1;
        Function<Integer, Integer> mul3 = x -> x * 3;

        Function<Integer, Integer> compose = mul3.compose(add1);
        System.out.println("result= " + compose.apply(10));

    }

//    unary Operator - function that receives one argument.
//    BinaryOperator - function that receives two arguments.
}
