package com.codeify.springboot01.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    private static final long serialVersionUID = 1L;
}