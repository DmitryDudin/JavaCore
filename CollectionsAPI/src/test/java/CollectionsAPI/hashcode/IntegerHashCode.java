package CollectionsAPI.hashcode;

import org.junit.Test;

public class IntegerHashCode {

    @Test
    public void hashCodeForString() {
        System.out.println("-1234".hashCode());
        System.out.println(Integer.valueOf(-1234).hashCode());
        System.out.println(((Integer)(-5678)).hashCode());
    }

}
