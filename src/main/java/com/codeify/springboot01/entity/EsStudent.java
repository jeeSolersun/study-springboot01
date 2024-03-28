package com.codeify.springboot01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author codeify
 * @since 2023/10/09 23:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsStudent {
    private Name name;
    private String info;
    private String email;

    @Data
    public static class Name {
        private String firstName;
        private String lastName;
    }
}
