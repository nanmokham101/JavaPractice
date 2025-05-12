package com.mk.javase.oop.interfac;
/*
    First class function - Concern with Functional Programming
    fun ta ku htae ka fun ko variable htae lo ya tl fun ko fun a nay nk parameter accept lo ya
    Can assign fun to variable, Can pass parameter as fun
 */
interface IOne{
    int getNum();

    default String getString() {
        return "Hello";
    }

    static String getStaticMethod() {
        return "This is Static method";
    }

}
class One implements IOne{

    @Override
    public int getNum() {
        return 123;
    }
    @Override
    public String getString(){
        return "One Two Three";
    }
}
public class DefaultMethod {
    public static void main(String[] args) {
        IOne one = new One();
        System.out.println(one.getNum());
        System.out.println(one.getString());
        System.out.println(IOne.getStaticMethod());
    }

}
