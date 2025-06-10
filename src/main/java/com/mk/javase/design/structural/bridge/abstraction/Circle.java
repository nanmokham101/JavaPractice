package com.mk.javase.design.structural.bridge.abstraction;

import com.mk.javase.design.structural.bridge.implementation.DrawingAPI;

public class Circle extends Shape{

    public Circle(DrawingAPI api){
        super(api);
    }
    @Override
    public void draw() {
        api.drawCircle();
    }
}
