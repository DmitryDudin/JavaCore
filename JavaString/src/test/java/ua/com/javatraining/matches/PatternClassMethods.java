package ua.com.javatraining.matches;

import org.junit.Test;
import ua.com.javatraining.RegexUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class PatternClassMethods {

    @Test
    public void patternCanonEq() {
        //Consider the accented Unicode character é. Its composite code point is u00E9. However, Unicode also has a separate code point for its component characters e, u0065 and the acute accent, u0301. In this case, composite character u00E9 is indistinguishable from the two character sequence u0065 u0301.

        //By default, matching does not take canonical equivalence into account:
        assertEquals(0, RegexUtils.numberOfMatches("\u00E9", "\u0065\u0301"));

        //But if we add the flag, then the test will pass:
        assertEquals(1, RegexUtils.numberOfMatches("\u00E9", "\u0065\u0301", Pattern.CANON_EQ));
    }


    @Test
    public void patternCaseInsensitive() {
        //By default matching takes case into account:
        assertEquals(0, RegexUtils.numberOfMatches("dog", "This is a Dog"));

        //So using this flag, we can change the default behavior:
        assertEquals(1, RegexUtils.numberOfMatches("dog", "This is a Dog", Pattern.CASE_INSENSITIVE));

        //We can also use the equivalent, embedded flag expression to achieve the same result:
        assertEquals(1, RegexUtils.numberOfMatches("(?i)dog", "This is a Dog"));
    }

    @Test
    public void patternComments() {
        assertEquals(0, RegexUtils.numberOfMatches("dog$  #check for word dog at end of text", "This is a dog"));

        //when we use the flag, it will ignore the extra spaces
        // and the every text starting with # will be seen as a comment to be ignored for each line:
        assertEquals(1, RegexUtils.numberOfMatches("dog$  #check end of text", "This is a dog", Pattern.COMMENTS));

        //There is also an alternative embedded flag expression for this:
        assertEquals(1, RegexUtils.numberOfMatches("(?x)dog$  #check end of text", "This is a dog"));
    }

    @Test
    public void patternDotAll() {
        //We will understand better with the following examples.
        // These examples will be a little different.
        // Since we are interested in asserting against the matched String,
        // we will use matcher‘s group method which returns the previous match.


        //First, we will see the default behavior:
        //As we can see, only the first part of the input before the line terminator is matched.
        Pattern pattern = Pattern.compile("(.*)");
        Matcher matcher = pattern.matcher(
                "this is a text" + System.getProperty("line.separator") + " continued on another line");
        matcher.find();

        assertEquals("this is a text", matcher.group(1));

        //Now in dotall mode, the entire text including the line terminator will be matched:
        Pattern pattern2 = Pattern.compile("(.*)", Pattern.DOTALL);
        Matcher matcher2 = pattern2.matcher(
                "this is a text" + System.getProperty("line.separator") + " continued on another line");
        matcher2.find();
        assertEquals(
                "this is a text" + System.getProperty("line.separator") + " continued on another line",
                matcher2.group(1));

        //We can also use an embedded flag expression to enable dotall mode:
        Pattern pattern3 = Pattern.compile("(?s)(.*)");
        Matcher matcher3 = pattern3.matcher(
                "this is a text" + System.getProperty("line.separator") + " continued on another line");
        matcher3.find();

        assertEquals(
                "this is a text" + System.getProperty("line.separator") + " continued on another line",
                matcher3.group(1));
    }

    @Test
    public void patterLiteral() {
        //Without this flag, the matcher will match the following regex against any input String:
        assertEquals(2, RegexUtils.numberOfMatches("(.*)", "text"));

        //This is the default behavior we have been seeing in all the examples.
        // However, with this flag, no match will be found, since the matcher will be looking for (.*) instead of interpreting it:
        assertEquals(0, RegexUtils.numberOfMatches("(.*)", "text", Pattern.LITERAL));

        //Now if we add the required string, the test will pass:
        assertEquals(1, RegexUtils.numberOfMatches("(.*)", "text(.*)", Pattern.LITERAL));
    }

    @Test
    public void patternMultiLine() {
        //By default ^ and $ metacharacters match absolutely at the beginning
        //and at the end respectively of the entire input String.
        //The matcher disregards any line terminators.
        //The match fails because the matcher searches for dog at the end of the entire String
        // but the dog is present at the end of the first line of the string.
        assertEquals(0,
                RegexUtils.numberOfMatches(
                        "dog$", "This is a dog" + System.getProperty("line.separator") + "this is a fox"
                )
        );

        //However, with the flag, the same test will pass since the matcher now takes into account line terminators.
        // So the String dog is found just before the line terminates, hence success:
        assertEquals(0,
                RegexUtils.numberOfMatches(
                        "dog$", "This is a dog" + System.getProperty("line.separator") + "this is a fox"
                ),
                Pattern.MULTILINE
        );

        //Here is the embedded flag version:
        assertEquals(1,
                RegexUtils.numberOfMatches(
                        "(?m)dog$", "This is a dog" + System.getProperty("line.separator") + "this is a fox"
                )
        );

    }
}
