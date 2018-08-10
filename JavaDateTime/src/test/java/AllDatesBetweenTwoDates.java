import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllDatesBetweenTwoDates {

    @Test
    public void getDatesBetweenUsingJava7() {
        Date date = new Date();
//        Date endDate = new Date(startDate.getTime() +  23*24 * 60 * 60 * 1000);
//        Date endDate = new Date(startDate.getTime());
        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(date);
        endCalendar.add(Calendar.DATE, 200);

        while (calendar.before(endCalendar)) {
            Date result = calendar.getTime();
            datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
            System.out.println(result);
        }

//        return datesInRange;
    }

    @Test
    public void getDatesBetweenUsingJava8() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(100);

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

}
