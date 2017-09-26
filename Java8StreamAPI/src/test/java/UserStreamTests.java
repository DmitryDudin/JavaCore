import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class UserStreamTests {
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

//    35min
}
