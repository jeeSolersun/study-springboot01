package com.codeify.springboot01.annotation;

import java.lang.annotation.*;

/**
 * @author codeify
 * @since 2024/02/26 17:35
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyLog {
}
