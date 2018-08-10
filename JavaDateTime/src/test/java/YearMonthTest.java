import org.junit.Test;

import java.time.YearMonth;

public class YearMonthTest {

    @Test
    public void tst2() {
        YearMonth yearMonthObject = YearMonth.of(2016, 2);
        System.out.println(yearMonthObject.atEndOfMonth());
        System.out.println(yearMonthObject.lengthOfMonth());
    }

}
