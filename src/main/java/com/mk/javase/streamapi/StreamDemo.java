package com.mk.javase.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human("Mo Mo",27, Gender.Female));
        humans.add(new Human("WPO",26, Gender.Male));
        humans.add(new Human("Ni Ni",20, Gender.Female));
        humans.add(new Human("Kham Kham",28, Gender.Female));
        // Youngest female
        Predicate<Human> isFemale = obj -> obj.gender == Gender.Female;
        Optional<Human> result = humans
                .stream()
                .filter(isFemale)
                .reduce((a,b) -> {
                    return a.age > b.age ? b:a;
                });
        System.out.println(result.get());
    }
}
