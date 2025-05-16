package com.mk.test.test.dsa.abstracttype;

import com.mk.dsa.abstracttype.IStack;
import com.mk.dsa.abstracttype.Stack;
import static org.junit.jupiter.api.Assertions.*;

import com.mk.dsa.abstracttype.StackOverFlowException;
import com.mk.dsa.abstracttype.StackUnderFlowException;
import org.junit.jupiter.api.Test;

public class StackTest {
    /*
        Test behaviour
        get Size -> size = 0 => top + 1

        Need to test Edge case , Corner case -> work every enter situations
     */
//Arrange
    IStack stack = new Stack(10);
    @Test
    public void testPush(){

        //Act
        stack.push(10);
        //Assert
        assertEquals(1, stack.getSize());
        assertEquals(10, stack.peek());
    }
    @Test
    public void testMultiPush(){
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }

        for(int i = 9; i >= 0; i--){
            int element = stack.pop();
            assertEquals(i, element);
        }
    }
    @Test
    public void testMultiPushNegative(){
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }
        assertThrows(StackOverFlowException.class, () ->{
            stack.push(11);
        });
        assertEquals(true, stack.isFull());
    }
    @Test
    public void testPopSingle(){
        stack.push(100);
        int originalSize = stack.getSize();
        assertEquals(100, stack.pop());
        assertEquals(originalSize -1 , stack.getSize());
    }

    @Test
    public void testPopSingleNegativeCase(){
        assertThrows(StackUnderFlowException.class, () ->{
            stack.pop();
        });
        assertEquals(true, stack.isEmpty());
    }
}
