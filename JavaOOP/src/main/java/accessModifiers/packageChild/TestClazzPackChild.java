package accessModifiers.packageChild;

import accessModifiers.packageParent.Parent;

public class TestClazzPackChild {

    void test() {
        Child child = new Child();
        String childPublic = child.childPublic;
        String childPackage = child.childPackage;
        String childProtected = child.childProtected;
        String parentPublic = child.parentPublic;

        Parent parent = new Parent();
        String parentPublic1 = parent.parentPublic;
    }

}
