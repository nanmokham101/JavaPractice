package com.mk.test.test.dsa.abstracttype;

import com.mk.dsa.abstracttype.PostfixTransformer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PostfixTransformerTest {
    @Test
    public void testPostfixTransformer(){
        String postfix = PostfixTransformer.transform("a+b");
        assertEquals("ab+", postfix);
    }
    @Test // Test Step 3.1
    public void testPostfixTransformer1(){
        String postfix = PostfixTransformer.transform("a+b*c");
        assertEquals("abc*+", postfix);
    }
    /*
        Step 3.2 // until we find lower precedence
        a*b+c
            a -> a
            * -> [*]
            b -> ab
            + ->
                pop -> ab* // current operator is greater than operator in stack so pop
                    stack will empty if pop so start form first []
            + -> [+]
            c -> print c -> ab*c -> pop + -> ab*c+

     */

    @Test // Test 3.2
    public void testPostfixTransformer2(){
        String postfix = PostfixTransformer.transform("a*b+c");
        assertEquals("ab*c+", postfix);
    }

    @Test // Test 3.3 Equal case
    public void testPostfixTransformer3(){
        String postfix = PostfixTransformer.transform("a-b+c");
        assertEquals("ab-c+", postfix);
    }

    @Test // Test 3.4 (a+b)*c
    public void testPostfixTransformer4(){
        String postfix = PostfixTransformer.transform("(a+b)*c");
        assertEquals("ab+c*", postfix);
    }

    @Test //  (a+b)*(c/d)
    public void testPostfixTransformer5(){
        String postfix = PostfixTransformer.transform("(a+b)*(c/d)");
        assertEquals("ab+cd/*", postfix);
    }

    @Test //  (a+b)/(c-d)
    public void testPostfixTransformer6(){
        String postfix = PostfixTransformer.transform("(a+b)/(c-d)");
        assertEquals("ab+cd-/", postfix);
    }

    @Test //  a+(b*c+d)/e
    public void testPostfixTransformer7(){
        String postfix = PostfixTransformer.transform("a+(b*c+d)/e");
        assertEquals("abc*d++e/", postfix);
    }
}
