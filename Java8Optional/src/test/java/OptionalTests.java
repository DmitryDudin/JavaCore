import org.junit.Test;

import java.util.Optional;

public class OptionalTests {

    @Test
    public void simple() {
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println("isPresent = " + o.isPresent());
        System.out.println("orElse = " + o.orElse("else Value"));
    }

}
