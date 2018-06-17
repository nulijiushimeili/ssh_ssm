package com.ibeifeng.spring.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zmzy on 2017/2/16.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
