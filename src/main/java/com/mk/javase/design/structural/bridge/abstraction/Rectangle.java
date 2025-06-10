package com.mk.javase.design.structural.bridge.abstraction;

import com.mk.javase.design.structural.bridge.implementation.DrawingAPI;

public class Rectangle extends Shape{
    public Rectangle(DrawingAPI api){
        super(api);
    }
    @Override
    public void draw() {
        api.drawRectangle();
    }
}
