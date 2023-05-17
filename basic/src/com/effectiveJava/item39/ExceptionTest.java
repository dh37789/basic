package com.effectiveJava.item39;

import java.lang.annotation.*;

/**
 * 반복 가능한 애너테이션
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
    Class<? extends Throwable>[] value();
}
