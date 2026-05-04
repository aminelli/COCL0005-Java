package com.example.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface CustomComponent {
    String value() default "";
}
