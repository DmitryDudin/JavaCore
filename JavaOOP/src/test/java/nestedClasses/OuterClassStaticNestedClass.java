package nestedClasses;

public class OuterClassStaticNestedClass {
    private int varOuter;
    private static int staticVarOuter;

    private void nonStaticMeth() {
    }

    private static void staticMeth() {
    }

    OuterClassStaticNestedClass() {

    }

    static class StaticNestedClass {
        int varStaticNested;

        void methodStaticNested() {
            staticVarOuter = 1;
            staticMeth();
        }
    }

    public static void main(String[] args) {
        StaticNestedClass staticNestedClass = new OuterClassStaticNestedClass.StaticNestedClass();
    }
}
