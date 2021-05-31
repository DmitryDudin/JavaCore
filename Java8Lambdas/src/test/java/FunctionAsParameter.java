import org.junit.Test;

import java.util.function.Function;

public class FunctionAsParameter {

    @Test
    public void test1() {
        int a = 10;
        Function<Integer, Integer> smallFunction = val -> {
            return val * val;
        };
        bigFunction(a, smallFunction);
    }

    private void bigFunction(int a, Function<Integer, Integer> smallFunction) {
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        //some code

        System.out.println("smallFunction = "+smallFunction.apply(a));

        //some code
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
    }

}
