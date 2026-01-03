package com.mk.javase.oop.polymorphism;

import lombok.extern.slf4j.Slf4j;

/*
    Encapsulation : protect internal state, disallow invalid operation
    Override is related with polymorphism.
    Imagine NGO product, Human -> work, Teacher -> work, Doctor -> work
*/@Slf4j
class Teacher{
    void work(){
        log.info("Teacher work");
    }
}
@Slf4j

class Doctor{
    void work(){
        log.info("Doctor work");
    }
}
@Slf4j
class Engineer1{
    void work(){
        log.info("Engineer1 work");
    } // same with     System.out.println();
}
// if add Engineer need to modify the exiting code. Violate OCP ( Open Close Principal)
public class WhyPolymorphism {
    public static void main(String[] args) {

        Object[] humans = new Object[]{
                new Teacher(),
                new Doctor(),
                new Engineer1() // 1,
        };
        for(Object obj : humans){
            if(obj instanceof Teacher){
                Teacher teacher = (Teacher) obj;
                teacher.work();
            }
            if(obj instanceof Doctor){
                Doctor doctor = (Doctor) obj;
                doctor.work();
            }
            if(obj instanceof Engineer1){ //2,
                Engineer1 engineer1 = (Engineer1) obj;
                engineer1.work();
            }
        }
    }
}
