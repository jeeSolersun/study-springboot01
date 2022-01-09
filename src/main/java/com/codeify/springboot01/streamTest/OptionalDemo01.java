package com.codeify.springboot01.streamTest;

import java.util.Optional;

/**
 * created by sunhanbing on 2021/08/15 18:52
 */
public class OptionalDemo01 {

    public static void main(String[] args) {
        Optional<String> s = Optional.ofNullable(new Apple(22, "hello", "blue", 100))
//                .filter(item -> item.getId().equals(22));
                .flatMap(item -> Optional.ofNullable(item.getName()));
//        apple.ifPresent(System.out::println);
        if (s.isPresent())
            System.out.println(s.get());
    }
}
