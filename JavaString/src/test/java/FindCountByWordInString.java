import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.*;

public class FindCountByWordInString {
    @Test
    public void shouldReturnMapOfCountsByWords() {
        String text = readFile("FileForWordsSearch.txt");

//        String text = "one two two three three three four four four four five five five five five";
//        String text = "five one two four 1 three three two four five :three five, four  /  . Four five five ";
        text = StringUtils.normalizeSpace(text.toLowerCase().replaceAll("[\\p{Punct}]", " "));
        List<String> words = Arrays.asList(text.split(" "));

//        Map<String, Long> collect = words.stream()
        Map<String, Long> collect = words.stream()
                .collect(groupingBy(word -> word, counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

//        System.out.println(collect);
        printMap(collect);
    }

    private void printMap(Map<String, Long> collect) {
        collect.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });
    }

    protected String readFile(String path) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get("src", "test", "resources", path));
            return new String(encoded, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
