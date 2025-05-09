package com.mk.coodleet.practice;

import java.util.HashSet;
import java.util.Set;

//program to remove duplicates characters from given String in Java
public class RemoveDuplicateString {
    public static void main(String[] args) {
        String str = "apple";
        StringBuilder sb = new StringBuilder();
        Set<Character> seenCharacters = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (!seenCharacters.contains(currentChar)) {
                seenCharacters.add(currentChar);
                sb.append(currentChar);
            }
        }
        System.out.println(sb.toString());
    }
}
