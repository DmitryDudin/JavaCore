package CollectionsAPI.Map;

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

public class ComputeMethods {

    List<User> users = Arrays.asList(
            new User("city 1", "Test Name 1", 1),
            new User("city 1", "Test Name 2", 2),
            new User("city 3", "Test Name 3", 3),
            new User("city 3", "Test Name 4", 4),
            new User("city 3", "Test Name 5", 5)
    );

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


    @Test
    public void computeIfAbsent() {
        Map<String, List<User>> usersByCity = users.stream()
                .collect(Collectors.groupingBy(User::getCity));

        List<User> computeUsers = usersByCity.computeIfAbsent("city 1", (String k) -> new ArrayList<>());
        System.out.println(computeUsers);
    }

    @Test
    public void computeIfPresent() {
//        Если нам необходимо произвести какое-то действие со значением в Map, если оно там есть,

        Map<String, List<User>> usersByCity = users.stream()
                .collect(Collectors.groupingBy(User::getCity));
        MapUtils.debugPrint(System.out, "myMap", usersByCity);

        List<User> computeUsers = usersByCity.computeIfPresent("city 1", (String k, List<User> v) -> v);
        System.out.println(computeUsers);

        computeUsers = usersByCity.computeIfPresent("city 3", (String k, List<User> v) -> new ArrayList<>());
        System.out.println(computeUsers);
    }

    @Test
    public void compute() {
        Map<String, List<User>> usersByCity = users.stream()
                .collect(Collectors.groupingBy(User::getCity));
//        MapUtils.debugPrint(System.out, "myMap", usersByCity);

        List<User> computeUsers = usersByCity.compute("city", (String k, List<User> v) -> v);
        System.out.println(computeUsers);
    }


    //    @Builder
    @ToString
    @AllArgsConstructor
    @Getter
    private class User {
        String city;
        String name;
        int age;
    }

}
