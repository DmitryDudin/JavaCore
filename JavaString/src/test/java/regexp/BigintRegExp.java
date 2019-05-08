package regexp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BigintRegExp {

    @Test
    public void test() {
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

//        String data1 = "Today, java is object oriented language";
        String data1 = "0001234346";
        Matcher matcher = pattern.matcher(data1);
        System.out.println(matcher.matches());
    }

}
