package com.codeify.springboot01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author codeify
 * @since 2022/04/28 23:51
 */
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Integer id;

    private String name;

    private Integer age;

    private Integer score;
}
