package ua.com.javatraining.unobviousGenerics;


public class CompileOrNotCompile {

    static  <T> void setFirst(T[] arr, T var) {
        arr[0] = var;//ArrayStoreException
    }

    static  <T, S extends T> void setFirst2(T[] arr, S var) {
        arr[0] = var;//ArrayStoreException java 8
    }

    public static void main(String[] args) {

        //compile ok because arrays are covariant
        setFirst(new String[3], Integer.valueOf(1));//
        //использовать дженерики с массивами - всегда плохая идея

//        setFirst2(new String[3], Integer.valueOf(1));//compile error java 7
        setFirst2(new String[3], Integer.valueOf(1));//compile ok java 8

    }



}
