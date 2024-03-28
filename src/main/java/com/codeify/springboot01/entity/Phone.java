package com.codeify.springboot01.entity;

import java.util.Objects;

/**
 * @author codeify
 * @since 2022/08/27 00:22
 */
public class Phone {
    private Integer id;
    private String name;

    public Phone() {
    }

    public Phone(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(id, phone.id) && Objects.equals(name, phone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
