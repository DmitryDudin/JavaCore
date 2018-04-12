import lombok.Getter;
import lombok.Setter;

@Getter
public enum SpringBaseError {
    ERROR_1 {
        public String getOwnMethod() {
            return "error1OwnMethod";
        }
    },
    ERROR_2 {
        @Override
        public String getOwnMethod() {
            return "eror2OwnMethod";
        }
    },
    SPRING_BASE_ERROR(401, "spring.base.error") {
        @Override
        public String getOwnMethod() {
            return "springBaseError1OwnMethod";
        }
    },

    USER_NOT_FOUND("user.not.found") {
        @Override
        public SpringBaseError opposite() {
            return this == USER_NOT_FOUND ? SPRING_BASE_ERROR : USER_NOT_FOUND;// условно они противоположны
        }

        @Override
        public String getOwnMethod() {
            return "userNotFoundOwnMethod";
        }
    };

    @Setter
    private final int errorCode; // поля можно объявить и не финальными => тогда их можно менять, но по замыслу  enum должен быть константой
    @Setter
    private final String errorMessage;

    SpringBaseError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    SpringBaseError(String errorMessage) {
        errorCode = 0;//default
        this.errorMessage = errorMessage;
    }

    SpringBaseError() {
        errorCode = 0;//default
        this.errorMessage = "default.message";
    }

    public SpringBaseError opposite() {//общий для всех элементов(классов), но можно переопределить => полиморфизм
        return this == ERROR_1 ? ERROR_2 : ERROR_1;
    }

    public abstract String getOwnMethod();//этот метод должны реализовать все элементы(классы)

    public static String staticMethod() {
        return "staticMethodString";
    }
}

//Элементы enum SpringBaseError - это статически доступные экземпляры enum-класса SpringBaseError.

//методы valueOf(), values() не определен в классе java.lang.Enum.
// Вместо этого они автоматически добавляются компилятором на этапе компиляции enum-класса.

//есть возможность добавлять собственные методы как в enum-класс, так и в его элементы:

//С помощью enum в Java можно реализовать иерархию классов, объекты которой
// создаются в единственном экземпляре и доступны статически.
// При этом элементы enum могут содержать собственные конструкторы.

//поля можно объявить и не финальными => тогда их можно менять, но по замыслу  enum должен быть константой

