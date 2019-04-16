import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;

public class ParseDateTime {

    private static final String[] parsePatterns = new String[]{
            "yyyy-MM-dd",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ssXXX",
            "yyyy-MM-dd'T'HH:mm:ss[XXX][X]",
            "EEE, d MMM yyyy",
            "dd-MMM-yyyy",
            "dd/MM/yyyy HH:mm:ss"
    };

    @Test
    public void parse() {

    }

    public static Long toMillisUTC(String dateTime, String... parsePatterns) throws ParseException {
        return DateUtils.parseDate(dateTime, parsePatterns)
                .toInstant()
                .toEpochMilli();
    }

}
