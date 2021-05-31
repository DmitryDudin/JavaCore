package accessModifiers.packageParent;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Parent {

    private String parentPrivate;
    public String parentPublic;
    protected String parentProtected;
    String parentPackage;

}
