import org.junit.Test;

import java.text.DateFormatSymbols;

public class SimpleTests {

    @Test
    public void shouldPringWeekDays() {
        String[] days = new DateFormatSymbols().getWeekdays();
        for (int i = 0; i < days.length; i++) {
            String weekday = days[i];
            System.out.println(weekday);
        }
    }

}
