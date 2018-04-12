import org.junit.Test;

public class EnumVsStringConst {

    @Test
    public void print() {
        System.out.println("enum = " + Type.FLOAT);
        System.out.println("class = " + TypeStringConstants.FLOAT);

    }
}
