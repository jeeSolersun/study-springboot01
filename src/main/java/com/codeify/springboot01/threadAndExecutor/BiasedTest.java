package com.codeify.springboot01.threadAndExecutor;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author codeify
 * @since 2021/12/19 18:29
 */
@Slf4j(topic = "codeify.BiasedTest")
public class BiasedTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        log.debug(ClassLayout.parseInstance(dog).toPrintable());
    }
}

class Dog {

}
