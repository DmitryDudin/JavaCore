package CollectionsAPI.Map;

import org.junit.Test;

import java.util.HashMap;

public class HashMapTests {
    private final HashMap<String, String> hashMap = new HashMap<>();

    @Test
    public void test() {
        hashMap.forEach((key, value) -> {
            System.out.println(key + value);
        });
    }

}
