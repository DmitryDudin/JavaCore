import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatchWordWithAllMisspellings {
    @Test
    public void match() {
        String content = "This is may calandar. This is june calander. This is may calendar.";
        String regex = "c[ae]l[ae]nd[ae]r";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
    }
}
