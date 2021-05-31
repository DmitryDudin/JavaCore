package accessModifiers.feature_2.feauture_2_chiild;

import accessModifiers.feature_2.feauture_2_parent.Feauture2Parent;

import java.util.HashMap;

public class Feauture2Child extends Feauture2Parent {

//    Обратите внимание на пакеты. Унаследованный класс находится не в том же самом пакете, что и родительский.
//    Вопрос. Скомпилируется ли класс ChildAccessTest(Feauture2Child)?
//    Иначе говоря – разрешен ли в методе testAccess дочернего класса доступ к protected-полям и методам
//    экземпляра родительского класса?
//
//Ответ: нет, не разрешен! И класс не скомпилируется!
// А вот если мы вместо AccessTest в качестве типа аргумента укажем ChildAccessTest или любой класс,
// унаследованный от ChildAccessTest – тогда все будет в порядке.
// При том, что поля и методы-то на самом деле определены в родительском классе.
// Так что "моё и всех наследников", как я описал protected-доступ выше, совершенно не означает,
// что доступ к члену класса имеют любые наследники.
// К полю или методу собственного экземпляра – да.
// К полю или методу чужого экземпляра – только если чужой экземпляр является экземпляром
// того же класса наследника (или унаследованного в свою очередь от него).
// А вот к полю или методу чужого экземпляра и при этом родительского класса – нет.
//
//У меня есть некоторые соображения, почему сделано именно так.
// Я не знаю, насколько они верны, но, во всяком случае, они кажутся логичными.
// Если кто-нибудь даст ссылки на документы, где это описано явно – буду признателен.
//
//Дело в том, что когда мы получаем в качестве параметра экземпляр AccessTest(Feauture2Parent),
// мы не знаем, каков действительно тип этого параметра.
// Может статься так, что это какой-то подкласс AccessTest (для определенности OneToFiveClass),
// который накладывает ограничения на значения того поля, которое мы хотим использовать.
// Скажем, оно должно быть от 1 до 5.
// Если бы мы имели доступ к этому полю – мы могли бы тоже унаследоваться от AccessTest(Feauture2Parent),
// а потом передать ему экземпляр OneToFiveClass и поменять значение поля, обойдя все ограничения.
//
// Дыра невероятного размера.
//
//Ну а поскольку дыры в Java не поощряются – эту возможность закрыли. И об этом тоже знают далеко не все.


    public void testAccess(Feauture2Parent anotherObject) {
        //compilation error
//        anotherObject.protectedField = 3;
//        System.out.println("anotherObject.getProtectedField()=" + anotherObject.getProtectedField());
//        System.out.println("anotherObject.protectedField=" + anotherObject.protectedField);
    }

    public void testAccess_2(Feauture2Child anotherObject) {
        anotherObject.protectedField = 3;
        System.out.println("anotherObject.getProtectedField()=" + anotherObject.getProtectedField());
        System.out.println("anotherObject.protectedField=" + anotherObject.protectedField);
    }

}


