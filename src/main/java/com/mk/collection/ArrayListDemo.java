package com.mk.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.stream.Collectors;
/*
1. List is an interface
    It’s like a general rule or contract. It cannot store data directly.
    List<Passenger> list; // Just a reference. Cannot use it unless we assign a real object.

2. ArrayList is a class
    It’s the actual object that stores data.
        When we say:

        new ArrayList<>();
        That means we are creating a real, empty structure in memory to store values.

        ✅ Putting them together:
        You can do:
        List<Passenger> passengers = new ArrayList<>();
        This means:
        You declare the variable as List (general rule)
        But you create the object using new ArrayList<>()

        🔄 Why do we use List type but new ArrayList<>()?
        Because it gives us flexibility.
        Later, you can change it to LinkedList or something else without changing your code everywhere:
        List<Passenger> passengers = new LinkedList<>();

        🧠 So when you say:
        Why already can call passengers in List?

        Because we actually did create the object using new ArrayList<>(). The variable is of type List, but the real object behind it is an ArrayList.
 */
@Slf4j
public class ArrayListDemo {
    private ArrayList<Passenger> passengers = new ArrayList<>(20);
    public ArrayListDemo(){
        Passenger p = new Passenger("Mo","Ygn");
        Passenger p1 = new Passenger("Mo1","Mdy");
        Passenger p2 = new Passenger("Mo1","Ygn");
        passengers.add(p);
        passengers.add(p1);
        passengers.add(p2);
    }
    public ArrayList<Passenger> getPassengersByAddress(String address) {
        return new ArrayList<Passenger>(passengers.stream()
                .filter(it -> it.getAddress().equals(address))
                .collect(Collectors.toList()));
    }
    /*
    * The collect(Collectors.toList()) operation still returns a List. While an ArrayList is a List (due to inheritance),
    * the method signature explicitly states that it must return an ArrayList
    * */

    public static void main(String[] args) {
        ArrayListDemo arrayListDemo = new ArrayListDemo();
        ArrayList<Passenger> passengerArrayList = arrayListDemo.getPassengersByAddress("Ygn");

        passengerArrayList.forEach(p -> log.info(p.toString()));
    }
}
