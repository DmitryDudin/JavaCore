import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Optional;

public class IfElseOnOptional {

    @Test
    public void oneIfElse() {
//        User user = new User();
        User user = null;

        String result0 = (user != null && user.getName() != null) ? user.getName() : "default";
        System.out.println(result0);
        //
        String result = Optional.ofNullable(user)
                .map(User::getName)
                .orElse("default");
        System.out.println(result);
    }

    @Test
    public void multipleIfElse() {
        //множественный вложенный if-else можно заменить на
        // Optional.ofNullable()
        // .flatMap()
        // .flatMap()
        // .map()
        // .orElse();
    }

    @Test
    public void ifPresent() {
        Optional
//                .ofNullable(null).
                .ofNullable("obj").
                ifPresent(v -> {
            System.out.println(v);
        });
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private class User {
        private String name;
    }

}
