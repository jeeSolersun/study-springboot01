package com.codeify.springboot01.designpatterns.singleton01;

/**
 * @author codeify
 * @since 2021/08/21 16:13
 */
public class MyTest {

    public static void main(String[] args) {
//        Singleton03 singleton03 = new Singleton03();
//        System.out.println(singleton03);
        /*for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton03.getInstance().hashCode())).start();
        }*/
//        System.out.println(Singleton03.Singleton03Inner.instance);
        System.out.println(Singleton04.INSTANCE.getValue());
//        System.out.println(Singleton04.INSTANCE2.getValue());
//        System.out.println(Singleton04.INSTANCE == Singleton04.INSTANCE2);
//        System.out.println(Singleton04.INSTANCE + " start");
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> System.out.println(Singleton04.INSTANCE.hashCode())).start();
//        }
        Singleton04.INSTANCE.printMsg();
    }
}
