package CollectionsAPI.Iterable.Collection.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;

public class ArrayListTests {
    private static final Logger LOG = LoggerFactory.getLogger(ArrayListTests.class);
    private ArrayList<Integer> preparedCollection;
    int defaultCapacity = 1_000_000;

    //insert in start, middle, finish
    //delete in start, middle, finish
    //get in start, middle, finish

    @Before
    public void prepareCollection() {
        preparedCollection = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            preparedCollection.add(new Integer((int) (Math.random() * 1000)));
        }
//        Random randomGenerator = new Random();
//        randomGenerator.ints(10, 0, 100).forEach(i -> System.out.println(i));
    }

    @Test
    public void initArrayListWithCapacity() {
        ArrayList arrayListWithInitCapacity = new ArrayList(defaultCapacity);
        long startTime = System.nanoTime();
        addElements(arrayListWithInitCapacity, defaultCapacity);
        long finishTime = System.nanoTime();
        long time = (finishTime - startTime) / 1000000;
        long memory = Math.round(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / 1024);
        LOG.info("initArrayListWithCapacity: time={}, \nmemory={} KB", time, memory);
    }

    private void addElements(ArrayList arrayList, int capacity) {
        for (int i = 0; i < capacity * 0.6; i++) {
            arrayList.add(i);
        }

    }

    @Test
    public void initArrayListWithoutCapacity() {
        ArrayList arrayListWithoutInitCapacity = new ArrayList();
        long startTime = System.nanoTime();
        addElements(arrayListWithoutInitCapacity, defaultCapacity);
        long finishTime = System.nanoTime();
        long time = (finishTime - startTime) / 1000000;
        long memory = Math.round(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / 1024d);
        LOG.info("initArrayListWithoutCapacity: time={}, \nmemory={} KB", time, memory);
    }

    @Test
    public void testAddPerformance() {

        System.out.println();
    }
}


//  https://habrahabr.ru/post/237043/
//https://habrahabr.ru/company/luxoft/blog/256877/
//state on quizes
