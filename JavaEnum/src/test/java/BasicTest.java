import org.junit.Test;

import java.util.Arrays;

public class BasicTest {

    @Test
    public void printText() {
        System.out.println("enum: " + SpringBaseError.SPRING_BASE_ERROR);
        System.out.println("name: " + SpringBaseError.SPRING_BASE_ERROR.name());
        System.out.println("toString: " + SpringBaseError.USER_NOT_FOUND.toString());
        System.out.println("ordinal: " + SpringBaseError.SPRING_BASE_ERROR.ordinal());
        System.out.println("spring_base_error class:   " + SpringBaseError.SPRING_BASE_ERROR.getClass());
        System.out.println("spring_base_error superClass:   " +
                SpringBaseError.SPRING_BASE_ERROR.getClass().getSuperclass());
        System.out.println("spring_base_error super-super-Class:   " +
                SpringBaseError.SPRING_BASE_ERROR.getClass().getSuperclass().getSuperclass());
        System.out.println("-----------------------------------------------");
        System.out.println("type class: " + Type.FLOAT.getClass());
        System.out.println("type superClass: " + Type.FLOAT.getClass().getSuperclass());
        System.out.println("-----------------------------------------------");
        System.out.println("staticMethod = "+SpringBaseError.staticMethod());
    }

    @Test
    public void enumCopare() {
        SpringBaseError error = SpringBaseError.SPRING_BASE_ERROR;
        System.out.println("compare with '=='  -  " + (error == SpringBaseError.SPRING_BASE_ERROR));
    }

    @Test
    public void enumFieldsGetterSetter() {
        System.out.println("spring_base_errorcode = " + SpringBaseError.SPRING_BASE_ERROR.getErrorCode());
        System.out.println("spring_base_errormessage =  " + SpringBaseError.SPRING_BASE_ERROR.getErrorMessage());
//        System.out.println("compare with '=='  -  " + (error == SpringBaseError.SPRING_BASE_ERROR));
    }

    @Test
    public void getEnumByString() {
        SpringBaseError error = SpringBaseError.valueOf("USER_NOT_FOUND");
        System.out.println(error);
        System.out.println(error.getErrorCode());
        System.out.println(error.getErrorMessage());
    }

    @Test
    public void switchByEnum() {
        SpringBaseError enumType = SpringBaseError.ERROR_1;
        switch (enumType) {
            case ERROR_1:
                System.out.println(SpringBaseError.ERROR_1);
                break;
            case ERROR_2:
                System.out.println(SpringBaseError.ERROR_2);
                break;
            case USER_NOT_FOUND: {
                System.out.println(SpringBaseError.USER_NOT_FOUND);
                break;
            }
            case SPRING_BASE_ERROR: {
                System.out.println(SpringBaseError.SPRING_BASE_ERROR);
                break;
            }
            default:
                break;
        }
    }

    @Test
    public void printAll() {
        System.out.println(Arrays.toString(SpringBaseError.values()));
    }

    @Test
    public void customMethod() {
        System.out.println(SpringBaseError.ERROR_1.opposite());
        System.out.println(SpringBaseError.USER_NOT_FOUND.opposite());// полиморфизм

        System.out.println("error1 own method = " + SpringBaseError.ERROR_1.getOwnMethod());

    }


}

