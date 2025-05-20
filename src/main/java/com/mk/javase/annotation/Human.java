package com.mk.javase.annotation;

import java.util.Date;

public class Human {
    @NotNull()
    public String name;
    @NotNull(message = "Please enter address. Shouldn't be null")
    public String address;

    public Date dob;
}
