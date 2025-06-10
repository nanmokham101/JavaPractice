package com.mk.javase.design.structural.adapter;

public class ObjectAdapter implements Framework{
    OldAPI oldAPI = new OldAPI();
    @Override
    public void add(Integer item) {
        oldAPI.addItem(item);//Here call to old API method
    }

    public static void main(String[] args) {
        Framework framework = new ObjectAdapter();
        framework.add(40);
    }
}
