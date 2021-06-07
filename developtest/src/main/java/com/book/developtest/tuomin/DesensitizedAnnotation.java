package com.book.developtest.tuomin;

import java.lang.annotation.*;

/**
 * @author: hj
 * @date: 2021-06-04 15:43
 * @description:
 **/

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DesensitizedAnnotation {
    /**
     * 脱敏数据类型(规则)
     */
    TypeEnum type();
}

