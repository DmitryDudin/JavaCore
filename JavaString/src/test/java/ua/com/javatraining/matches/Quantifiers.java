package ua.com.javatraining.matches;

import org.junit.Test;
import ua.com.javatraining.RegexUtils;

import static org.junit.Assert.assertEquals;

public class Quantifiers {


    @Test
    public void zeroOrOneQuantifier() {
        //about \\a:
        //where a appears, the example is focused on quantifiers,
        // am sure you can replace it with a string literal and the example will still be valid

        //To match a text zero or one time, we use the ? quantifier:
        assertEquals(1, RegexUtils.numberOfMatches("\\a?", ""));
        assertEquals(1, RegexUtils.numberOfMatches("a?", ""));
        assertEquals(3, RegexUtils.numberOfMatches("\\a?", "hi"));

        /*
                             why 3 ????????????
        This example introduces the concept of zero-length matches.
        It so happens that if a quantifier's threshold for matching is zero,
        it always matches everything in the text including an empty String at the end of every input.
        This means that even if the input is empty, it will return one zero-length match.

        This explains why we get 3 matches in the above example despite having a String of length two.
        The third match is zero-length empty String.
        */

//        Alternatively, we can use the brace syntax {x,y}, also supported by the Java regex API:
        assertEquals(3, RegexUtils.numberOfMatches("\\a{0,1}", "hi"));
    }

    @Test
    public void zeroOrManyQuantifier() {
//        To match a text zero or limitless times, we us * quantifier, it is just similar to ?:
        assertEquals(3, RegexUtils.numberOfMatches("\\a*", "hi"));

//        Supported alternative:
        assertEquals(3, RegexUtils.numberOfMatches("\\a{0,}", "hi"));
    }

    @Test
    public void oneOrManyQuantifier() {
//        The quantifier with a difference is +, it has a matching threshold of 1.
//        If the required String does not occur at all, there will be no match, not even a zero-length String:
        assertEquals(0, RegexUtils.numberOfMatches("\\a+", "hi"));

//        Supported alternative:
        assertEquals(0, RegexUtils.numberOfMatches("\\a{1,}", "hi"));
    }

    @Test
    public void braceQuantifier() {
//        the brace syntax can be used to match a given text a number of times:
        assertEquals(2, RegexUtils.numberOfMatches("a{3}", "aaaaaa"));

        assertEquals(0, RegexUtils.numberOfMatches("a{3}", "aa"));
    }

    @Test
    public void braceQuantifierWithRange() {
        assertEquals(1, RegexUtils.numberOfMatches("a{2,3}", "aaaa"));
    }

    @Test
    public void braceQuantifierWithRangeWhenMatchesLazily() {
//        However, the API allows us to specify a lazy or reluctant approach such that the matcher can start from the lower
//        end of the range in which case matching two occurrences as aa and aa:
        assertEquals(2, RegexUtils.numberOfMatches("a{2,3}?", "aaaa"));
    }

}
