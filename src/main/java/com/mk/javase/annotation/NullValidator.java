package com.mk.javase.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class NullValidator {
    public static void main(String[] args) {
        Human h = new Human();
        // h.name = "Momo";
        h.address = "Mdy";
        Object obj = h;
        Field[] fields = h.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field name: " + field.getName() + " / Field tye : " + field.getType());

            Annotation[] annotation = field.getDeclaredAnnotations();
            for (Annotation anno : annotation) {
                if (anno instanceof NotNull) {
                    String fieldNam = field.getName();
                    System.out.println("NotNull Anno field name : " + fieldNam);
                    Object value;
                    try {
                        value = field.get(obj);
                        if (value == null) {
                            System.out.println("Field : " + fieldNam + " is null");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
