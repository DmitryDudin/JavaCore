import org.junit.Test;

import java.time.Clock;
import java.time.Instant;

public class NowUtcMillis {

    @Test
    public void name() {
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(Clock.systemUTC().millis());
    }

}
