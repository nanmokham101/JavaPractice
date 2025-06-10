package com.mk.javase.design.structural.bridge.abstraction;

import com.mk.javase.design.structural.bridge.implementation.DrawingAPI;

public abstract class Shape {
    DrawingAPI api;
    Shape(DrawingAPI api){
        this.api = api;
    }
    public abstract void draw();
}
