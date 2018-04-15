package polymorphism;

import org.junit.Test;

public class PolymorphismTests {

    @Test
    public void test() {
        A refB = new B();
    }
}

class A {

    public A() {
        System.err.println("class A constructor");
        init();
    }

    public void init() {
        System.err.println("init A");
    }
}

class B extends A {

    public B() {
        System.err.println("class B constructor");
    }

    public void init() {
        System.err.println("init B");
    }
}