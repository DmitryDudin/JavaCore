package ua.com.javatraining.matches;

import org.junit.Test;
import ua.com.javatraining.RegexUtils;

import static org.junit.Assert.assertEquals;

public class BoundaryMatchers {

    @Test
    public void whenMatchesAtBeginning() {
        //To match only when the required regex is true at the beginning of the text, we use the caret ^.
        assertEquals(1, RegexUtils.numberOfMatches("^dog", "dogs are friendly"));

        assertEquals(0, RegexUtils.numberOfMatches("^dog", "are dogs are friendly?"));
    }

    @Test
    public void whenMatchesAtEnd() {
        //To match only when the required regex is true at the end of the text, we use the dollar character $.
        assertEquals(1, RegexUtils.numberOfMatches("dog$", "Man's best friend is a dog"));

        assertEquals(0, RegexUtils.numberOfMatches("dog$", "is a dog man's best friend?"));
    }

    @Test
    public void whenMatchesAtWordBoundary() {
        //If we want a match only when the required text is found at a word boundary,
        // we use \\b regex at the beginning and end of the regex:
        assertEquals(1, RegexUtils.numberOfMatches("\\bdog\\b", "a dog is friendly"));

        //The empty string at the beginning of a line is also a word boundary:
        assertEquals(1, RegexUtils.numberOfMatches("\\bdog\\b", "dog is man's best friend"));

        //These tests pass because the beginning of a String, as well as space between one text and another, marks a word boundary,
        // however, the following test shows the opposite:
        assertEquals(0, RegexUtils.numberOfMatches("\\bdog\\b", "snoop dogg is a rapper"));

        //o-word characters appearing in a row does not mark a word boundary,
        // but we can make it pass by changing the end of the regex to look for a non-word boundary:
        assertEquals(1, RegexUtils.numberOfMatches("\\bdog\\B", "snoop dogg is a rapper"));

    }

}
