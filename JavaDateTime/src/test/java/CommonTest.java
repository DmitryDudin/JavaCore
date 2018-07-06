import org.junit.Test;

import java.time.Instant;
import java.util.Date;

public class CommonTest {
    public static final String TIME_ZONE_KIEV = "Europe/Kiev";
    public static final String TIME_UTC = "UTC";
    public static final String TIME_ZONE_TORRONTO = "Canada/Eastern";//GMT-4

    @Test
    public void systemUtc() {
        long millis = System.currentTimeMillis();
        System.out.println("millis = " + millis);

        System.out.println("new Date from millis = " + new Date(millis));
        System.out.println("new Instant from millis = " + Instant.ofEpochMilli(millis));
    }

}
