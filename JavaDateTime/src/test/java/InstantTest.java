import org.junit.Test;

import java.time.Instant;

public class InstantTest {

    @Test
    public void getUtc() {
        Instant instant = Instant.now();
        System.out.println("UTC dateTime = " + instant);
    }

    @Test
    public void getMillisUtc() {
        long epochMilli = Instant.now().toEpochMilli();
        System.out.println("UTC epochMilli = " + epochMilli);
    }
}
