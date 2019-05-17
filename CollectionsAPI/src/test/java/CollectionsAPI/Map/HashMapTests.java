package CollectionsAPI.Map;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import java.util.HashMap;

public class HashMapTests {
    private final HashMap<String, String> hashMap = new HashMap() {{
        put("key1", "value1");
        put("key2", "value2");
        put("key3", "value3");
        put("key4", "value4");
        put("key5", "value5");
    }};

    @Test
    public void test() {
        hashMap.forEach((key, value) -> {
            System.out.println(key + value);
        });
    }

    @Test
    public void put() {
        MapUtils.debugPrint(System.out, "myMap", hashMap);
        hashMap.put("key1", "!!!!!!!!!!!");
        hashMap.put("!!!!", "!!!!!!!!!!!");
        MapUtils.debugPrint(System.out, "myMap", hashMap);
    }

    @Test
    public void replace() {
        MapUtils.debugPrint(System.out, "myMap", hashMap);
        hashMap.replace("key1", "!!!!!!!!!!!");
        hashMap.replace("!!!!", "!!!!!!!!!!!");
        MapUtils.debugPrint(System.out, "myMap", hashMap);
    }

    @Test
    public void merge() {
        MapUtils.debugPrint(System.out, "myMap", hashMap);
        hashMap.merge("key1", "!!!!!!!!!!!", (oldVal, newVal) -> newVal);
        hashMap.merge("!!!!", "!!!!!!!!!!!", (oldVal, newVal) -> newVal);
        MapUtils.debugPrint(System.out, "myMap", hashMap);
    }

}
