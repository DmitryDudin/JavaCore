package com.hello;

public class HelloWorld {

    public String sayHelloWorld() {
        System.out.println("sayHelloWorld from com.hello package");
        return "Hello World!";
    }

    public static void main(String[] args) {
        new HelloWorld().sayHelloWorld();
    }
//"C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 2018.3.5\jbr\bin\java.exe"
//        "-javaagent:C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 2018.3.5\lib\idea_rt.jar=60299:C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 2018.3.5\bin"
//        -Dfile.encoding=UTF-8
//            -m com.hello/com.hello.HelloWorld

}
