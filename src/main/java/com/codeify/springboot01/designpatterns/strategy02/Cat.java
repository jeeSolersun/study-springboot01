package com.codeify.springboot01.designpatterns.strategy02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author codeify
 * @since 2021/09/07 00:02
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Cat {
    private Integer id;

    private String name;

    private Integer age;

    public Cat() {
    }

    public Cat(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
