import org.junit.Test;

public class ObjectCreation {

    @Test
    public void createObject() {
        A refB = new B();
        refB.init();

        A refC = new C();
        refC.init();
    }



}

class A {
    static {
        System.err.println("class A static section");
    }

    {
        System.err.println("class A NOTstatic section");
    }

    public A() {
        System.err.println("class A constructor");
    }

    public void init() {
        System.err.println("init A");
    }
}

class B extends A {
    static {
        System.err.println("class B static section");
    }

    {
        System.err.println("class B NOTstatic section");
    }

    public B() {
        System.err.println("class B constructor");
    }

    /*public void init() {
        System.err.println("init B");
    }*/
}

class C extends A {
    static {
        System.err.println("class C static section");
    }

    {
        System.err.println("class C NOTstatic section");
    }

    public C() {
        System.err.println("class C constructor");
    }

    public void init() {
        System.err.println("init C");
    }
}