import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JujaVebinarTests {

    @Test
    public void sumITest() {
        //сумма всех элементов от 1 до 100 с помощью for
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            result += i;
        }
        assertEquals(5050, result);
    }

    @Test
    public void sumSinFuncTest() {
//сумма всех элементов функции 2*PI*sin((i-1)/100) где i от 1 до 100 с помощью for
        double result = 0;
        for (int i = 1; i <= 100; i++) {
            result += Math.sin(2 * Math.PI * (i - 1) / 100);
        }
        assertEquals(5.23192600354605E-15, result, 0);
    }

    //задачи похожи отличаются только функцией
    //todo ---------------Избыточное решение---------------
//    выделим интерфейс
    interface MyFunction {
        double get(double input);
    }

    //    обьявим функцию высшего порядка и в ней обьявим этот самый цикл
//    Функции высших порядков - такие функции который могут принимать в качестве аргументов и возвращать другие функции
//            Математики такую функцию называют оператором.
    public double sum(int from, int to, MyFunction function) {
        double result = 0;
        for (int i = from; i <= to; i++) {
            result += function.get(i);
        }
        return result;
    }

    //    чтобы воспользоваться этой функцией высшего порядка необходимы функторы
//            функтор (функциональный обьект) - обьект который можно использовать как функцию
    @Test
    public void bothVariantTests() {

        MyFunction summaring = new MyFunction() {// анонимная реализация интерфейса
            @Override
            public double get(double input) {
                return input;
            }
        };
        MyFunction sin = new MyFunction() {
            @Override
            public double get(double input) {
                return Math.sin(2 * Math.PI * (input - 1) / 100);
            }
        };

        double sumResult = sum(1, 100, summaring);
        assertEquals(5050, sumResult, 0.0);
        double sinResult = sum(1, 100, sin);
        assertEquals(5.23192600354605E-15, sinResult, 0.0);
    }

    @Test
    public void sumLambdasTest() {
        MyFunction summaring = (input) -> input;
        MyFunction sin = (input) -> Math.sin(2 * Math.PI * (input - 1) / 100);

        double sumResult = sum(1, 100, summaring);
        assertEquals(5050, sumResult, 0.0);
        double sinResult = sum(1, 100, sin);
        assertEquals(5.23192600354605E-15, sinResult, 0.0);
    }

    //todo -----------List Comparator-------------------
    @Test
    public void listSortingOldClassicTest() {
        List<String> list = new LinkedList<String>() {{
            add("four");
            add("two");
            add("five");
            add("three");
            add("one");
            add("a");
            add("b");
        }};
//обьявляем функтор компаратор
        Comparator<String> firstLetterComparator = new Comparator<String>() {// анонимная реализация интерфейса
            @Override
            public int compare(String o1, String o2) {
                return Character.compare(o1.charAt(0), o2.charAt(0));
            }
        };

//        вызываем функцию высшего порядка для сортировки по правилам компаратора
//        list.sort(firstLetterComparator);
        Collections.sort(list, firstLetterComparator);
        System.out.println(list);

        Comparator<String> maxLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
        Collections.sort(list, maxLengthComparator);
        System.out.println(list);

    }

    @Test
    public void listSortingLambdasTest() {
        List<String> list = new LinkedList<String>() {{
            add("four");
            add("two");
            add("five");
            add("three");
            add("one");
            add("a");
            add("b");
        }};
        Comparator<String> firstLetterComparator = (o1, o2) -> Character.compare(o1.charAt(0), o2.charAt(0));
        Comparator<String> maxLengthComparator = (o1, o2) -> Integer.compare(o1.length(), o2.length());
        Collections.sort(list, firstLetterComparator);
        System.out.println(list);
        Collections.sort(list, maxLengthComparator);
        System.out.println(list);
    }

    //todo ---------------------------------Theory---------------------------------------------------------

//    если лямбда не укладывается в одну строчку то можно использовать операторные скобки и return который должен вернуть значение
//    ()-> {  //тут обязательно должен быть expression - что-то что возвращает значение
//        int a = 1;
//        int b = 2;
//        return a + b;
//    }

    //todo ----------------------------------Callback/Listener----------------------------------
//рассмотрим пример на основе callback шаблона
    static class Button {
        private OnClickListener onClick;

        //клиент может подписаться на это событие
        //OnClickListener - функтор или callback функция
        public void setOnClick(OnClickListener onClick) {
            this.onClick = onClick;
        }

        //        когда произойдет событие click эта функция будет вызвана
        public void click() {
            if (onClick != null) {
                onClick.handle(new ActionEvent("click"));
            }
        }
    }

    //    этот класс передаётся внутрь callback функции и сообщает ей какой конкретно клик произошёл
    static class ActionEvent { // immutable class!!!
        private String name;

        public ActionEvent(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "ActionEvent{" + "name= " + name + '\'' + "}";
        }
    }

    //    это наш функциональный интерфейс
//    функциональный интерфейс - любой интерфейс содержащий 1 абстрактный метод, который не принадлежит классу Object
    @FunctionalInterface
    interface OnClickListener {
        void handle(ActionEvent event);
    }
//    функциональный интерфейс не обязательно помечать аннотацией @FunctionalInterface
//    но появляется дополнительная проверка компилятора

    private String testString;

    @Test
    public void oldPracticTest() {
        Button button = new Button();
        //устанавливаем обработчик события
        button.setOnClick(new OnClickListener() {
            @Override
            public void handle(ActionEvent event) {
                //этот метод отработает когда случится клик
                testString = "on-" + event.getName();
                System.out.println(testString);
            }
        });

        button.click();
        assertEquals("on-click", testString);
    }

    @Test
    public void lambdasPracticTest() {
        Button button = new Button();
        button.setOnClick(
                (event) -> //обьект функционального интерфейса
                {
                    testString = "on-" + event.getName();// реализация метода функционального интерфейса
                    System.out.println(testString);
                });

        button.click();
        assertEquals("on-click", testString);

    }

    //todo ---------------------------------Theory---------------------------------------------------------
//    приведение лямбды к определённому типу функционального интерфейса произойдёт автоматически
//    а тип этого интерфейса будет взят из контекста
//лямбду нельзя привести к Object
    @Test
    public void castLambda() {
        OnClickListener onClickListenerConsumer = (ActionEvent event) -> System.out.println(testString);
//        Object o = (ActionEvent event) -> System.out.println(testString);// ERROR Target type of a lambda conversion must be an interface.
    }

//    40min
}
