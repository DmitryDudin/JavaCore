import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class ForInJava8Style {

    @Test
    public void forLoopWithIf() {
        /*for (User user : Arrays.asList(new User("a0"))) {
            if (Objects.nonNull(user)) {
                reqisterUser(user);
            }
        }*/
        Arrays.asList(new User())
                .stream()
                .filter(Objects::nonNull)
                .forEach(this::reqisterUser);
    }

    private void reqisterUser(User user) {

    }

    @Test
    public void nestedForEach() {
        /*Set<Authority> authoritySet = new HashSet<>();
        for (User user : Arrays.asList(new User())) {
            for (Authority authority : user.getAuthorities()) {
                //some action on authotio
                authoritySet.add(authority);
            }
        }*/

        Arrays.asList(new User())
                .stream()
                .flatMap(user -> user.getAuthorities().stream())
                .map(authority -> authority.getTitle())
                .collect(toList());
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private class User {
        private String name;
        private List<Authority> authorities;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private class Authority {
        private String title;
    }

}
