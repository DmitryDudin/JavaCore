package examplePermissions;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class MainPermissions {

    public static void main(String[] args) {
        User contentManager = new User().setPermissions(Arrays.asList(Permission.CONTENT_MANAGEMENT));
        User userManager = new User().setPermissions(Arrays.asList(Permission.USER_MANGEMENT));

        Class<?> actionClass = UserDeleteAction.class;
        PermissionRequired permissionRequired = actionClass.getAnnotation(PermissionRequired.class);
        System.out.println("permission message = " + permissionRequired.message());
        System.out.println("permission value = " + permissionRequired.value());
        Annotation[] annotations = actionClass.getAnnotations();

        if (permissionRequired == null) {
            System.out.println("permissions not found");
            return;
        }
        if (contentManager != null && contentManager.getPermissions().contains(permissionRequired.value())) {
            System.out.println("contentManager can delete User");
            UserDeleteAction.invoke();
        }
        if (userManager != null && userManager.getPermissions().contains(permissionRequired.value())) {
            System.out.println("userManager can delete User");
            UserDeleteAction.invoke();
        }
    }
}
