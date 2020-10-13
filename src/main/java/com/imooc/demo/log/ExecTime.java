package com.imooc.demo.log;

import java.lang.annotation.*;

/**
 * @Description 自定义注解 接口执行时间
 * @Author zw
 * @Date 2020/10/13 15:52
 * @Param
 * @Return
**/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ExecTime {
    String value() default "";
}