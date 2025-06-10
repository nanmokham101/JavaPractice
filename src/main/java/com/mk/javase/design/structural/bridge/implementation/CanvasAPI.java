package com.mk.javase.design.structural.bridge.implementation;

public class CanvasAPI implements DrawingAPI{
    @Override
    public void drawCircle() {
        System.out.println("Draw Canvas Circle");
    }

    @Override
    public void drawRectangle() {
        System.out.println("Draw Canvas Rectangle");
    }
}
