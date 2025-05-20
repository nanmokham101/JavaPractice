package com.mk.javase.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
    Meta data(Data about data) put , need annotation because Java Language Flaw
    Mostly use from Framework Annotation, less custom create Annotation
    Decorator Pattern / Additional information
 */
@Retention(RetentionPolicy.RUNTIME) // will compute in runtime
public @interface AnnotationDemo { // marker customer anno not useful , we need to read this anno
}
