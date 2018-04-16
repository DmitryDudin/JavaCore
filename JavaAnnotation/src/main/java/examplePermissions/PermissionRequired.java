package examplePermissions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionRequired {  //аннтоация для проверки прав
    Permission value();

    String message();
}
