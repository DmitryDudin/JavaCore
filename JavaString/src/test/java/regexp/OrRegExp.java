package regexp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrRegExp {

    @Test
    public void test() {
        String regex = ".*(string1|string2).*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

//        String data1 = "Today, java is object oriented language";
        String data1 = "123412 string2 ";
        Matcher matcher = pattern.matcher(data1);

        System.out.println(matcher.matches());
    }

    @Test
    public void name() {
        String s = "string1, string2, string3";
        System.out.println(s.replaceAll("string1|string2", "blah"));
    }
}
