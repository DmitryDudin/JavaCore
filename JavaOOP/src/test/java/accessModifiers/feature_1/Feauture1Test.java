package accessModifiers.feature_1;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Feauture1Test {

    @Test
    public void name() {
        Feauture1 feauture1 = new Feauture1();

        feauture1.testAccess(new Feauture1());

    }

    @Test
    public void asname() {
        HashMap<User, String> map = new HashMap<>();
//        map.get();
        map.put(new User(1L, "One"), "b");
        map.put(new User(1L, "Another"), "c");
        System.out.println(map);


        HashSet<User> set = new HashSet<>();
        set.add(new User(1L, "One"));
        set.add(new User(1L, "Another"));
        System.out.println(set);
    }

    class User {
        long id;
        String name;

        public User(long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return id == user.id;
        }

        @Override
        public int hashCode() {
            return (int) (id ^ (id >>> 32));
        }
    }
}


