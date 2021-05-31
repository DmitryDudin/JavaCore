package ua.com.javatraining.methodSignature;

public class VarargParams {

    public static void main(String[] args) {

        System.out.println("1");
        someMethode("one", "two");

        System.out.println("2");
        someMethode("one", "two", "three");

        System.out.println("3");
        someMethode("one", new Object[]{new Object()});


        VarargParams obj = new VarargParams();
        obj.sum(new Object(), new Object());
        obj.sum(new Object(), new Object(), new Object());
        obj.sum(new Object(), new Object[]{new Object()});
    }

    public static void someMethode(Object obj1, Object obj2) {
        System.out.println("someMethode(Object obj1, Object obj2)");
    }

    public static void someMethode(Object obj1, Object... objects) {
        System.out.println("someMethode(Object obj1, Object... objects)");

    }

    /*
    public Number someMethode(Object term1, Object[] term2) {
        // compilation error
    }
    */

    public Number sum(Object term1, Object term2) {
        System.out.println("Adding objects");
        return term1.hashCode() + term2.hashCode();
    }

    public Number sum(Object term1, Object... term2) {
        System.out.println("Adding variable arguments: " + term2.length);
        int result = term1.hashCode();
        for (Object o : term2) {
            result += o.hashCode();
        }
        return result;
    }
}
