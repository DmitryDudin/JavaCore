import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ConvertStringToDate {

    public static final String TIME_ZONE_KIEV = "Europe/Kiev";
    public static final String TIME_UTC = "UTC";

    @Test
    public void convertStringToDateInISO8601Format() {
        String armisticeDate = "2016-04-04";

        LocalDate aLD = LocalDate.parse(armisticeDate);
        System.out.println("Date: " + aLD);

        String armisticeDateTime = "2016-04-04T11:50";

        LocalDateTime aLDT = LocalDateTime.parse(armisticeDateTime);
        System.out.println("Date/Time: " + aLDT);
    }

    @Test
    public void convertStringToDateInCustomFormats() {

        String anotherDate = "14 Apr 2016";

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate random = LocalDate.parse(anotherDate, df);

        System.out.println(anotherDate + " parses as " + random);
    }

    @Test
    public void toMillisUTCForZone() {
        String dateTime = "2019-04-11T10:15:00";
        String zone = TIME_ZONE_KIEV;
        ZoneId zoneId = ZoneId.of(zone);
        long millis = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                .atZone(zoneId)
                .toInstant()
                .toEpochMilli();
        System.err.println("millis= " + millis);
    }

}
