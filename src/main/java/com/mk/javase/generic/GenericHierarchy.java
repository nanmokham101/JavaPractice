package com.mk.javase.generic;
/*
    no static member for HGeneric
    static T item; // not legal because static is class have only one
    Generic can't extends Throwable -> Can't create generic exception class
    try{
    }catch(Exception e){
    }catch(BusinessException be){
    } // they go with instanceof // in runtime catch check with instanceof

    so we can't
    try{
    }catch(Exception<String> e){
    }catch(Exception<Integer> be){
    } // in runtime it become Object
 */
class Gen<T>{
    T obj;
    Gen(T obj){
        this.obj = obj;
    }
}
class Gen2<T,V> extends Gen<T>{
    V value;
    Gen2(T obj, V value){
        super(obj);
        this.value = value;
    }
    T getKey(){
        return this.obj;
    }
    V getValue(){
        return this.value;
    }
}
public class GenericHierarchy {
    public static void main(String[] args) {
        Gen2<String, Integer> pair = new Gen2<>("Momo",27);
        System.out.println("Key : "+ pair.getKey()+ " --- Value : "+ pair.getValue());

        Gen<String> stringGen = new Gen("Momo");
        if (stringGen instanceof Gen<String>){
            System.out.println("Yes");
        }

        if (stringGen instanceof Gen<?>){
            System.out.println("Yes");
        }

    }
}
