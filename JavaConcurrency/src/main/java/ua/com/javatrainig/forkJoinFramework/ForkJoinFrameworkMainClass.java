package ua.com.javatrainig.forkJoinFramework;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinFrameworkMainClass {
//    Каркас Fork/Join Framework усовершенствует многопоточное программирование двумя важными способами.
//    Во-первых, он упрощает создание и использование нескольких потоков исполнения,
//    и во-вторых, автоматизирует использование нескольких процессоров.

//    Прежде чем продолжить дальше, следует указать на отличие параллельно­
//    го программирования от традиционного многопоточного п рограммирования .
//    В прошлом большинство компьютеров имело лишь один процессор, и многопо­
//    точность, прежде всего, позволяла выгодно воспользоваться временем простоя ,
//    когда программа ожидает, например, от пользователя ввода данн ых. При таком
//    подходе один поток может выполняться , в то время как другой ожидает. Иными
//    словами, в системе с одним процессором многопоточность позволяет совместно
//    использовать этот процессор для выполнения двух или более задач. Такой тип
//    многопоточности , как правило, поддерживается объектом класса T h r e ad, как по­
//    яснялось в главе 1 1. И хотя эта разновидность многопоточности останется весьма
//    полезной и впредь, она не совсем подходит для тех случаев, когда имеются два или
//    более процессора, т.е. многоядерный компьютер.

//    Если имеется несколько процессоров, то требуется другой тип многопоточно­
//    сти , обеспечивающий настоящее параллельное выполнение. На двух или более
//    процессорах программу можно выполнять одновременно отдельными частями.

//    ForkJoinTask<V>  -  Абстрактный класс, определяющий выполняемую задачу
//    ForkJoinPool  -  Управляет выполнением задач типа ForkJoinTaslt
//    RecursiveAction  -  Является производным от класса ForkJoinTask<V> для выполнения задач, не возвращающих значения
//    RecursiveTask<V>  - Является производным от класса ForkJoinTask<V> для выполнения задач, возвращающих значения
//    CountedComplete r  - Является производным от класса ForkJoinTask<V>

    //    Как правило, пользователи каркаса Fork/Join Framework пользуются стратегией
// todo "разделяй и властвуй ",
//    положенной в основу рекурсии. Именно поэтому оба класса, производных от класса ForkJoinTask,
//    называются RecursiveAction и RecursiveTask.
//    Стратегия "разделяй и властвуй", положенная в основу рекурсии, подразумева·
//    ет разделение задачи на подзадачи до тех пор, пока их объем не станет достаточно
//    мелким для последовательной обработки.
//    Преимущество стратегии "разделяй и властвуй" заключается в том, что обра­
//    ботка может осущес твля ться параллельно.
//    Одним из главных условий успешного применения стратегии "разделяй и вла­
//    ствуй" является правильное определение порогового значения, после которого
//    выполняется последовательная обработка, а не дальнейшее разделение задачи.
    {
        ForkJoinPool.commonPool();
        ForkJoinPool.getCommonPoolParallelism();
        Runtime.getRuntime().availableProcessors();

    }
}