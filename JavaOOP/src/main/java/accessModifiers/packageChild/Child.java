package accessModifiers.packageChild;

import accessModifiers.packageParent.Parent;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;

@NoArgsConstructor
public class Child extends Parent {

    private String childPrivate;
    public String childPublic;
    protected String childProtected;
    String childPackage;

    void someMethod() {
        String parentPublic = super.parentPublic;

        String parentProtected = super.parentProtected;

//        super.parentPackage;//compilation error
        HashSet<String> set = new HashSet();
        ArrayList<String> lidt = new ArrayList<>();
//        lidt.add
//        Collections.syn
    }

    protected class some {
        long id;
    }
}
