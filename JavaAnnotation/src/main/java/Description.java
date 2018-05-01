import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/*
 * It specifies where we can use the annotation.As we specified here as
 * METHOD,its only applicable to method.If don't define Target type,it can be
 * applicable to any element
 * */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.TYPE_PARAMETER})
public @interface Description {
    String title();

    int version() default 1;

    String text();

    Class customClass();
}


//Аннотации представляют собой некие метаданные, которые могут добавлятся в исходный код программы
// и семантически не влияют на нее, но могут использоваться в процессе анализа кода, компиляции и даже во время выполнения.

//    Вот основные варианты использования аннтоаций:
//        - предоставлять необходимую информацию для компилятора;
//        - предоставлять метаданные различным инструментам для генерации кода, конфигураций и т.д.;
//        - использоваться в коде во время выполнения програмного кода (reflection).

//Аннотации могут быть применены к
//  - декларациям классов,
//  - полей,
//  - методов,
//  - параметры методов,
//  - ну и конечно же аннотаций.

//в качестве типов у элементов аннотации могут использоваться :
//     - примитивные типы
//     - перечисления
//     - класс String
//     - java.lang.Class
//     - другие аннотации

//Если у аннотации нет элементов, ее называют маркером (marker annotation type)

//когда аннтоация указывается для другой аннотации, первую называют мета-аннотацией (meta-annotation type)

//мета-аннтоация Retention - показывает, как долго необходимо хранить аннтоацию и инициализируется одним из трех значений:
//  - RetentionPolicy.SOURCE - аннотация используется на этапе компиляции и должна отбрасываться компилятором;
//  - RetentionPolicy.CLASS - аннтоация будет записана в class-файл компилятором, но не должна быть доступна во время выполнения (runtime);
//  - RetentionPolicy.RUNTIME - аннотация будет записана в class-файл и доступна во время выполнения через reflection.

//    по умолчанию у всех аннотаций стоит RetentionPolicy.CLASS
//    в разработке нужна именно RetentionPolicy.RUNTIME

//@interface не является новым ключевым словом, а представляет собой два отдельных слова,
//        а значит вы написание “@ interface” так же правильно как и “@interface”

   /*реальный пример использования аннотаций при программировании на Java:
        Предположим, нам нужно ограничить доступ к некоторым функциям веб-приложения для разных пользователей.
        Иными словами необходимо реализовать права (permissions).*/

