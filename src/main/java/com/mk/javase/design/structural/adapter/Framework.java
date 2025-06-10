package com.mk.javase.design.structural.adapter;
/*
    want to add new
    1. Adapter -> 3pin to 2pin -> want to add and use different interface's parameter, method
        class API{
            push();
        }
        class Adapter
        class NewAPI extends API{ // child can use parent data -> can violate the encapsulation
            add(){
                super.push();
            }
        }
        tightly coupling
        if use inheritance can extends one class -> if want to use more class use composition
        favour composition over inheritance
        class NewAPI{
            API api = new API(): // can use different implementation not direct to concrete
            add(){
                api.push();
            }
        }
 */
public interface Framework {
    void add(Integer item);
}
