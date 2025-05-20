package com.mk.javase.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    Marker Annotation -> Annotation present
    @Target -> where to use see in NotNull Anno
 */
public class MarkerAnnotationUnitTest {
    static void runTestCase(Object testCase) {
        Method[] methods = testCase.getClass().getDeclaredMethods();
//        for(Method method : methods){
//            System.out.println("Method : "+method.getName());
//        }
        // want only method with anno
        for (Method method : methods) {
            if (method.isAnnotationPresent(AnnotationDemo.class)) {
                try {
                    method.invoke(testCase, null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
           /*  Annotation[] annotations = method.getAnnotations();
            for (Annotation anno : annotations) {

               if (anno instanceof AnnotationDemo) {
                    // System.out.println("Annotation : " + method.getName());
                    try {
                        method.invoke(testCase,null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
               */
        }
    }

    public static void main(String[] args) {
//        TestCase testCase = new TestCase();
//        runTestCase(testCase);
        Object anotherTestCase = new AnotherTestCase();
        runTestCase(anotherTestCase);
    }
}
