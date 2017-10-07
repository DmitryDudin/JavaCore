import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.*;

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

    static class ButtonJava8 {
        private Consumer<ActionEvent> onClick;

        public void setOnClick(Consumer<ActionEvent> onClick) {
            this.onClick = onClick;
        }

        public void click() {
            if (onClick != null) {
                onClick.accept(new ActionEvent("click with consumer"));
            }
        }
    }

    @Test
    public void lambdasWithFuncInterfaceTest() {
        ButtonJava8 buttonJava8 = new ButtonJava8();
        buttonJava8.setOnClick(event -> {
            testString = "on-" + event.getName();// реализация метода функционального интерфейса
            System.out.println(testString);
        });
        buttonJava8.click();
        assertEquals("on-click with consumer", testString);
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

    //todo ---------------------------------Functional Interfaces---------------------------------------------------------

//    как правило лямбду передают в качестве параметра


//    interface Consumer<T>  - потребитель
//           void accept(T t);

//    interface Runnable
//    public abstract void run();


    @Test
    public void runnableFuncInterfaceTest() {
        Runnable functor = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Second THREAD " + i);
            }
        };
        new Thread(functor).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main THREAD " + i);
        }
    }

//    interface IntBinaryOperator
//    int applyAsInt(int left, int right);

    @Test
    public void intBinaryOperatorTest() {
        IntBinaryOperator intBinaryOperator = (int from, int to) -> {
            int result = 0;
            for (int i = from; i <= to; i++) {
                result += i;
            }
            return result;
        };
        int applyAsInt = intBinaryOperator.applyAsInt(0, 10);
        assertEquals(55, applyAsInt);
    }

//    interface BiConsumer<T, U>
//    void accept(T t, U u);

    @Test
    public void biconsumerTest() {
        BiConsumer functor = (first, second) -> {
            //ww incoming parameters
            System.out.println(first + "  " + second);
        };
        functor.accept("Good day", new ActionEvent("click"));
    }

//    interface BiFunction<T, U, R>
//        R apply(T t, U u);

    @Test
    public void bifunctionTest() {
        BiFunction functor = (x, y) -> {
            return x + " " + y;
        };
        Object result = functor.apply("Good", "Day");
        System.out.println(result);
    }


//    interface Comparator<T>
//    int compare(T o1, T o2)

//    interface Comparable<T>   - не является функуиональным интерфейсом!!!!
//    public int compareTo(T o);
//    не помечен функциональным интерфейсом потому что нет смысла импользовать в этом механизме лямбды.
//    Этот интерфейс указывает на то, что обьект  должен реализовать сравнение себя с себе подобным
//    и является неотьемлемой частью обьекта, а не используется как функтор.
//    Но вместе с тем можно это сделать.

//    interface Consumer<T>
//        void accept(T t);   (Object)->void
//можно выстраивать цепочки с помощью andThen

//    Runnable
//      ()-> void

//    java.util.concurrent.Callable
//       V call() throws Exception;   ()->Object (or Exception)

//    java.io.FileFilter
//      boolean accept(File pathname);
//    java.io.FilenameFilter
//      boolean accept(File dir, String name);


//    interface BinaryOperator<T> extends BiFunction<T,T,T>
//      (Object, Object) -> Object
//       T  apply(T t, T  u);
//    бинарный оператор - такой оператор, который применяется к двум операндам, например  a+в


//    interface UnaryOperator<T> extends Function<T, T>
//      (Object) -> Object
//       T  apply(T t);
//    унарный оператор - такой оператор, который применяется к одному операнду, например  +a


//    public interface Predicate<T> {
//        boolean test(T t);  (Object)->boolean
//Predicate - функции принимающие один аргумент, и возавращающие значение типа boolean
//    Интерфейс содержит различные методы по умолчанию, позволяющие строить сложные условия (and, or, negate).


//    interface Function<T, R>
//        R apply(T t);
//Function - функции принимают один аргумент  и возвращают некоторый результат.
//    Методы по умолчанию могут использоваться для построения цепочек вызовов (compose, andThen).


//    public interface Supplier<T>
//        T get();  ()-> Object
//   на Suppier очень удобно сделать FactoryMethod


//    существует множество функциональных интерфейсов, которые перегружены для примитивов
//    double, int, long


//    interface ToDoubleBiFunction<T, U>
//    double applyAsDouble(T t, U u);

//todo ---------------------- Функции высших порядков и каррирование (carrying) --------------------//

    String log = null;

    @Test
    public void Test_Lambda_Biconsumer_wth_Intconsumer() {
        BiConsumer<IntSupplier, IntConsumer> copy = (intSupplier, intConsumer) -> {
            intConsumer.accept(intSupplier.getAsInt());
        };

        copy.accept(() -> 24,
                (result) -> log = String.valueOf(result));
        assertEquals("24", log);
    }

