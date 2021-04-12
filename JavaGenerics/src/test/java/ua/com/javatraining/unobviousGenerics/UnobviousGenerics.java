package ua.com.javatraining.unobviousGenerics;


import org.junit.Test;

import java.lang.reflect.Method;
import java.util.stream.Stream;

public class UnobviousGenerics {

    @Test
    public void integerGetClassNotCompile() {
        Class<Integer> intClazz = Integer.class;
        System.out.println("intClazz = " + intClazz);

        Integer i = 2016;
        System.out.println("i.getClass() = " + i.getClass());
//        Class<Integer> iClazz= i.getClass();//not compile
    }

    @Test
    public void integerGetClassNotCompile2() {
        Number numVar = Integer.valueOf(3);
        final Class<? extends Number> numClazz = numVar.getClass();
    }

    @Test
    public void printBridgeMethod() {
        class Person<T> {
            public int compareTo(T o) {
                return 0;
            }
        }

//выведет public int compareTo(java.lang.Object)
        Stream.of(Person.class.getDeclaredMethods())
                .forEach(System.out::println);
    }

    @Test
    public void printBridgeMethodWithComparable() throws NoSuchMethodException {
        class Person implements Comparable<Person> {
            @Override
            public int compareTo(Person o) {
                return 0;
            }
        }

//public int compareTo(Person)
//public int compareTo(Object)
        Stream.of(Person.class.getDeclaredMethods())
                .forEach(System.out::println);

        Method meth1 = Person.class.getMethod("compareTo", Person.class);
        Method meth2 = Person.class.getMethod("compareTo", Object.class);
        System.out.println("meth1.isSynthetic() = " + meth1.isSynthetic());//false
//if isSynthetic())=true means that method was generated by compiler
        System.out.println("meth2.isSynthetic() = " + meth2.isSynthetic());//true

    }


}