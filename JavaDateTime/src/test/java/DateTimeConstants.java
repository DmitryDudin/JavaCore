import org.junit.Test;

import javax.management.timer.Timer;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DateTimeConstants {

    @Test
    public void millisFor() {
        System.err.println(24*60*60*1000);
        System.err.println(TimeUnit.DAYS.toMillis(1));
        System.err.println(Duration.ofDays(1L).getSeconds());
        System.err.println(Timer.ONE_DAY);
    }
}
