package ua.com.javatrainig.concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerMainClass {

//    Вероятно, наиболее интересным с точки зрения синхронизации является
//    класс Exchanger, предназначенный для упрощения процесса обмена данными
//    между двумя потоками исполнения. Принцип действия класса Exchanger очень
//    прост: он ожидает до тех пор, пока два отдельных потока исполнения не вызовут
//    его метод exchange(). Как только это произойдет, он произведет обмен данны­
//    ми, предоставляемыми обоими потоками.

    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();
        new UseString(exgr);
        new MakeString(exgr);
    }

    static class MakeString implements Runnable {
        private final Exchanger<String> exgr;
        private String str;

        public MakeString(Exchanger<String> exgr) {
            this.exgr = exgr;
            str = new String();
            new Thread(this).start();
        }

        @Override
        public void run() {
            char ch = 'A';
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) str += (char) ch++;
                try {
                    str = exgr.exchange(str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class UseString implements Runnable {
        private final Exchanger<String> exgr;
        private String str;

        public UseString(Exchanger<String> exgr) {
            this.exgr = exgr;
            str = new String();
            new Thread(this).start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    str = exgr.exchange(new String());
                    System.out.println(str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

