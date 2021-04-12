package ua.com.javatraining.unobviousGenerics;


public class Person_Erasure implements Comparable<Person_Erasure> {

    private String name;

    @Override
    public int compareTo(Person_Erasure person) {
        return name.compareTo(person.getName());
    }

    /*both methods have same erasure yet neither overrides the other
    public int compareTo(Object person) {
        return toString().compareTo(person.toString());
    }*/

    public String getName() {
        return name;
    }
}
