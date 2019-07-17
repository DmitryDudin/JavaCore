package CollectionsAPI;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class PartitioningCollections {

/*

 Partition a List in Java
 https://www.baeldung.com/java-list-split

 Divide a list to lists of n size in Java 8
 https://e.printstacktrace.blog/divide-a-list-to-lists-of-n-size-in-Java-8/

*/

    @Test
    public void name() {
        final AtomicInteger counter = new AtomicInteger();
        List<String> someCollection = IntStream.range(0, 33)
                .mapToObj(String::valueOf)
                .collect(toList());

        Collection<List<String>> chunks = someCollection.stream()
//                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 30_000, toSet()))
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 10, toList()))
                .values();
        System.out.println(chunks);
    }

    @Test
    public void name2() {
        Set<String> someCollection = IntStream.range(0, 12)
                .mapToObj(String::valueOf)
                .collect(toSet());

        Iterable<List<String>> partition = Iterables.partition(someCollection, 5);
        System.out.println(partition);
    }

    @Test
    public void name3() {
        List<String> someCollection = IntStream.range(0, 12)
                .mapToObj(String::valueOf)
                .collect(toList());
        List<List<String>> partition = Lists.partition(someCollection, 4);
        System.out.println(partition);
    }

}
