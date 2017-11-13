import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class JujaVebinarStreamApiTests {
//    .steam  -  default method в интерфейсе Collection

//промежуточные операции ничего не делают - они лишь формируют query
//можно сказать они lazy
//    терминальная операция приводит к вычислениям

//    стримы - это алгоритмы модификации коллекций

//   https://www.youtube.com/watch?v=KruQhyJlt2Q&feature=youtu.be
//   [JuJa] Александр Баглай "Использование Stream API при работе с коллекциями"

//    квадраточие :: можно изпользовать в лямбдах:
//    - на методах обьекта
//    - на статических методах класса
//    - с оператором new
//    - если не хватает данных но мы можем  их получить из обьекта т е  обьект заменяет один их параметров ???

    @Test
    public void commonSimpleTest() {

//        .collect - terminal operation
    }

    @Test
    public void filterTest() {
        List<User> testCollection = Arrays.asList(new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        List<User> result = testCollection.stream()
                .filter(user -> user.getId() % 2 == 0)
                .collect(toList());
//        System.out.println(result);
        Assert.assertEquals("[[id=2 name=Mike], [id=4 name=Den]]", result.toString());
    }

    @Test
    public void distinctTest() {
        List<User> testCollection = Arrays.asList(new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        List<User> result = testCollection.stream()
                .unordered()// если упорядоченность не важна то можно увеличить скорость
                .distinct()// удаляет дубликаты используя equals
                .collect(toList());
        System.out.println(result);
        Assert.assertEquals(result.size(), 5);
    }

    @Test
    public void limitTest() {
        List<User> testCollection = Arrays.asList(new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        List<User> result = testCollection.stream()
                .limit(3)// обрезаем количество обьектов стрима
                .collect(toList());
        System.out.println(result);
        Assert.assertEquals(result.size(), 3);

//        limit  - short-circuiting stateful intermediate operation
//        short-circuiting   -  значит будет чтото обрезать, для потока с безконечным количеством элементов вернет конечное количество элементов
//        stateful  -  для работы ей может потребоваться все данные обработанные на предидущем этапе
//        intermediate operation - т е она не терминальная, а промежуточная
    }

//    .skip(number)  -  пропуск элементов в начале стрима;  stateful intermediate operation

    @Test
    public void sortTest() {
//        есть два вида с Comparator и без(обьект должен реализовывать Comparable)
//        если обьект реализовывает Comparable - тогда можно без параметров sort()
        List<User> testCollection = Arrays.asList(new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        List<User> result = testCollection.stream()
//                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .sorted(Comparator.comparing(User::getName))
                .collect(toList());
        System.out.println(result);
    }

    @Test
    public void intermediateAndTerminalOperationsTest() {
        List<String> phases = new LinkedList<>();
        Collection<Integer> users = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> names = users.stream()
//        List<Integer> names = users.parallelStream()//порядок выполнения и количество stateless операций непредсказуемо
                .filter(n -> {
                    phases.add("f-" + n);
                    return n % 2 == 0;
                })
                .map(n -> {// сюда попадаем сразу после того как прошли filter
                    phases.add("m-" + n);
                    return n;
                })
//                .sorted((n1, n2) -> {//для этой операции нужны все значения (stateful operation)- своего рода накопитель перед sorted, limit - тут не работает
//                    phases.add("s-" + n1 + "-" + n2);
//                    return Integer.compare(n2, n1);
//                })
//                некоторые операции влияют на выполнение других
                .limit(2) // надо закоментить sorted
                //только терминальная операция приводит к вычислению
                .collect(toList());

        System.out.println(names + "/n");
        System.out.println(phases);
    }

    //stateful operation - требуют всез данных

    @Test
    public void peekTest() {
//        Stream<T> peek(Consumer<? super T> action);
//peek - применяется для выполнения промежуточных действий над стримом, как поавилло используют при отладке (sout)
        List<User> sorted = new LinkedList<>();
        List<User> users = Arrays.asList(new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
//                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
//                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        List<String> names = users.stream()
                .sorted(Comparator.comparing(User::getId).reversed())
                .peek(user -> sorted.add(user))//todo need  understand
                .map(User::getName)
                .collect(toList());

        System.out.println(names);
        System.out.println(sorted);

    }

    @Test
    public void forEachTest() {
//        forEach - terminal operation
//        forEachOrdered - terminal operation соблюдает порядок выполнения, чуть медленее
        List<String> names = new LinkedList<>();
        List<User> users = Arrays.asList(
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        users.stream()
                .map(user -> user.getName())
                .forEach(name -> names.add(name));
        System.out.println(names);
    }

    @Test
    public void mapTest() {
//        map - функция высшего порядка, кот означает применить ко всем
//        результатом её выполнения будет другой stream из N элементов
        List<String> names = new LinkedList<>();
        List<User> users = Arrays.asList(
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        users.stream()
                .map(user -> user.getName())
                .forEach(name -> names.add(name));
        System.out.println(names);

        List<Long> ids = users.stream()
                .map(User::getId)
                .collect(toList());
        System.out.println(ids);
    }

    @Test
    public void mapToLongTest() {
//        mapToLong -  LongStream has methods min, max, average, sum, summaryStatistics etc.
        List<User> users = Arrays.asList(
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        long[] ids = users.stream()
                .mapToLong(user -> user.getId())
                .toArray();
        System.out.println(Arrays.toString(ids));
        long sum = users.stream()
                .mapToLong(user -> user.getId())
                .sum();
        System.out.println(sum);

        OptionalDouble average = users.stream()
                .mapToLong(user -> user.getId())
                .average();
        System.out.println(average.getAsDouble());
    }
//    аналогично:
//    -mapToInt
//    -mapToDouble
//    наличие специфических методов для работы с числовыми стримами

//    -mapToObj - позволяет числовой стрим преобразовать в стрим обьектов


    @Test
    public void flatMapTest() {
//        когда необходимо некое дерево развернуть в плоскую структуру
//                для этого нужна Function принимающая обьект "стрима"
//                и возвращающая "стрим" результатов
        List<User> users = Arrays.asList(
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        List<String> flatMap = users.stream()
                .flatMap(user -> Stream.of(
                        "id=" + user.getId(),
                        "name=" + user.getName(),
                        "role" + user.getRole().toString()))
                .collect(toList());
        System.out.println(flatMap);


        List<Integer> intsList = users.stream()
                .flatMapToInt(user -> IntStream.of(
                        user.getId().intValue(),
                        user.getRole().ordinal(),
                        user.getName().length()
                ))
//                .mapToObj(i -> (new Integer(i)))
                .mapToObj(Integer::new)
                .collect(toList());

        System.out.println(intsList);
    }

    @Test
    public void collectTest() {
//        <R> R collect(Supplier<R> supplier,
//                BiConsumer<R, ? super T> accumulator,
//                BiConsumer<R, R> combiner);
//supplier - порождает контейнер в который будут накапливаться данные
//        accumulator(BiConsumer) - показует как добавлять единичные элементы в конейнер
//        combiner - показует как будут обьединяться между собой два контейнера(возможно после параллелльных вычислений)

//        позволяет собрать элементы стрима в любой обьект контейнер

        List<User> users = Arrays.asList(
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        ArrayList<String> names = users.stream()
                .map(user -> user.getName())
//                .collect(
//                        () -> new ArrayList<String>(),
//                        (container, name) -> container.add(name),
//                        (container, subConteiner) -> container.addAll(subConteiner)
//                );
                .collect(
                        ArrayList<String>::new,
                        ArrayList::add,
                        ArrayList::addAll
                );
        System.out.println(names);
    }

    @Test
    public void collectWithCollectorTest() {
//        public static<T, A, R> Collector<T, A, R> of(
//                Supplier<A> supplier,
//                BiConsumer<A, T> accumulator,
//                BinaryOperator<A> combiner,
//                Function<A, R> finisher,
//                Collector.Characteristics... characteristics)
//supplier - порождает контейнер в который будут накапливаться данные
//        accumulator - добавляет единичные элементы в конейнер
//        combiner(BinaryOperator) - добавляет все элементы в контейнео
//        finisher - перепаковывает рабочий контейнер в результат, может быть исключён
//        позволяет собрать элементы стрима в любой обьект контейнер

        List<User> users = Arrays.asList(
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        LinkedHashSet<String> names = users.stream()
                .map(user -> user.getName())
                .collect(Collector.of(
                        ArrayList<String>::new, //supplier
                        List::add, //accumulator
                        (container, subContainer) -> {//combiner
                            container.addAll(subContainer);
                            return container;
                        },
                        (container) -> new LinkedHashSet<String>() {{//finisher
                            addAll(container);
                        }},
                        Collector.Characteristics.CONCURRENT,
//                        Collector.Characteristics.IDENTITY_FINISH,
                        Collector.Characteristics.UNORDERED

                        )
                );
        System.out.println(names);
    }


    @Test
    public void collectToCollectionTest() {
//supplier - порождает контейнер в который будут накапливаться данные

        List<User> users = Arrays.asList(
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));

        ArrayList<String> names = users.stream()
                .unordered()
                .map(user -> user.getName())
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(names);


        String joinString = users.stream()
                .unordered()
                .map(user -> user.getName())
                .collect(Collectors.joining("---"));//конкатенируем элементы в строку
        System.out.println("joinString= " + joinString);

        Long count = users.stream()
                .unordered()
                .map(user -> user.getName())
                .collect(Collectors.counting());
        System.out.println("count= " + count);

        Set<String> setNames = users.stream()
                .unordered()
                .collect(Collectors.mapping(User::getName, toSet()));
        System.out.println("setNames= " + setNames);

        LinkedHashSet<String> collect = users.stream()
                .unordered()
                .collect(Collectors.collectingAndThen(toList(),  // todo not understand
                        (userList) -> new LinkedHashSet<String>() {{//finisher
                            userList.get(1);
                        }}
                        )
                );
        System.out.println("collect = " + collect);


//        Collectors.maxBy()
//        Collectors.minBy()

//        return sum:
//        Collectors.summingInt()
//        Collectors.summingLong()
//        Collectors.summingDouble()

        //average
//        Collectors.averagingInt()
//        Collectors.averagingLong()
//        Collectors.averagingDouble()

        //reduce обьединяет стрим в один обьект (T identity)
//        public static <T> Collector<T, ?, T> reducing(T identity, BinaryOperator<T> op)
//        public static <T> Collector<T, ?, Optional<T>> reducing(BinaryOperator<T> op)
//        public static <T, U> Collector<T, ?, U> reducing(U identity, Function<? super T, ? extends U> mapper, BinaryOperator<U> op) {

//        groupingBy() разьединяет коллекцию на несколько частей в возвращает Map
//        Collectors.groupingBy()

//        partitioningBy - разделяет коллекцию на две части по соответствию условию и возвращает их как Map<Boolean, List>
//        Collectors.partitioningBy()

//        Collectors.summarizingInt()
//        Collectors.summarizingDouble()
//        Collectors.summarizingLong()
    }

    @Test
    public void reduceTest() {
//        reduce() - преобразует весь поток к одному обьекту
        List<User> users = Arrays.asList(
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.USER),
                new User(3l, "Bill", User.UserrRole.USER),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.USER));


        Optional<Long> sum = users.stream()
                .map(User::getId)
                .reduce((a, b) -> a + b);
//                .reduce(Long::sum);
        System.out.println("sum= " + sum.get());

        Long sumWithIdentity = users.stream()
                .map(User::getId)
                .reduce(300L, //identity -   с чего начать вычисления
                        (a, b) -> a + b);//accumulator
        System.out.println("sumWithIdentity= " + sumWithIdentity);

        StringBuilder strBuilder = users.stream()
                .reduce(
                        new StringBuilder(),//identity  контейнер
                        (builder, user) -> builder.append(user.toString()),//accumulator как в контейнер добавлять единичные значения
                        (builder, anotherBuilder) -> builder.append(anotherBuilder.toString())//combiner  как в контейнер добавлять другой контейнер если вычисления распараллелились
                );
        System.out.println(strBuilder.toString());
    }

    @Test
    public void minTest() {
//        поиск минимального значения с помощью компаратора
        List<User> users = Arrays.asList(
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.GUEST),
                new User(3l, "Bill", User.UserrRole.ADMIN),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.GUEST),
                new User(5l, "Alya", User.UserrRole.ADMIN));

        Optional<User> minUser = users.stream()
                .min(
                        Comparator
                                .comparing(User::getRole)
                                .thenComparing(User::getName)
                );
        System.out.println("minUser= " + minUser);
//max - аналогично
    }

    @Test
    public void anyMatchTest() {
        //есть ли совпадение хотя бы по одному элементу, если хотя бы для одного элемента Predicate возвращает true
        // Predicate - такая функция которая на вход принимает значение(обьект), а возвращает boolean
        List<User> users = Arrays.asList(
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.GUEST),
                new User(3l, "Bill", User.UserrRole.ADMIN),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.GUEST),
                new User(5l, "Alya", User.UserrRole.ADMIN));

        boolean anyMatch = users.stream()
                .anyMatch(user -> user.getName() == "Alya");
        System.out.println(anyMatch);
        anyMatch = users.stream()
                .anyMatch(user -> user.getName() == "Tim");
        System.out.println(anyMatch);

        // allMatch - true когда на все обьекты Predicate возвращает true
        // noneMatch - true когда на все обьекты Predicate возвращает false
    }


//    todo --------------- Stream Factories  --------------- //

//    Stream.empty()  - пустой стрим
//    Stream.of()  - стрим из n или одного элемента

    @Test
    public void streamFactories() {

        User[] usersArray = {
                new User(1l, "Nika", User.UserrRole.USER),
                new User(2l, "Mike", User.UserrRole.GUEST),
                new User(3l, "Bill", User.UserrRole.ADMIN),
                new User(4l, "Den", User.UserrRole.USER),
                new User(5l, "Olya", User.UserrRole.GUEST),
                new User(5l, "Alya", User.UserrRole.ADMIN)
        };
        Arrays.stream(usersArray); // stream из массива

        //безконечные стримы

        int seed = 0;
        List<Integer> iterateStream = Stream.iterate(seed, n -> n + 1)
                .limit(10)
                .collect(toList());
        System.out.println("iterateStream= " + iterateStream);

//        Stream.generate()

//        Stream.concat(stream1, stream2) - обьединяет стримы
    }

//    todo --------------------- Parallel Stream ------------------------
//Stream.parallelStream()
//    .parallel()
//    .sequential()
//    streamObj.isParallel() - return boolean

//   todo --------------------- Other Stream Features------------------------

    @Test
    public void featuresTest() throws IOException {
//        Stream<String> lines = Files.lines(Paths.get("/file/path"));
        IntStream chars = "Hello".chars();
        IntStream codePoints = "Hello".codePoints();
        System.out.println("chars= " + Arrays.toString(chars.toArray()));
        System.out.println("codePoints=" + Arrays.toString(codePoints.toArray()));
    }


}
