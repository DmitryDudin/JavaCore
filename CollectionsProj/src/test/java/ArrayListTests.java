import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTests {
    private ArrayList<Integer> preparedCollection;

    @Before
    public void prepareCollection() {
        preparedCollection = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            preparedCollection.add(new Integer((int) (Math.random() * 1000)));
        }
    }

    @Test
    public void testAddPerformance(){


    }
}
