package com.codeify.springboot01.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * created by sunhanbing on 2021/06/20 19:30
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Apple implements Serializable {
    private static final long serialVersionUID = -2628045795548607889L;
    private Integer id;
    private String name;
    private String color;
    private Integer weight;
}
