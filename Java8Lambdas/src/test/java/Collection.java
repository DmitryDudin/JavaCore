import lombok.Getter;
import org.junit.Test;

import java.util.*;

public class Collection {

    @Test
    public void iterateByMap() {
        Map<String, String> map = new HashMap<>();
//        map.merge();
        map.forEach((key, value) -> {
        });
    }
    @Test
    public void mergeFunctionMap() {
        Map<String, String> map = new HashMap<>();
//        map.merge("key","value", remappingFunction);
    }

    @Test
    public void sortCollection() {
        List<User> list = new ArrayList<>();
        list.sort(Comparator.comparing(User::getId));
    }

    @Getter
    private class User {
        private Long id;
    }

}
