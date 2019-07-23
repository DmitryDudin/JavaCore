package CollectionsAPI.google_guava;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.collect.Multimaps.synchronizedMultimap;

public class MultimapTests {

    @Test
    public void name() {
        Multimap<String, String> multimap = HashMultimap.create();
//        Multimap<String, String> multimap = synchronizedMultimap(HashMultimap.create());
        multimap.put("key1", "val1.1");
        multimap.put("key1", "val1.2");

        multimap.putAll("key2", Arrays.asList("val2.1", "val2.2", "val2.3"));

        System.out.println(multimap);
        System.out.println("size= " + multimap.size());
        System.out.println("key1= " + multimap.get("key1"));
        System.out.println("clazz= " + multimap.get("key1").getClass());
    }

}
