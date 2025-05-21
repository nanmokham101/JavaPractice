package com.mk.javase.string;

import java.util.ArrayList;

enum Gender{
    Male, Female;
}
class Human{
    String name;
    int age;
    Gender gender;

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public Human(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
public class StringAPI {
    public static void main(String[] args) {
        //CompareTo < = -1 , == 0, > = 1 / use for sorting / use only for two items
        System.out.println("Apple.compareTo(Banana) : "+ "Apple".compareTo("Banana")); // A is less than B ,

        ArrayList<Human> list = new ArrayList<>();
        list.add(new Human("Mo Mo",27, Gender.Female));
        list.add(new Human("WPO",26, Gender.Male));
        list.add(new Human("Ni Ni",20, Gender.Female));
        list.add(new Human("Kham Kham",28, Gender.Female));

        list.sort((a,b)-> a.name.compareTo(b.name));
        list.forEach(System.out::println);


        String str = "Hello World";
        System.out.println("IndexOf : "+ str.indexOf("Wo")); // found return the index
        System.out.println("IndexOf : "+ str.indexOf("Wof"));// not found return -1
        System.out.println("LastIndexOf : "+ str.lastIndexOf("o")); // find from last
        //get part of the string the original String not change because String ins Immutable
        System.out.println("SubString(1,4) : "+ str.substring(1,4)); // ell why index 4 o is not present because it allow to be work for length

        //concat = +
        String str2 = str.replaceAll("ll", "LL");
        System.out.println("str : " + str);
        System.out.println("str1 : " + str2);

        String joinStr = String.join(":","Hello ", " World", " Java");
        System.out.println("joinStr : "+ joinStr);
    }
}
