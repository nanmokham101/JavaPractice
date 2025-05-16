package com.mk.dsa.abstracttype;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
    infix a + b -> operator between operand
    postfix ab+ -> in compiler use postfix / doesn't need parentheses
    operator precedence -> a+b*c -> * highest
    a+b-c -> a+b first than - c -> associativity / mostly left to right / right to left is only in assignment
    postfix -> ab+c-
    a+b
        a -> print a
        + -> push on stack [+]
        b -> print b -> ab pop from stack -> ab+
    a+b*c
        a -> print a
        + -> push on stack [+]
        b -> print b -> ab
        * -> push on stack [+*]
        c -> print c -> abc
        pop    -> abc*+
    a*b+c
        a -> print a
        * -> push on stack [*]
        b -> print b -> ab pop * -> ab*
        + -> push on stack [+]
        c -> print c -> ab*c+

    Step1 => operand print
    Step2 => operator push on stack
    Step4 => pop all from stack
    Step3 => complex for precedence
        3.1 scan operator precedence greater than check
        3.2 scan operator precedence less than check
        3.3 scan operator precedence equal check
    a+b*c -> abc*+
 */
public class PostfixTransformer {
    //Step 3.1
    static Map<Character, Integer> precedence = new HashMap<Character, Integer>();

    static {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
    }

    public static String transform(String infix) {
        String postfix = "";
        Stack<Character> opStack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            //step1
            if (isOperand(ch)) {
                postfix += ch;
            } else {
                //Step 2
                if (isOperator(ch)) {
                    if (opStack.isEmpty()) {
                        opStack.push(ch);
                    } else { // stack not empty
                        //Step 3
                        //Step 3.1
                        if (isPrecedenceGreaterThan(ch, opStack.peek())) { // check * > [+](on stack) -> push ch
                            opStack.push(ch);
                        }
                        /*
                            Step 3.2 a*b+c
                               [*] > ch -> pop
                         */
                        // scanner < opStack top
                        else if (isPrecedenceLessThan(ch, opStack.peek())) {
                            while (!opStack.isEmpty() && isPrecedenceGreaterThan(opStack.peek(), ch)) {
                                postfix += opStack.pop();
                            }
                            // stack is empty
                            opStack.push(ch);
                        }
                        /*
                            Step 3.3 Equal case a-b+c
                            x > y is strictly greater
                            !(x < y) is greater than or equal
                         */
                        else if(isPrecedenceEqual(ch, opStack.peek())){
                            //The top of the stack has greater than or equal precedence compared to ch.
                            //While the operator at the top of the stack is not less than the current operator (i.e., it's equal or greater, and should be popped).
                            while (!opStack.isEmpty() && !isPrecedenceLessThan(opStack.peek(), ch)) {
                                postfix += opStack.pop();
                            }
                            // stack is empty
                            opStack.push(ch);
                        }
                    }
                }
            }
        }
        //Step 4
        while (!opStack.isEmpty()) { // isEmpty ma pyit ma chin = until empty do pop -> isEmpty !false = ture -> execute in while loop / isEmpty !true = false exit while loop
            postfix += opStack.pop();
        }
        return postfix;
    }

    static boolean isOperand(char ch) {
        return Character.isLetter(ch);
    }

    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    static boolean isPrecedenceGreaterThan(char lastChar, char firstChar) {
        return precedence.get(lastChar) > precedence.get(firstChar); // get value
    }

    static boolean isPrecedenceLessThan(char lastChar, char firstChar) {
        return precedence.get(lastChar) < precedence.get(firstChar); // get value
    }
    static boolean isPrecedenceEqual(char lastChar, char firstChar) {
        return precedence.get(lastChar).equals(precedence.get(firstChar)); // get value
    }
}