//    Функции высшего порядка не только принимают функторы на вход,
//    но и могут возвращать функции на выход.

    @Test
    public void TestLambda_functionReturnsFunction() {
//        Function -   R apply(T t);
//        IntUnaryOperator  - int applyAsInt(int operand);
//        IntBinaryOperator  - int applyAsInt(int left, int right);


        //смотри стока 41 функция sum
        Function<IntUnaryOperator, IntBinaryOperator> sum =
                (functor) ->
//              functor - IntUnaryOperator
//               (int from, int to) -> {} -  IntBinaryOperator
                        (int from, int to) -> {                 //IntBinaryOperator
                            int result = 0;                     //
                            for (int i = from; i <= to; i++) {  //
                                result += functor.applyAsInt(i);//
                            }                                   //
                            return result;                      //
                        };

        assertEquals(55, sum.apply((i) -> i).applyAsInt(0, 10));
//        IntBinaryOperator intBinaryOperator = sum.apply((i) -> i);
//        int result = intBinaryOperator.applyAsInt(0, 10);

        //        functor  -  (i) -> i
        assertEquals(20100, sum.apply((i) -> i).applyAsInt(0, 200));

//        functor  -  (i % 2 == 0) ? -i : i
        assertEquals(-100, sum.apply((i) -> (i % 2 == 0) ? -i : i).applyAsInt(1, 200));
    }

//    На этом принципе построено каррирование  - carrying.
//    функции высших порядков позволяют импользовать карринг - преобразование функции от N аргументов в функцию,
//    берущую свои аргументы по одному, т.е. мы преобразовали функцию типа
//    sum(int from, int to, MyFunction function)   ---->   sum.apply(function).applyAsInt(int from, int to)

    @Test
    public void carryingTest() {
        Function<IntUnaryOperator, IntFunction<IntUnaryOperator>> sum =
                (functor) ->
                        (int from) ->
                                (int to) -> {
                                    int result = 0;
                                    for (int i = from; i <= to; i++) {
                                        result += functor.applyAsInt(i);
                                    }
                                    return result;
                                };

//        IntFunction<IntUnaryOperator> step1 = sum.apply(i -> i);
//        IntUnaryOperator step2 = step1.apply(1);
//        int result = step2.applyAsInt(10);
        assertEquals(55, sum.apply(i -> i).apply(1).applyAsInt(10));
    }

    // изменим порядок функций
    @Test
    public void reversCarryingTest() {

        IntFunction<IntFunction<ToIntFunction<IntUnaryOperator>>> sum =
                (int from) ->
                        (int to) ->
                                (functor) -> {
                                    int result = 0;
                                    for (int i = from; i <= to; i++) {
                                        result += functor.applyAsInt(i);
                                    }
                                    return result;
                                };
        assertEquals(55, sum.apply(1).apply(10).applyAsInt(i -> i));
    }


    //todo ------------------- Оператор квадроточие :: ------------------- //

    //вызов оператора на статическом методе

    private static void println(Object o) {
        System.out.println(o.toString());
    }

    @Test
    public void quadroDotsOnStaticMethodTest() {
        ButtonJava8 buttonJava8 = new ButtonJava8();

        buttonJava8.setOnClick(event -> JujaVebinarTests.println(event));

        buttonJava8.setOnClick(JujaVebinarTests::println);


        buttonJava8.click();
    }


    //    Оператор квадроточие можно использовать не только на статических методах, но и на методах обьектов
    //Создадим функцию высшего порядка куда передадим BiPredicate
    private void printBoolean(BiPredicate<String, String> biPredicate) {
        System.out.println(biPredicate.test("first", "second"));
    }

    private boolean strBiPredicate1(String string1, String string2) {
        return string1.length() < string2.length();
    }

    @Test
    public void quadroDotsOnObjectMethodTest() {
        printBoolean((str1, str2) -> this.strBiPredicate1(str1, str2));

//        мы можем передать ссылку на strBiPredicate в функцию, которая требует BiPredicate потому что их интерфейсы похожи
//        boolean strBiPredicate(String string1, String string2)
//        boolean test(T t, U u);
        printBoolean(this::strBiPredicate1);
    }

    //а если метод перегружен
    private boolean strBiPredicate1(String string1) {
        return string1.length() < "123".length();
    }

    //    то какой из методов сработает
    @Test
    public void quadroDotsOverloadTest() {
        printBoolean(this::strBiPredicate1);
    }
    //ответ:  компилятор будет исходить из контекста  -  метод printBoolean принимает на вход
//    BiPredicate, а его метод     boolean test(T t, U u);   =>  будут исакать метод strBiPredicate1 с двумя параметрами


    //todo --------Theory------------
//есть три варианта:
//    object::instanceMethod
//    Class::staticMethod
//    Class::instanceMethod
//    В первых двух случаях ссылка на метод эквивалентна лямбда выражения, которое предоставляет параметры метода
//    System.out::println   эквивалентно (x)->System.out.println(x)
//    Math::pow  эквивалентно (x,y)->Math.pow(x,y)
//    В третьем случае первый параметр становится целевым обьектом метода.
//    Например: String::compareToIgnoreCase   ---  (x,y)-> x.compareToIgnoreCase(y)

    @Test
    public void quadroDotsOnClassMethodTest() {
        List<String> list = new LinkedList<String>() {{
            add("four");
            add("one");
            add("two");
            add("five");
            add("three");
        }};

        Comparator<String> comparator = (o1, o2) -> o1.compareToIgnoreCase(o2);
        Collections.sort(list, comparator);
        assertEquals("[five, four, one, three, two]", list.toString());

        Comparator<String> comparator2 = String::compareToIgnoreCase;
        Collections.sort(list, comparator2);
        assertEquals("[five, four, one, three, two]", list.toString());
    }

    //как произходит mapping с ляибды на определённый тип???
    //debug
    @Test
    public void debugTest() {
        reversCarryingTest();
    }

    //todo ----------------------- Effectively Final -------------------//
