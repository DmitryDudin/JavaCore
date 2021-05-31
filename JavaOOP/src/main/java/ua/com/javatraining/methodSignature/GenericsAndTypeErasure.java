package ua.com.javatraining.methodSignature;


import java.io.Serializable;

public class GenericsAndTypeErasure<T extends Serializable> {

    public static void main(String[] args) {

    }


    /*With generic parameters, type erasure changes the effective signature.
    In effect, it may cause a collision with another method that uses
    the upper bound of the generic typeinstead of the generic token.

    Even though the signatures appear different, the compiler cannot statically
    bind the correct method after type erasure.

    We can see the compiler replacing T with the upper bound, Serializable,
    due to type erasure.
    Thus, it clashes with the method explicitly using Serializable.

    We would see the same result with the base type Object when the generic type has no bound.*/

//    public void printElement(T t) {
//        System.out.println("Signature is: printElement(T)");
//    }

    public void printElement(Serializable o) {
        System.out.println("Signature is: printElement(Serializable)");
    }

}
