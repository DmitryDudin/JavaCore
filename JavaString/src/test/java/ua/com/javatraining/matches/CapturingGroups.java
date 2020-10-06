package ua.com.javatraining.matches;

import org.junit.Test;
import ua.com.javatraining.RegexUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class CapturingGroups {

    @Test
    public void capturingGroup() {
        assertEquals(1, RegexUtils.numberOfMatches("\\d\\d", "12"));
        assertEquals(3, RegexUtils.numberOfMatches("\\d\\d", "121212"));

//    Let's use a capturing group that matches only when an input text contains two digits next to each other
        assertEquals(1, RegexUtils.numberOfMatches("(\\d\\d)", "12"));

//      The number attached to the above match is 1, using a back reference to tell the matcher
//      that we want to match another occurrence of the matched portion of the text.
//      This way, instead of:
        assertEquals(2, RegexUtils.numberOfMatches("(\\d\\d)", "1212"));

//        Where there are two separate matches for the input, we can have one match but propagating
//        the same regex match to span the entire length of the input using back referencing:
        assertEquals(1, RegexUtils.numberOfMatches("(\\d\\d)\\1", "1212"));

//        Where we would have to repeat the regex without back referencing to achieve the same result:
        assertEquals(1, RegexUtils.numberOfMatches("(\\d\\d)(\\d\\d)", "1212"));

//      Similarly, for any other number of repetitions, back referencing can make the matcher see the input as a single match:
        assertEquals(1, RegexUtils.numberOfMatches("(\\d\\d)\\1\\1\\1", "12121212"));

//        But if you change even the last digit, the match will fail:
        assertEquals(0, RegexUtils.numberOfMatches("(\\d\\d)\\1\\1\\1", "1213"));
    }

    @Test
    public void namedCapturingGroup() {
        String regex = "(?<sso>[^;]+);(?<tenant>[^/]+)/((?<subtenant>[^/]+)(?:/))?(?<user>[^/]+)";
        Pattern pattern = Pattern.compile(regex);

        //(?<sso>[^;]+)  -  группа для захвата множества символов не-';' (т.е до символа ';')
        // ';' - символ
        //(?<tenant>[^/]+)  -   группа для захвата множества символов не-'/' (т.е до символа '/')
        // '/' - сивол
        //((?<subtenant>[^/]+)(?:/))?  - группа для захвата множества символов не-'/' (т.е до символа '/'),
        //                               (?:X)	  - X, as a non-capturing group
        //                               (?:/)	  - /, as a non-capturing group
        //                               знак ? - означает  once or not at all ({0,1})
        //(?<user>[^/]+)  -  группа для захвата множества символов не-'/' (т.е до символа '/')

        String decodedToken = "SSO_TOKEN;TENANT_ID/USER_ID";
        Matcher matcher = pattern.matcher(decodedToken);

        if (matcher.find()) {
            System.out.println();
            System.out.println(matcher.group("sso"));
            System.out.println(matcher.group("tenant"));
            System.out.println(matcher.group("subtenant"));
            System.out.println(matcher.group("user"));
        }

        String decodedToken2 = "SSO_TOKEN;TENANT_ID/SUBTENANT_ID/USER_ID";
        Matcher matcher2 = pattern.matcher(decodedToken2);
        if (matcher2.find()) {
            System.out.println();
            System.out.println(matcher2.group("sso"));
            System.out.println(matcher2.group("tenant"));
            System.out.println(matcher2.group("subtenant"));
            System.out.println(matcher2.group("user"));
        }

        String token3 = "AQIC5SzEAAA..*;TENANT_ID/SUBTENANT_ID/USER_ID";
        Matcher matcher3 = pattern.matcher(token3);
        if (matcher3.find()) {
            System.out.println();
            System.out.println(matcher3.group("sso"));
            System.out.println(matcher3.group("tenant"));
            System.out.println(matcher3.group("subtenant"));
            System.out.println(matcher3.group("user"));
        }
    }

    @Test
    public void dog() {
        Pattern pattern = Pattern.compile("(dog){3}");
        Matcher matcher = pattern.matcher("dogdogdog_dogdogdogdogdogdog  dogdogdog  dogdogdog");
        int matches = 0;
        if (matcher.find()) {
            matches++;
        }
        System.out.println("matches = " + matches);//1
    }

}
