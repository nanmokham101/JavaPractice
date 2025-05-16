package com.mk.dsa.abstracttype;

import java.util.Stack;

public class ReserveWord {
    public static void main(String[] args) {
        String str = "Hello";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));
        }
        String reverseWord = "";
        while(! stack.isEmpty()){ //! isEmpty true = false;
            reverseWord += stack.pop();
        }
        System.out.println("Reserve Word : "+ reverseWord);
    }
}
