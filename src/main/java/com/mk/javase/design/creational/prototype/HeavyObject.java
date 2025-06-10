package com.mk.javase.design.creational.prototype;

public class HeavyObject implements Prototype{

    String propertyGetFromDB;
    String computationalHungryProperty;



    static String getPropertyFromDB()
    {
        return "PropertyFromDb";
    }
    static String getComputationalHungryProperty()
    {
        return "ComputationHungryProperty";
    }
    public HeavyObject() {
        this.propertyGetFromDB = HeavyObject.getPropertyFromDB();
        this.computationalHungryProperty = HeavyObject.getComputationalHungryProperty();
    }

    @Override
    public HeavyObject reproduce() {
        try {

            Prototype cop = (Prototype)super.clone();
            HeavyObject newObject = (HeavyObject)cop;

            return newObject;
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "HeavyObject{" + "propertyGetFromDB=" + propertyGetFromDB + ", computationalHungryProperty=" + computationalHungryProperty + '}';
    }


}
