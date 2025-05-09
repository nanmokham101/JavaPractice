package com.mk.collection;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
List = Just a name, a promise — it says:

"Hey, I can hold a bunch of things in order, and let you add, get, and remove them."

But it doesn’t say how it stores them. It’s like saying "I need a container" — you haven’t picked a basket or a box yet.
*
ArrayList = A real structure — it says:

"I store things using a dynamic array under the hood."

It's like saying: "Okay, I’ll use a plastic basket to hold my fruits."

List<String> box = new ArrayList<>();
box = the container name (as a List — abstract)

new ArrayList<>() = the real container (concrete)

So yes — fruit is the item, and ArrayList is the basket you use to hold and manage those fruits.
*/
@Slf4j
public class ListDemo {
    List<Passenger> passengers = new ArrayList<>(20);
    public ListDemo(){
        Passenger p = new Passenger("Mo","Ygn");
        Passenger p1 = new Passenger("Mo1","Mdy");
        Passenger p2 = new Passenger("Mo1","Ygn");
        passengers.add(p);
        passengers.add(p1);
        passengers.add(p2);
    }

    private List<Passenger> getPassengersByAddress(String address) {
        return passengers.stream()
                .filter(it -> it.getAddress().equals(address))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ListDemo listDemo = new ListDemo();
        List<Passenger> passengerList = listDemo.getPassengersByAddress("Ygn");
        /*
        for(Passenger passenger : passengerList){
            log.info(passenger.toString());
        }
        passengerList.forEach(System.out::println);
        */
        passengerList.forEach(p -> log.info(p.toString()));

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(passengerList);
            log.info("Passenger JSON: {}", json);
        } catch (Exception e) {
            log.error("Error converting to JSON", e);
        }
    }
}
