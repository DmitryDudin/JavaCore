module com.hello.client {

    //Update “module-info.java” to import “com.hello” to use Hello.java in “HelloWorldClient.java” component.
    requires com.hello;
    requires jdk.attach;

}