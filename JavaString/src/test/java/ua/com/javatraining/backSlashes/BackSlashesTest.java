package ua.com.javatraining.backSlashes;

import org.junit.Test;

public class BackSlashesTest {

    @Test
    public void  backSlashesTest() {
//        System.out.println("\some");  does not compile
        System.out.println("\\some");
//        System.out.println("\\\some"); no compile
        System.out.println("\\\\some");// --->   "\\some"
//        System.out.println("\\\\\some"); no compile
        System.out.println("\\\\\\some");


    }
}
