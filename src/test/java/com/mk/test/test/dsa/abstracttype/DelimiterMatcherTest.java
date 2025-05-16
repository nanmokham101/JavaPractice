package com.mk.test.test.dsa.abstracttype;

import com.mk.dsa.abstracttype.DelimiterMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DelimiterMatcherTest {
    /* Simple case */

    @Test
    public void testSimpleCasePositiveCase(){
        DelimiterMatcher delimiterMatcher = new DelimiterMatcher("a[b]");
        Assertions.assertEquals(true, delimiterMatcher.isValid());
    }

    /*
        In negative case stack should be empty
        a[b
            push [ -> closing not present so stack = empty, test pass
            char openingChar = stack.pop();
        ab]
            found closing ] but stack is empty why stack is empty / if found [ -> push / not found not push
     */
    @Test
    public void testSimpleCaseNegativeCase(){
        DelimiterMatcher delimiterMatcher = new DelimiterMatcher("a[b");
        Assertions.assertEquals(false, delimiterMatcher.isValid());
    }

    @Test
    public void testSimpleCaseNegativeCase1(){
        DelimiterMatcher delimiterMatcher = new DelimiterMatcher("ab]");
        Assertions.assertEquals(false, delimiterMatcher.isValid());
    }
    @Test
    public void testComplexPositiveCase(){
        DelimiterMatcher delimiterMatcher = new DelimiterMatcher("a{b[c]d}e");
        Assertions.assertEquals(true, delimiterMatcher.isValid());
    }
    @Test
    public void testComplexNegativeCase(){
        DelimiterMatcher delimiterMatcher = new DelimiterMatcher("a{b(c]d}e");
        Assertions.assertEquals(false, delimiterMatcher.isValid());
    }
}