//    переменные внутри лямбд должны быть final или EffectivelyFinal (т.к. переменная не final(EffectivelyFinal)
//    будет в стеке и будет недоступна для лямбды, почему непонятно???????)
//    Effectively Final  - когда компилятор видит что присвоение переменной произходило один раз и подразумевает
//    в месте обьявления ключевое слово final
    @Test
    public void effectivelyFinalTest() {
        /*final*/
        String prefix = "asd";
//        prefix = "asd";// error in lambda  -  not compiling

        Function<String, String> func = (str) -> prefix + str.toUpperCase();
        assertEquals("asdJKL", func.apply("jkl"));
    }

    //тоже распространяется и на параметры методов
    public String methodEffectivelyFinal(String prefix) {
//        prefix = "asd";// error in lambda  -  not compiling
        Function<String, String> func = (str) -> prefix + str.toUpperCase();
        return func.apply("jkl");
    }

    @Test
    public void methodEffectivelyFinalTest() {
        assertEquals("asdJKL", methodEffectivelyFinal("asd"));
    }


    //todo --------------------------------- Best Practices------------------------------------------//

    // 1. миспользовать стандартные функциональные интерфейсы,  а не создавать свои
// 2. использовать аннотацию @FunctionalInterface  - это позволяет компилятору делать разные валидации
// 3. не злоупотреблять default методами в функциональных интерфейсах
// default методы в лямбдах использовать нельзя,  почему????  - потому что в лямбде еще нет обьекта который
// анонимно реализовывает функциональный интерфейс
// в ляибде такого понятия как this - как ссыдка на анонимный класс реализующий функциональный интерфейс нет!!!
//    this в лямбда ссылается на обьект в котом она обьявлена

    @FunctionalInterface
    interface MyFunctionalInterface {
        double get(double input);

        default double defaultMethod() {
            return 42;
        }
    }

    @Test
    public void defaultMethodInLambdaTest() {
        MyFunctionalInterface f = (input) -> input - 42;
//        MyFunctionalInterface f1 = (input) -> input - defaultMethod(); // здесь еще нет обьекта реализовывающего функциональный интерфейс
        assertEquals(0, f.get(42d), 0.001);
        assertEquals(42, f.defaultMethod(), 0.001);
    }
// 4. инстанцируй функциональные интерфейсы через лямбда выражения
// 5. избегай перегрузку (overloading) для методов с функциональными интерфейсами в качестве параметров
// 6. не относись к лямбда выражениям как к внутренним классамч

    @FunctionalInterface
    interface Foo {
        String method(String input);
    }

    private String value = "Enclosing scope value";

    @Test
    public void lambdaEnclosingScopeTest() {
        Foo foo1 = new Foo() {
            String value = "Inner class value";

            @Override
            public String method(String input) {
                // тут this указывает на внутренний (анонимно реализованный) обьект foo1
                return this.value;
                // чтобы получить доступ к внешнему value надо обратиться через класс JujaVebinarTests.this.value
//                return JujaVebinarTests.this.value;
            }
        };

        // а в лямбда this указывает на обьект в котором она обьявлена, ляибда видит внешний value
        Foo foo2 = (input) -> this.value;

    }

    @Test
    public void lambdaEnclosingScopeTest2() {
        String local = "qwe";

        Foo f1 = (input) -> {
//мы не можем создать одноимённую локальную переменную - потому что лямбды используют enclosing scope
//            String local = "jkl";// error!!!
            return local;
        };

        Foo f2 = (input) -> {
//            создать локальную переменнуб с именем поля мы можем
            String value = "jkl";
            return value;
        };
        assertEquals("qwe", f1.method(""));
        assertEquals("jkl", f2.method(""));
    }

    // 7. Lambda Expressions лучше делать короткими и понятными
    // 8. еслм в лямбда состоит из блока кода - лучше выделить его в метод
    // 8. Effectively Final  можно обойти через массив с одним значением int[] arr = new int[1];
//          но лучше этого не делать, т.к. лямбды заточены под параллеьное вычисления

    @Test
    public void protectObjectVariablesFromMutationsTest() throws InterruptedException {
//        int t = 0;
//        Runnable r =  ()-> t++;//error

        int[] total = new int[1];//вариант обхода ограничения
        Runnable r = () -> total[0]++;

        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100000; i++) {
            service.submit(r);
        }
        Thread.sleep(5000);
        assertEquals(100000, total[0]);// через раз ошибки
    }

    @Test
    public void Test1() {

    }

//    3h10min
}

