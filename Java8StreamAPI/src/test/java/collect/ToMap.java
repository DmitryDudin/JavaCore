package collect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMap {

    private User user1 = new User("city 1", "Test Name 1", 1);
    private User user2 = new User("city 1", "Test Name 2", 2);
    private User user3 = new User("city 3", "Test Name 3", 3);
    private User user4 = new User("city 3", "Test Name 4", 4);
    private User user5 = new User("city 3", "Test Name 5", 5);
    List<User> users = Arrays.asList(user1, user2, user3, user4, user5);

    @Test
    public void name() {
        //--------------
        Map<String, List<User>> usersByCity = users.stream()
                .collect(Collectors.groupingBy(User::getCity));
        MapUtils.debugPrint(System.out, "myMap", usersByCity);

        //--------------
        Map<String, List<User>> usersByCity2 = new HashMap<>();
        for (User user : users) {
            usersByCity2.computeIfAbsent(user.getCity(), k -> new ArrayList<>()).add(user);
        }
        MapUtils.debugPrint(System.out, "myMap", usersByCity2);
    }


    @ToString
    @AllArgsConstructor
    @Getter
    private class User {
        String city;
        String name;
        int age;
    }

}
