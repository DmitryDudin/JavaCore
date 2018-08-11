package ua.com.javatrainig.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LocksMainClass {
//    Блокировки
//служат альтернативой блокам кода synchronized для управления доступом к общему ресурсу

//    В общем, блокировки действуют следу­
//    ющим образом. Прежде чем получить доступ к общему ресурсу, запрашивается бло­
//    кировка, защищающая этот ресурс. По завершении доступа к ресурсу блокировка
//    снимается. Если один поток исполнения попытается запросить блокировку в тот
//    момент, когда она используется каким-нибудь другим потоком исполнения, то пер­
//    вый поток будет ожидать до тех пор, пока блокировка не будет снята. Благодаря это­
//    му удается избежать конфликтов при доступе к общему ресурсу.

//    интерфейс Lock
//lock() - для получения блокировки, если блокировка недоступна, метод lock() войдет в состояние ожидания. \
//unlock() - чтобы снять блокировку
//tryLock() - для того чтобы выяснить, доступна ли блокировка, и если она доступна, получить ее;
//            не будет ожидать блокировку, если она недоступна;
//            true - если блокировка получена, а иначе - логическое значение false
//            true - если блокировка получена
//            false - если в данный момент блокировка используется другим потоком исполнения

//newCondition() - возвращает объект типа Condition , связанный с блокировкой.
//                 Объект типа Condition позволяет добиться более полного контроля над бло­
//                 кировками с помощью методов await() и signal() (wait() и notify())

//ReentrantLock - реализующий интерфейс Lock. Этот класс реализует реентерабельную блокировку, в которую
//                может входить повторно поток исполнения, удерживающий в данный момент блокировку.
//Если поток входит в блокировку повторно, все вызовы метода lock()
//должны быть, разумеется, смещены на равное количество вызовов метода unlock().

//ReadWriteLock - реализующий поддержку отдельных блокировок для доступа с целью чтения и записи.
//ReentrantReadWriteLock предоставляет соответствующую реализацию интерфейса ReadWriteLock.

//StampedLock - реализующий специальную блокировку. Но этот класс не реализует интерфейс Lock или ReadWriteLock

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(customThread(reentrantLock, "A")).start();
        new Thread(customThread(reentrantLock, "B")).start();
        new Thread(customThread(reentrantLock, "C")).start();
        new Thread(customThread(reentrantLock, "D")).start();
    }

    static int count = 0;

    private static Runnable customThread(ReentrantLock reentrantLock, String name) {
        return () -> {
            try {
                System.out.println("Custom thread started - " + name);
                System.out.println("thread " + name + " wait blocking a counter");
                reentrantLock.lock();
                System.out.println("thread " + name + " blocked a counter");
                count++;
                System.out.println("thread " + name + "  count= " + count);
                System.out.println("thread " + name + "  wait");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Custom thread stoped - " + name);
                reentrantLock.unlock();
            }
        };
    }

}
