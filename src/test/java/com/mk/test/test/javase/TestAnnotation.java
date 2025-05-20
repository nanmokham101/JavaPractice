package com.mk.test.test.javase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAnnotation {
    static int add(int a, int b){
        return a+b;
    }
    @Test // In Runtime find annotation to run
    public void Test(){
        Assertions.assertEquals(3,add(1,2));
    }
}
