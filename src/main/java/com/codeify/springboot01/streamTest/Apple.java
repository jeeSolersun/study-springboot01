package com.codeify.springboot01.streamTest;

/**
 * created by sunhanbing on 2021/06/20 19:30
 */
public class Apple {

    private Integer id;
    private String name;
    private String color;
    private Integer weight;

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Apple() {
    }

    public Apple(Integer id, String name, String color, Integer weight) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.weight = weight;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
