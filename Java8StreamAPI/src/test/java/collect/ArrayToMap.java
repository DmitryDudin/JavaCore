package collect;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class ArrayToMap {

    private static final String[] headers = new String[]{
            "Code1",
            "Code2",
            "Code3",
            "Code4",
            "Code5",
            "Code6",
            "Code7",
            "Code8",
            "Code9",
            "Code10",
            "Code11",
            "Code12",
            "Code13",
            "Code14",
            "Code15",
            "Code16",
            "Code17",
            "Code18"
    };

    @Test
    public void name() {
        Map<String, Integer> collectWithLoop = new HashMap<>();
        for (String s : headers) {
            if (collectWithLoop.put(s, 0) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        // ==
        Map<String, Integer> collect = Arrays.stream(headers).collect(toMap(Function.identity(), s -> 0));

        MapUtils.debugPrint(System.out, "myMap", collect);
    }

}
