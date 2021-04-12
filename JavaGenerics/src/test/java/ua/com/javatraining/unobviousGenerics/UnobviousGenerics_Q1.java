package ua.com.javatraining.unobviousGenerics;

import java.util.stream.BaseStream;

public class UnobviousGenerics_Q1 {

    public static void main(String[] args) {
        Object object = new Binary().get();
        System.out.println(object);
    }
    /*static class BinaryMaine{

        public static void main(String[] args) {
            new Binary().get();
        }
    }*/

}

class Binary{
    public String get() {
        return "string";
    }
}
