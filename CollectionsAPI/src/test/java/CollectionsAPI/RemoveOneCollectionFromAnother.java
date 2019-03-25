package CollectionsAPI;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class RemoveOneCollectionFromAnother {

    @Test
    public void shouldCompareUsers() {
        User user1 = new User(1l, "user1@gmail.com", null, true);
        User user2 = new User(2l, "user2@gmail.com", null, true);
        User user1WithDifferentEmail = new User(1l, "user1WithDifferentEmail@gmail.com", null, true);
        User user1WithDifferentId = new User(999l, "user1@gmail.com", null, true);

        assertThat(user1).isNotEqualTo(user2);
        assertThat(user1).isNotEqualTo(user1WithDifferentEmail);
        assertThat(user1).isEqualTo(user1WithDifferentId);
    }

    @Test
    public void deleteTest() {
        List<Integer> a = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        List<Integer> b = Arrays.asList(new Integer[]{0, 1, 2, 3});

        Collection<User> subtract = CollectionUtils.subtract(a, b);
//        Sets.difference(set1, set2);
        List<User> list = ListUtils.removeAll(a, b);

        List<Integer> collect = a.stream()
                .filter(aElem -> !b.contains(aElem))
                .collect(toList());

//        a.removeAll(b);//UnsupportedOperationException
        int i = 1234;
    }

    @Test
    public void del2() {
        Set<Integer> a = new HashSet<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(new Integer[]{0, 1, 2, 3}));
        Set<Integer> aMinusB = Sets.difference(a, b);
        System.out.println(aMinusB);
    }

    @Test
    public void name() {
        HashSet<User> users1 = Sets.newHashSet(
                new User(1l, "user1@gmail.com", null, true),
                new User(2l, "user2@gmail.com", null, true),
                new User(3l, "user3@gmail.com", null, true),
                new User(4l, "user4@gmail.com", null, true),
                new User(5l, "user5@gmail.com", null, true)
        );
        HashSet<User> users2 = Sets.newHashSet(
                new User(1l, "user1@gmail.com", null, true),
                new User(2l, "user2@gmail.com", null, true),
                new User(3l, "user3@gmail.com", null, true)
        );
        Set<User> difference = Sets.difference(users1, users2);
        System.out.println(difference);
    }

    @Test
    public void name2() {
        List<User> users1 = Lists.newArrayList(
                new User(1l, "user1@gmail.com", null, true),
                new User(2l, "user2@gmail.com", null, true),
                new User(3l, "user3@gmail.com", null, true),
                new User(4l, "user4@gmail.com", null, true),
                new User(5l, "user5@gmail.com", null, true)
        );
        List<User> users2 = Lists.newArrayList(
                new User(1l, "user1@gmail.com", null, true),
                new User(2l, "user2@gmail.com", null, true),
                new User(3l, "user3@gmail.com", null, true)
        );
        List list = ListUtils.removeAll(users1, users2);
        System.out.println(list);
        users1.removeAll(users2);
        System.out.println(users1);
//        Set<User> difference = Sets.difference(users1, users2);
//        System.out.println(difference);
    }

    @Test
    public void name3() {
        List<User> users1 = Lists.newArrayList(
                new User(1l, "user1@gmail.com", null, true),
                new User(2l, "user2@gmail.com", null, true),
                new User(3l, "user3@gmail.com", null, true),
                new User(4l, "user4@gmail.com", null, true),
                new User(5l, "user5@gmail.com", null, true)
        );
        List<User> users2 = Lists.newArrayList(
                new User(1l, "user1@gmail.com", null, true),
                new User(2l, "user2@gmail.com", null, true),
                new User(3l, "user3@gmail.com", null, true)
        );

        List<User> newList = users1.stream()
                .filter(users2::contains)
                .collect(toList());
        System.out.println(newList);
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "email")
    @ToString(exclude = "password")
    public class User {
        public static final int PASSWORD_MIN_LENGTH = 4;
        public static final int PASSWORD_MAX_LENGTH = 70;
        private Long id;
        private String email;
        private String password;
        private boolean active;
    }

}
