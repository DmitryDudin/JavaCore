package examplePermissions;

@PermissionRequired(value = Permission.USER_MANGEMENT, message = "custom message")
public class UserDeleteAction { //действие, право на выполнение которого мы хотим ограничить

    public static void invoke() {
        System.out.println("User delete action invoke");
    }
}
