import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.StringTokenizer;

public class RegexExamples {

    @Test
    public void name() {
        String str = "aaAA, ФФФ,  . bBBb ЦЦц cc DDD ee  FFff  ЯЯЯЯяя !@#$%^&*?/,.<> L&M";
        System.out.println(str);
        System.out.println("1--------------------------");
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        System.out.println(stringTokenizer.countTokens());
//        while (stringTokenizer.hasMoreTokens()) {
//            System.out.println(stringTokenizer.nextToken());
//        }

        System.out.println("2--------------------------");
        String[] split = str.split(" ");
        System.out.println(Arrays.toString(split));

        System.out.println("3--------------------------");
        System.out.println(str.toLowerCase().replaceAll("[^a-zа-я]+", " "));
        String s = StringUtils.normalizeSpace(str
                .toLowerCase()
                .replaceAll("[^a-zа-я]+", " "));
        String[] split1 = s.split(" ");
        System.out.println(Arrays.toString(split1));
        System.out.println("4--------------------------");
        System.out.println(str.toLowerCase().replaceAll("[^a-zа-я&]+", " "));
        System.out.println(str.toLowerCase().replaceAll("[^a-zа-я]+", ""));
        System.out.println(str.toLowerCase().replaceAll("[\\p{Punct}]", " "));
        System.out.println(StringUtils.normalizeSpace(str.toLowerCase().replaceAll("[\\p{Punct}]", " ")));
        System.out.println("5--------------------------");
        System.out.println(Arrays.toString(str.toLowerCase().replaceAll("[^a-zа-я]+", "").split("\\s+")));

        System.out.println("6--------------------------");

    }
}
