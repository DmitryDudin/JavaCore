package ua.com.javatraining;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WildCardCapture {

    @Test
    public void simpleWildcard() {
        List<?> wildcardList = new ArrayList<>();
//        wildcardList.add(new Object());//not compile --> <?> = <? extends Object>
        wildcardList.add(null);//ok
        wildcardList.add(null);//ok
        wildcardList.add(null);//ok

        System.out.println("wildcardList = " + wildcardList);
    }


}
