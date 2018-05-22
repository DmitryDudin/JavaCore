import org.junit.Test;

import java.time.ZoneId;

public class StringJoin {

    @Test
    public void join() {
        String joined = String.join("/", "usr", "local", "bin");
        System.out.println(joined);

        String ids = String.join(", ", ZoneId.getAvailableZoneIds());
        System.out.println(ids);
    }
}
