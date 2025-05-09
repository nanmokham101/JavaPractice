package com.mk.streamapi;

import com.mk.collection.Passenger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/* 4.   Mapping
        Transform each element in a stream into a different type.
        Can use it to extract specific data from objects, perform calculations, or convert objects into entirely new ones.
  */
public class MappingDemo {
        public static void main(String[] args) {
            List<Passenger> passengers = Arrays.asList(
                    new Passenger("Alice", "Phnom Penh"),
                    new Passenger("Bob", "Siem Reap"),
                    new Passenger("Charlie", "Phnom Penh")
            );
            // 1. Mapping to Extract a Single Field:
            List<String> passengerNames = passengers.stream()
                    .map(Passenger::getName) // Map each Passenger object to its name
                    .collect(Collectors.toList());

            System.out.println("Passenger Names: " + passengerNames); // Output: Passenger Names: [Alice, Bob, Charlie]

            //2. Mapping to Perform an Operation:
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
            List<Integer> squaredNumbers = numbers.stream()
                    .map(n -> n * n) // Map each number to its square
                    .collect(Collectors.toList());

            System.out.println("Squared Numbers: " + squaredNumbers); // Output: Squared Numbers: [1, 4, 9, 16, 25]

            //3. Mapping to Create a New Object:
            List<PassengerInfo> passengerInfos = passengers.stream()
                    .map(p -> new PassengerInfo(p.getName(), String.valueOf(p.getAddress().charAt(0)))) // Map Passenger to PassengerInfo
                    .collect(Collectors.toList());

            System.out.println("Passenger Infos: " + passengerInfos);
            //Passenger Infos: [Passenger{name='Alice', address='P'}, Passenger{name='Bob', address='S'}, Passenger{name='Charlie', address='P'}]
        }
}
