package com.mk.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Passenger {
    private String name;
    private String address;

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
