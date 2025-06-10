package com.mk.javase.design.structural.adapter;

public class ClassAdapter extends OldAPI implements Framework{
    @Override
    public void add(Integer item) {
        this.addItem(item);//Here call to old API method
    }

    public static void main(String[] args) {
        Framework framework = new ClassAdapter();
        framework.add(30);
    }
}
