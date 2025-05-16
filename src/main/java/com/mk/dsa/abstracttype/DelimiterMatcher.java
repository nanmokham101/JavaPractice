package com.mk.dsa.abstracttype;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
    c[d]
    c -> do nothing
    [ -> push stack
    d -> do nothing
    ] -> closing do matcher

    Map -> [,]
    current -> ]
    pop -> [ // opening

    if(current = Map.get(opening)// get closing because pass key and get value in Map
    Time Complexity of Stack is O(1)
 */
public class DelimiterMatcher {
    String input;
    Stack<Character> stack;
    Map<Character, Character> pair;

    public DelimiterMatcher(String input){
        this.stack = new Stack<>();
        this.pair = new HashMap<Character,Character>();
        this.input = input;
        this.init();
    }
    void init(){
        this.pair.put('[',']');
        this.pair.put('{','}');
        this.pair.put('(',')');
    }
    char getClosingChar(char openingChar){
        return this.pair.get(openingChar);
    }
    boolean isOpening(char ch){
        return this.pair.keySet().contains(ch);
       // return ch == '[' || ch == '{' || ch == '(';
    }
    boolean isClosing(char ch){
        return this.pair.values().contains(ch);
        //return ch == ']' || ch == '}' || ch == ')';
    }
    public boolean isValid(){
        for(int i = 0; i < input.length(); i++){
            char currentChar = input.charAt(i);
            if(this.isOpening(currentChar)){
                stack.push(currentChar);
            }
            if(this.isClosing(currentChar)){
                // for ab] -> found ] no need to push anything so stack is empty
                if(this.stack.isEmpty()){
                    return false;
                }
                // for ab] case
                char openingChar = stack.pop();
                System.out.println("Opening Char : "+ openingChar);
                System.out.println("Current Char : "+ currentChar);
                if (isPropertyMatcher(currentChar, openingChar)) {
                    return false;
                }

            }
        }
       // return true; // for testCharPositiveCase a[b]
       return this.stack.isEmpty(); // testCharNegativeCase a[b
    }

    private boolean isPropertyMatcher(char currentChar, char openingChar) {
        char closingChar = getClosingChar(openingChar);
        System.out.println("Closing Char : "+ closingChar);
        if(closingChar != currentChar){ // ] != ]
            return true; //isPropertyMatcher return false
        }
        return false; // go to isValid() return
    }
}
