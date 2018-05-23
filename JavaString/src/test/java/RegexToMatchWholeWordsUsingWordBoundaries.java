import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexToMatchWholeWordsUsingWordBoundaries {
    @Test
    public void regexToMatchOnlyWholeWordInJava() {
        //To run a “whole word only” search using a regular expression,
        // simply place the word between two word boundaries.
        String regex = "\\bjava\\b";
//        String regex = "\\Bjava|java\\B";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        String data1 = "Today, java is object oriented language";
        Matcher matcher = pattern.matcher(data1);
        System.out.println("1------------------");
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " --- ");
            System.out.println(matcher.group());
        }

        String data2 = "Searching in words : javap myjava myjavaprogram";
        Matcher matcher2 = pattern.matcher(data2);
        System.out.println("2------------------");
        while (matcher2.find()) {
            System.out.print("Start index: " + matcher2.start());
            System.out.print(" End index: " + matcher2.end() + " --- ");
            System.out.println(matcher2.group());
        }
    }

    @Test
    public void regexToMatchWordWithNonboundariesInJava() {
//        String regex = "\\B(java|java)\\B";//???
        String regex = "\\Bjava|java\\B";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        String data1 = "Searching in words : javap myjava myjavaprogram";
        Matcher matcher = pattern.matcher(data1);
        System.out.println("1------------------");
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " --- ");
            System.out.println(matcher.group());
        }

//         “\\B” does not match start and end of a word.
        String data2 = "Today, java is object oriented language";
        Matcher matcher2 = pattern.matcher(data2);
        System.out.println("2------------------");
        while (matcher2.find()) {
            System.out.print("Start index: " + matcher2.start());
            System.out.print(" End index: " + matcher2.end() + " --- ");
            System.out.println(matcher2.group());
        }
    }

    @Test
    public void regexToMatchWordIrrespectiveOfBoundaries() {
        //You want to match “java” word in all four places in string
        // “Searching in words : java javap myjava myjavaprogram”
        String data1 = "Searching in words : java javap myjava myjavaprogram";

        String regex = "java";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(data1);
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " --- ");
            System.out.println(matcher.group());
        }
    }
}
