package nestedClasses;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;

public class OuterClassInnerClass {
    public interface INer {

    }
    private int varOuter;
    private static int staticVarOuter;

    private void nonStaticMeth() {
    }

    private static void staticMeth() {
    }

    OuterClassInnerClass() {

    }

    class InnerClass {
        int  varInner;

        private void nonStaticMeth() {
        }

        void  methodInner() {
            staticVarOuter = 1;
            varOuter = 1;

            nonStaticMeth();
            staticMeth();

            nonStaticMeth();//к какому из обратимся?
            OuterClassInnerClass.this.nonStaticMeth();//а так?
            DataInput dataInputStream = new DataInputStream(new ByteArrayInputStream(new byte[]{1}));
//            dataInputStream.
        }

    }

    public static void main(String[] args) {
        OuterClassInnerClass.InnerClass innerClass = (new OuterClassInnerClass()).new InnerClass();
    }


}


