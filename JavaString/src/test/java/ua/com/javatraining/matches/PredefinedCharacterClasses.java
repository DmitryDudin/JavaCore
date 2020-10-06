package ua.com.javatraining.matches;

import org.junit.Test;
import ua.com.javatraining.RegexUtils;

import static org.junit.Assert.assertEquals;

public class PredefinedCharacterClasses {


    @Test
    public void predefinedCharacterClasses() {
//        Matching digits, equivalent to [0-9]:
        assertEquals(3, RegexUtils.numberOfMatches("\\d", "123"));

//        Matching non-digits, equivalent to [^0-9]:
        assertEquals(2, RegexUtils.numberOfMatches("\\D", "a6c"));

//        Matching white space:
        assertEquals(1, RegexUtils.numberOfMatches("\\s", "a c"));

//        Matching non-white space:
        assertEquals(2, RegexUtils.numberOfMatches("\\S", "a c"));

//        Matching a word character, equivalent to [a-zA-Z_0-9]:
        assertEquals(2, RegexUtils.numberOfMatches("\\w", "hi!"));

//        Matching a non-word character:
        assertEquals(1, RegexUtils.numberOfMatches("\\W", "hi!"));
    }

}
