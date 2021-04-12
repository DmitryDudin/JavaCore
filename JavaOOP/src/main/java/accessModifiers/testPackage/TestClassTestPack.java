package accessModifiers.testPackage;

import accessModifiers.packageChild.Child;

public class TestClassTestPack {

    void test() {
        Child child = new Child();
        String childPublic = child.childPublic;
        String parentPublic = child.parentPublic;
    }

}
