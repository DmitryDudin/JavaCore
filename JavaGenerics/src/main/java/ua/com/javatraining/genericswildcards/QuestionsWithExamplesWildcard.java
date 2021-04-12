package ua.com.javatraining.genericswildcards;

import java.util.ArrayList;
import java.util.List;

public class QuestionsWithExamplesWildcard {

    public void question1() {
//        Почему в примере ниже compile-time error? Какое значение можно добавить в список nums?
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
//        nums.add(3.14); // compile-time error

//        Если контейнер объявлен с wildcard ? extends, то можно только читать значения.
//        В список нельзя ничего добавить, кроме null.
//        Для того чтобы добавить объект в список нам нужен другой тип wildcard — ? super
    }


    public static <T> T getFirst(List<? super T> list) {
        //        Почему нельзя получить элемент из списка ниже?


//        return list.get(0); // compile-time error
//        Нельзя прочитать элемент из контейнера с wildcard <? super>, кроме объекта класса Object

//        Object object = list.get(0);
        return null;
    }

    public static <T> Object getFirstAnswer(List<? super T> list) {
        return list.get(0);
    }

}
