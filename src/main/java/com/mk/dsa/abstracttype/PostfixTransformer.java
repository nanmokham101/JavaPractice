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
/**
 *
 *
 Step 1 : Scan the Infix Expression from left to right.
 Step 2 : If the scanned character is an operand,
 append it with final Infix to Postfix string.
 Step 3 : Else,//operator
 Step 3.1 : If the precedence order of the scanned(incoming) operator is greater than the precedence order of the operator in the stack
 (or the stack is empty or the stack contains a ‘(‘ or ‘[‘ or ‘{‘), push it on stack.
 Step 3.2 : Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. (If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.)
 Step 4 : If the scanned character is an ‘(‘ or ‘[‘ or ‘{‘, push it to the stack.
 Step 5 : If the scanned character is an ‘)’or ‘]’ or ‘}’, pop the stack and and output it until a ‘(‘ or ‘[‘ or ‘{‘ respectively is encountered, and discard both the parenthesis.
 Step 6 : Repeat steps 2-6 until infix expression is scanned.
 Step 7 : Print the output
 Step 8 : Pop and output from the stack until it is not empty.

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
            } else if (isOperator(ch)) {//Step 3
                //Step 3.1
                if(opStack.isEmpty()){
                    opStack.push(ch);
                }
                else if(!opStack.isEmpty() && isPrecedenceGreaterThan(ch, opStack.peek())){
                    opStack.push(ch);
                }
                else if(!opStack.isEmpty() && opStack.peek() == '('){
                    opStack.push(ch);
                }
                else if(!opStack.isEmpty() && (isPrecedenceLessThan(ch, opStack.peek()) || isPrecedenceEqual(ch, opStack.peek()))){
                    while (!opStack.isEmpty() && !isPrecedenceLessThan(opStack.peek(), ch)) {
                        postfix += opStack.pop();
                    }
                    // stack is empty
                    opStack.push(ch);
                }
            }else if(ch == '('){
                    /*
                        Step 4  ( -> push
                                  ) -> pop
                     */
                opStack.push(ch);
            }else if(ch == ')'){
                    /*
                        Step 5 -> pop until found ( opening bracket
                        (a+b)*c -> ab+c*
                     */
                while (!opStack.isEmpty() && opStack.peek() != '('){
                    char op = opStack.pop();
                    if(op != '(' || op != ')') {
                        postfix += op;
                    }
                }
                opStack.pop();
            }
        }

        //Step 4
        while (!opStack.isEmpty()) { // isEmpty ma pyit ma chin = until empty do pop -> isEmpty !false = ture -> execute in while loop / isEmpty !true = false exit while loop
            char operator = opStack.pop();
            if(operator != '(' || operator != ')') {
                postfix += operator;
            }
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
        try {
            return precedence.get(lastChar) > precedence.get(firstChar); // get value
        }catch (Exception e){
            return false;
        }

    }

    static boolean isPrecedenceLessThan(char lastChar, char firstChar) {
        try {
            return precedence.get(lastChar) < precedence.get(firstChar); // get value
        }catch (Exception e){
            return false;
        }
    }

    static boolean isPrecedenceEqual(char lastChar, char firstChar) {
        return precedence.get(lastChar).equals(precedence.get(firstChar)); // get value
    }

    public static void main(String[] args) {
        String output = PostfixTransformer.transform("a+(b*c+d)/e");
        System.out.println(output);
    }
}
