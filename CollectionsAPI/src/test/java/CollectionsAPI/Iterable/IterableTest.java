package CollectionsAPI.Iterable;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IterableTest {

    private static final Logger LOG = LoggerFactory.getLogger(IterableTest.class);

    @Test
    public void printClass() {
        Iterable iterable = new Iterable() {
            @Override
            public Iterator iterator() {
                return null;
            }
        };

//        iterable.forEach(i -> System.out.println());//default method
//        iterable.spliterator();//default method
        LOG.info(iterable.getClass().getName());

        System.out.println("1- " + iterable.getClass().getName());
        System.out.println("2- " + iterable.getClass().toString());
        System.out.println("3- " + iterable.getClass().getCanonicalName());
        System.out.println("4- " + iterable.getClass().getSimpleName());
        System.out.println("5- " + iterable.getClass().getTypeName());
    }

    @Test
    public void interfaceIterator() {
        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };

//        iterator.forEachRemaining(System.out::println);//default method
//        iterator.remove();//default method


        LOG.info("className= {}", iterator.getClass().getName());
        System.out.println("1- " + iterator.getClass().getName());
        System.out.println("2- " + iterator.getClass().toString());
        System.out.println("3- " + iterator.getClass().getCanonicalName());
        System.out.println("4- " + iterator.getClass().getSimpleName());
    }

    @Test
    public void interfaceSpliterator() {
        Spliterator spliterator = new Spliterator() {

            @Override
            public boolean tryAdvance(Consumer action) {
                return false;
            }

            @Override
            public Spliterator trySplit() {
                return null;
            }

            @Override
            public long estimateSize() {
                return 0;
            }

            @Override
            public int characteristics() {
                return 0;
            }

        };

//        iterator.forEachRemaining(System.out::println);//default method
//        iterator.remove();//default method


        LOG.info("className= {}", spliterator.getClass().getName());
        System.out.println("1- " + spliterator.getClass().getName());
        System.out.println("2- " + spliterator.getClass().toString());
        System.out.println("3- " + spliterator.getClass().getCanonicalName());
        System.out.println("4- " + spliterator.getClass().getSimpleName());
        System.out.println("5- " + spliterator.getClass().getTypeName());

    }

}
