package ua.com.javatraining.matches;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatcherClassMethods {


    @Test
    public void getIndices() {
        //\In the following test, we will confirm the start and end indices of the match for dog in the input String :
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher = pattern.matcher("This dog is mine");
        matcher.find();

        assertEquals(5, matcher.start());
        assertEquals(8, matcher.end());
    }

    @Test
    public void studyMethods() {
        //Both methods start at the beginning of the input String :
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher = pattern.matcher("dogs are friendly");

        assertTrue(matcher.lookingAt());
        assertFalse(matcher.matches());

        //The matches method will return true in a case like so:
        Pattern pattern2 = Pattern.compile("dog");
        Matcher matcher2 = pattern2.matcher("dog");

        assertTrue(matcher2.lookingAt());
        assertTrue(matcher2.matches());
    }

    @Test
    public void replaceMethods() {
        //eplaceFirst replaces the first occurrence
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher = pattern.matcher("dogs are domestic animals, dogs are friendly");
        String newStr = matcher.replaceFirst("cat");

        assertEquals("cats are domestic animals, dogs are friendly", newStr);


        //Replace all occurrences:
        Pattern pattern2 = Pattern.compile("dog");
        Matcher matcher2 = pattern2.matcher("dogs are domestic animals, dogs are friendly");
        String newStr2 = matcher2.replaceAll("cat");

        assertEquals("cats are domestic animals, cats are friendly", newStr2);
    }

}
