package com.imooc.demo.log;

import java.lang.annotation.*;

/**
 * @author Administrator
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ExecTime {
    String value() default "";
}