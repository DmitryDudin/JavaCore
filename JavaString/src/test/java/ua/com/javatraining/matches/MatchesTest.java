package ua.com.javatraining.matches;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatchesTest {
    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";

    @Test
    public void test1() {
        System.out.println(EXAMPLE_TEST.matches("\\w.*"));
    }

    @Test
    public void isTrue() {
        // s.matches("true")  -->  returns true if the string matches exactly "true"
        final String regex = "true";
        assertTrue(regex.matches(regex));
        assertFalse("true2".matches(regex));
        assertFalse("True".matches(regex));
        assertFalse(Pattern.compile(regex).matcher("True").matches());
        assertFalse(Pattern.matches(regex, "True"));
    }

    @Test
    public void testIsTrueVersion2() {
        // s.matches("[tT]rue")  -->  returns true if the string matches exactly "true" or "True"
        final String regex = "[tT]rue";
        assertTrue(("true").matches(regex));
        assertFalse(("true2").matches(regex));
        assertTrue(("True").matches(regex));
    }

    @Test
    public void testIsTrueOrYes() {
        // s.matches("[tT]rue|[yY]es")  -->  returns true if the string matches exactly "true" or "True" or "yes" or "Yes"
        final String regex = "[tT]rue|[yY]es";
        assertTrue(("true").matches(regex));
        assertTrue(("yes").matches(regex));
        assertTrue(("Yes").matches(regex));
        assertFalse(("no").matches(regex));
    }

    @Test
    public void testContainsTrue() {
        //s.matches(".*true.*")  -->  returns true if the string contains exactly "true"
        final String regex = ".*true.*";
        assertTrue(("thetruewithin").matches(regex));
        assertFalse(("the-false-within").matches(regex));
    }

    @Test
    public void testIsThreeLetters() {
        // s.matches("[a-zA-Z]{3}")  -->  returns true if the string contains of three letters
        // simpler from for s.matches("[a-Z][a-Z][a-Z]");
        final String regex = "[a-zA-Z]{3}";
        assertTrue(("abc").matches(regex));
        assertFalse(("abcd").matches(regex));
    }

    @Test
    public void testisNoNumberAtBeginning() {
        // s.matches("^[^\\d].*")  -->  returns true if the string does not have a number at the beginning
        final String regex = "^[^\\d].*";
        assertTrue(("abc").matches(regex));
        assertFalse(("1abcd").matches(regex));
        assertTrue(("a1bcd").matches(regex));
        assertTrue(("asdfdsf").matches(regex));

        /*assertTrue(("abc").matches("[^\\d].*"));
        assertFalse(("1abcd").matches("[^\\d].*"));
        assertTrue(("a1bcd").matches("[^\\d].*"));
        assertTrue(("asdfdsf").matches("[^\\d].*"));*/
    }

    @Test
    public void testisIntersection() {
        // s.matches("([\\w&&[^b]])*")  -->  returns true if the string contains a arbitrary number of characters except b
        final String regex = "([\\w&&[^b]])*";
        assertTrue(("1").matches(regex));
        assertFalse(("abcksdfkdskfsdfdsf").matches(regex));
        assertTrue(("skdskfjsmcnxmvjwque484242").matches(regex));
    }

    @Test
    public void testLessThenThreeHundred() {
        // s.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*")  -->  returns true if the string contains a number less than 300
//        [^0-9]  -  A non-digit
//        * - Occurs zero or more times
//        [abc] - Set definition, can match the letter a or b or c.
//        ? - Occurs no or one times
//        {X,Y} - Occurs between X and Y times
//        "[^0-9]*  -->   [12]?  -->   [0-9]{1,2}  -->   [^0-9]*"
        String regex = "[^0-9]*[12]?[0-9]{1,2}[^0-9]*";

//        String regex = "[^0-9][12]?[0-9]{1,2}[^0-9]*";   -  первый должен быть не цифровой символ
//        String regex = "[12]?[0-9]{1,2}[^0-9]*";   -  первый символ должен быть "1 или 2"
//        String regex = "[^0-9]*[12]?[0-9][^0-9]*";  - только двух значные числа, меньше 30
//        String regex = "[^0-9]*[12]?[0-9]{1,2}";  - строка должна заканчиваться числом меньше 300

        assertTrue(("28").matches(regex));
        assertTrue(("288").matches(regex));
        assertFalse(("3288").matches(regex));
        assertFalse(("328 8").matches(regex));
        assertFalse(("328 A").matches(regex));
        assertTrue(("1").matches(regex));
        assertTrue(("99").matches(regex));
        assertFalse(("300").matches(regex));
        assertTrue(("aA219C").matches(regex));
//        assertTrue(("aAaAaAaA219 ").matches(regex));
//        assertTrue(("219 ").matches(regex));
        assertTrue(("219 a").matches(regex));
    }

    @Test
    public void matchesStringAorB() {
// Write a regular expression which matches a text line if this text line contains either the word "Joe" or the word "Jim" or both.
        String s = "humbapumpa jim";
        assertTrue(s.matches(".*(jim|joe).*"));
        s = "humbapumpa jom";
        assertFalse(s.matches(".*(jim|joe).*"));
        s = "humbaPumpa joe";
        assertTrue(s.matches(".*(jim|joe).*"));
        s = "humbapumpa joe jim";
        assertTrue(s.matches(".*(jim|joe).*"));
    }

    @Test
    public void getNewLineTitle() {
//        Finding elements which start in a new line
        String regex = "(\\n\\s*)title";

        Pattern pattern = Pattern.compile(regex);
//        String testString = "\nOne \nTwo \nThree";//todo
        String testString = "\ntitle \nTwo \ntitle";
        Matcher matcher = pattern.matcher(testString);

        System.out.println("testString = \n" + testString);
        System.out.println("---------------");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
