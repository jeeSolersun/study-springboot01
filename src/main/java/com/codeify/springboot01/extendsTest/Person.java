package com.codeify.springboot01.extendsTest;

/**
 * created by sunhanbing on 2021/06/27 23:58
 */
public class Person extends Animal{

    private String name;
    private Integer age;
    {
        System.out.println("{我是普通代码块。。。}");
    }
    public Person(String name, Integer age) {
        super(1f);
        this.name = name;
        this.age = age;
    }

    public Person() {
        super(1f);
        System.out.println("Person()");
    }

    public static void main(String[] args) {
        new Person("aa", 10);
    }
}
