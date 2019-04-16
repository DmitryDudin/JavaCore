import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;

public class LocalDateTimeTest {

    @Test
    public void getNow() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime now = " + now);
    }

    @Test
    public void nowUtc() {
//        LocalDateTime.now(ZoneId.of("UTC"));
//        LocalDateTime.now(ZoneId.of("GMT"));
        LocalDateTime.now(Clock.systemUTC());
    }
}
