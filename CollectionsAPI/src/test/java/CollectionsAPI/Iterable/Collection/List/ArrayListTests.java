package CollectionsAPI.Iterable.Collection.List;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListTests {
    private ArrayList<Integer> preparedCollection;

    @Before
    public void prepareCollection() {
        preparedCollection = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            preparedCollection.add(new Integer((int) (Math.random() * 1000)));
        }
        Random randomGenerator = new Random();
        randomGenerator.ints(10, 10, 30).forEach(i -> System.out.println(i));

        int[] arr = new int[]{0, 9, 9};
        int[] arr1 = new int[1];

    }

    @Test
    public void testAddPerformance() {

        System.out.println();
    }
}


//  https://habrahabr.ru/post/237043/
//https://habrahabr.ru/company/luxoft/blog/256877/