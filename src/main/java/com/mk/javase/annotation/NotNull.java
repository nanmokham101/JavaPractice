package com.mk.javase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.METHOD}) // Compile error when use @NotNull in field level if want to allow @Target({ElementType.METHOD, ElementType.FIELD})

public @interface NotNull {
    String message() default ""; // parameter for message() like getter setter -> allow primitive type int, double, String,Class,enum, another annotation, array
}
