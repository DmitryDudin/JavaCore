package CollectionsAPI;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class MergeCollections {

    @Test
    public void mergeWithStream() {
        List<String> collection1 = Arrays.asList("1", "2", "3");
        List<String> collection2 = Arrays.asList("4", "5");
        Set<String> merge = Stream.concat(collection1.stream(), collection2.stream())
                .collect(toSet());
        System.out.println(merge);
    }

    @Test
    public void mergeWithStreamThroughFlatMap() {
        Set<String> newStringSet = Sets.newHashSet("1", "2", "3");
        Set<String> oldStringSet = Sets.newHashSet("4", "5");
        Set<String> combined = Stream.of(newStringSet, oldStringSet).flatMap(Set::stream)
                .collect(toSet());
        System.out.println(combined);
    }

    @Test
    public void couldEasilyBeCombinedWithSingleElement() {
        Set<String> newStringSet = Sets.newHashSet("1", "2", "3");
        Set<String> combined = Stream.concat(newStringSet.stream(), Stream.of("4"))
                .collect(toSet());
        System.out.println(combined);
    }

}
