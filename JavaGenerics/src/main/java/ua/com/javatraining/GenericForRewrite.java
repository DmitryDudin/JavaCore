package ua.com.javatraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericForRewrite {

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<Number>();
        numberList.add(Integer.valueOf(3));
        numberList.add(Long.valueOf(3));
        numberList.add(Double.valueOf(3));
        System.out.println("numberList = " + numberList);

        //hack type system !!!!!!!!!!!!!!!!!
        List rawList = numberList;
        rawList.add("some");
        rawList.add(3);
        System.out.println("rawList = " + rawList);

        List<? extends Number> extNumberList = new ArrayList<>();
//        extNumberList.add(Long.valueOf(3));
        List rawNumberList = extNumberList;
        rawNumberList.add("String !!!!");
        rawNumberList.add(3d);
        rawNumberList.add(3L);
        System.out.println("rawNumberList = " + rawNumberList);
    }

    public void covariant() {
        //for reading from collection

        ArrayList<Long> longList = new ArrayList<>();

        List<? extends Number> numberList = longList;

        numberList.add(null);
//        numberList.add(new Object());
//        numberList.add(Long.valueOf(3));
//        numberList.addAll(new ArrayList<Long>());

        Number number = numberList.get(0);

        // List<? extends Object>   ==  List<?>
//        List<? extends Object> extendsObjects1 = new ArrayList<? super Object>();
        List<? extends Object> extendsObjects = new ArrayList<Object>();
        extendsObjects.add(null);
//        extendsObjects.add(new Object());

        List<?> wildcardExtendsObjects = new ArrayList<Object>();
        wildcardExtendsObjects.add(null);
//        wildcardExtendsObjects.add(new Object());

//        ArrayList<? extends Number> numbers = new ArrayList<? extends Long>();
    }

    public void contravariant() {
        //for writing to collection

        List<? super Number> superNumbers = new ArrayList<Number>();

        superNumbers.add(null);
//        superNumbers.add(new Object());
        superNumbers.add(Long.valueOf(3));

        Object object = superNumbers.get(0);
    }

    public void meth() {
        List<? super Number> destinationSuperCollection = null;
        List<? extends Number> sourceExtendsCollection = null;

        Collections.copy(destinationSuperCollection, sourceExtendsCollection);
    }

    public void meth2() {
        List<Object> objList = new ArrayList<Object>();
        objList.add(null);
        objList.add(new Object());
        objList.add(Integer.valueOf(3));
        objList.add(Long.valueOf(3));
    }

    public <T extends Long> void putExtendsValue(T value) {
        Number value1 = value;
        Long value2 = value;
    }

}
