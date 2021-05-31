package com.hello.client;

import com.hello.HelloWorld;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

public class HelloWorldClient {

    public static void main (String arg[]) {

        HelloWorld hello = new HelloWorld();
        System.out.println(hello.sayHelloWorld());

        final List<VirtualMachineDescriptor> list = VirtualMachine.list();
        int i = 0;

    }

}