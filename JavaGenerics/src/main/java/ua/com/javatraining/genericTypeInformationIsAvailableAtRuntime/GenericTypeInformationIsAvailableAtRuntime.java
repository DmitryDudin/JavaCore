package ua.com.javatraining.genericTypeInformationIsAvailableAtRuntime;

public class GenericTypeInformationIsAvailableAtRuntime {

//todo
    class Barsik implements Voice<Cat> {
        @Override
        public Cat voice() {
            return null;
        }
    }


    interface Voice<T> {
        public T voice();
    }

    class Cat {
        public void voice() {
            System.out.println("    ------ sound Cat!!!");
        }
    }

    class Dog {
        public void voice() {
            System.out.println("    ------ sound Dog!!!");
        }
    }

}
