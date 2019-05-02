//import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;
import java.time.zone.ZoneRulesException;
import java.util.*;

public class ZoneDateTimeTest {
//    https://docs.oracle.com/javase/tutorial/datetime/iso/timezones.html

//ZoneOffset in Java       https://www.baeldung.com/java-zone-offset

    @Test
    public void name() {
        LocalDateTime localDateTime = LocalDateTime.now();

        ZonedDateTime utcZonedDateTime = localDateTime.atZone(ZoneId.of(CommonTest.TIME_UTC));
        System.out.println("utcZonedDateTime = " + utcZonedDateTime);

        ZonedDateTime kievZonedDateTime = localDateTime.atZone(ZoneId.of(CommonTest.TIME_ZONE_KIEV));
        System.out.println("kievZonedDateTime = " + kievZonedDateTime);

        ZonedDateTime torrontoZonedDateTime = localDateTime.atZone(ZoneId.of(CommonTest.TIME_ZONE_TORRONTO));
        System.out.println("torrontoZonedDateTime = " + torrontoZonedDateTime);

        kievZonedDateTime.toInstant().toEpochMilli();

    }

    @Test
    public void availableZone() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("available time zones count = " + availableZoneIds.size());

        //sort by zone name
//        ArrayList<String> zones = Lists.newArrayList(availableZoneIds);
//        Collections.sort(zones);

        /*availableZoneIds.stream()
                .sorted()
                .forEach(zone -> {
                    ZoneId zoneId = ZoneId.of(zone);
                    ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
                    ZoneOffset zoneOffset = zonedDateTime.getOffset();
                    String out = String.format("%35s %10s", zone, zoneOffset);
                    System.out.println(out);
                });*/

        //sort by offset
        availableZoneIds.stream()
                .map(zone -> {
                    ZoneId zoneId = ZoneId.of(zone);
                    ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
                    ZoneOffset zoneOffset = zonedDateTime.getOffset();
                    String out = String.format("%35s %10s", zone, zoneOffset);
                    return out;
                })
                .sorted((s1, s2) -> {
                    s1 = StringUtils.normalizeSpace(s1);
                    s2 = StringUtils.normalizeSpace(s2);
                    String[] offset1 = s1.split(" ");
                    String[] offset2 = s2.split(" ");
                    return offset1[1].compareTo(offset2[1]);
                })
                .forEach(System.out::println);

        //---
        // Create a List using the set of zones and sort it.
       /* List<String> zoneList = new ArrayList<String>(allZones);
        Collections.sort(zoneList);

        for (String s : zoneList) {
            ZoneId zone = ZoneId.of(s);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
            String out = String.format("%35s %10s%n", zone, offset);

            // Write only time zones that do not have a whole hour offset
            // to standard out.
            if (secondsOfHour != 0) {
                System.out.printf(out);
            }
    ...
        }
*/
    }

    @Test
    public void timeZone() {
        TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of(CommonTest.TIME_ZONE_TORRONTO));
        String displayName = timeZone.getDisplayName();
        System.out.println(displayName);

        System.out.println(timeZone.getRawOffset());

    }
}
