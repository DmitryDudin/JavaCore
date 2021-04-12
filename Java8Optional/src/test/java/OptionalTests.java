import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Objects;
import java.util.Optional;

public class OptionalTests {

    @Test
    public void simple() {
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println("isPresent = " + o.isPresent());
        System.out.println("orElse = " + o.orElse("else Value"));
    }

    @Test
    public void checkIfNull() {
        User user = new User();
        ifMethode(user);
        objectsMethode(user);
    }

    private User objectsMethode(User user) {
        return Objects.requireNonNull(user);
    }

    private User ifMethode(User user) {
        if (user == null) {
            throw new NullPointerException();
        }
        return user;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private class User {
        private String name;
    }
}
