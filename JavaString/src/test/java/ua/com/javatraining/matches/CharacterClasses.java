package ua.com.javatraining.matches;

import org.junit.Test;
import ua.com.javatraining.RegexUtils;

import static org.junit.Assert.assertEquals;

public class CharacterClasses {

    @Test
    public void numberOfMatches() {
        System.out.println("numberOfMatches = " + RegexUtils.numberOfMatches("one", "one two three one two three"));

        System.out.println("numberOfMatches2 = " + RegexUtils.numberOfMatches(".", "one"));

        System.out.println("numberOfMatches3 = " + RegexUtils.numberOfMatches("foo.", "foofoofoo"));
        System.out.println("numberOfMatches4 = " + RegexUtils.numberOfMatches("foo", "foofoofoo"));
    }

    @Test
    public void orClass() {
        assertEquals(RegexUtils.numberOfMatches("[abc]", "b"), 1);

        assertEquals(RegexUtils.numberOfMatches("[abc]", "cab"), 3);

        assertEquals(RegexUtils.numberOfMatches("[bcr]at", "bat cat rat"), 3);
    }

    @Test
    public void norClass() {
        assertEquals(RegexUtils.numberOfMatches("[^abc]", "g"), 1);

        assertEquals(RegexUtils.numberOfMatches("[^bcr]at", "sat mat eat"), 3);
    }

    @Test
    public void rangeClass() {
        //Matching uppercase letters:
        assertEquals(2, RegexUtils.numberOfMatches("[A-Z]", "Two Uppercase alphabets 34 overall"));

        //Matching lowercase letters:
        assertEquals(26, RegexUtils.numberOfMatches("[a-z]", "Two Uppercase alphabets 34 overall"));

        //Matching both upper case and lower case letters:
        assertEquals(28, RegexUtils.numberOfMatches("[a-zA-Z]", "Two Uppercase alphabets 34 overall"));

        //Matching a given range of numbers:
        assertEquals(2, RegexUtils.numberOfMatches("[1-5]", "Two Uppercase alphabets 34 overall"));

        //Matching another range of numbers:
        assertEquals(1, RegexUtils.numberOfMatches("[30-35]", "Two Uppercase alphabets 34 overall"));
    }

    @Test
    public void unionClass() {
        //The test will only match 6 out of the 9 integers because the union set skips 4, 5, and 6.
        assertEquals(6, RegexUtils.numberOfMatches("[1-3[7-9]]", "123456789"));
    }

    @Test
    public void intersectionClass() {
        //We get 4 matches because the intersection of the two sets has only 4 elements.
        //3,4,5,6
        assertEquals(4, RegexUtils.numberOfMatches("[1-6&&[3-9]]", "123456789"));
    }

    @Test
    public void subtractionClass() {
        //Only 1,3,5,7,9 will be matched.
        assertEquals(5, RegexUtils.numberOfMatches("[0-9&&[^2468]]", "123456789"));
    }

}
