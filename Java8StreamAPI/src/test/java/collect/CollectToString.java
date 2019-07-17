package collect;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectToString {

    @Test
    public void name() {
        String collect = IntStream.range(0, 10)
                .mapToObj(i -> "(?)")
                .collect(Collectors.joining(","));

        System.out.println(collect);
    }

}
