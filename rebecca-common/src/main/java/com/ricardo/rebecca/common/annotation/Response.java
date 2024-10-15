package com.ricardo.rebecca.common.annotation;

import java.lang.annotation.*;

/**
 * @AnnotationName : Response
 * @Author : changyp
 * @Date : 2024/10/15 12:11
 * @Description :
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Response {
}
