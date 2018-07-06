import org.junit.Test;

import java.time.LocalDateTime;

public class LocalDateTimeTest {

    @Test
    public void getNow() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime now = " + now);
    }

}
