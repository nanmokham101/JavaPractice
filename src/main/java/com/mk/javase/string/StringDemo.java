package com.mk.javase.string;

public class StringDemo {
    public static void main(String[] args) {
        String str = "Hello";
        String str1 = "Hello";
        System.out.println("str == str1 : "+ str.equals(str1));

        boolean flag = false;
        String flagStr = String.valueOf(flag);// flag+"";
        System.out.println("flagstr : "+flagStr);

        System.out.println("CharAt 0 : "+ str.charAt(0));

        char[] chars = new char[5];
        str.getChars(0,5, chars,0); // 0,5 is index of source start and end, 0 is begin of destination
        for(char ch : chars){
            System.out.println("Ch : "+ ch);
        }

        System.out.println("Apple".equalsIgnoreCase("apple"));

        String str2 = "Hello";
        String str3 = "ll";
        System.out.println(str2.regionMatches(2,str3,0,2)); // 2 index of source, 0 begin of destination, 2 length of destination
    }
}
