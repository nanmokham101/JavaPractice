package com.mk.javase.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
/*
    @Override -> use in Compile time if child class override method from parent class should use @Override for compiler check for sure
    Can user anno
    Class level
    method level
    field level
 */
public class NullValidatorWithCustomValue {
    public static void main(String[] args) {
        Human h = new Human();
        // h.name = "Momo";
       // h.address = "Mdy";
        Object obj = h;
        Field[] fields = h.getClass().getDeclaredFields();
        for (Field field : fields) {
            //System.out.println("Field name: " + field.getName() + " / Field tye : " + field.getType());

            Annotation[] annotation = field.getDeclaredAnnotations();
            for (Annotation anno : annotation) {
                if (anno instanceof NotNull) {
                    String fieldNam = field.getName();
                  //  System.out.println("NotNull Anno field name : " + fieldNam);
                    Object value;
                    try {
                        value = field.get(obj);
                        if (value == null) {
                            NotNull notNull = (NotNull) anno;
                            String message = notNull.message();
                            if(message.isEmpty()){
                                System.out.println("Field : " + fieldNam + " is null");
                            }else {
                                System.err.println(message);
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
