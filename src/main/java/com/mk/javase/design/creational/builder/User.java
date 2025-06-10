package com.mk.javase.design.creational.builder;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    public User(String firstName, String lastName, int age, String school, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public User()
    {
    }

    public User firstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }
    public User lastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }
    public User age(int age)
    {
        this.age = age;
        return this;
    }
    public User address(String address)
    {
        this.address = address;
        return this;
    }
    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address + '}';
    }

    public static void main(String[] args) {
        User u = new User()
                .firstName("Thet")
                .lastName("Khine ")
                .age(27)
                .address("Mdy");
        System.out.println("User "+u);
    }
}
