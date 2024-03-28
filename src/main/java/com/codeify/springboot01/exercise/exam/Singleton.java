package com.codeify.springboot01.exercise.exam;

/**
 * @author codeify
 * @since 2023/10/09 19:02
 */
public class Singleton {
    private static volatile Singleton singleton = null;

    public static Singleton getInstance() {
        if (singleton != null) {
            synchronized (Singleton.class) {
                if (singleton != null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
