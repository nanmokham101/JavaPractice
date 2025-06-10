package com.mk.javase.design.structural.bridge.implementation;

public class SVGAPI implements DrawingAPI{
    @Override
    public void drawCircle() {
        System.out.println("Draw SVG Circle");
    }

    @Override
    public void drawRectangle() {
        System.out.println("Draw SVG Rectangle");
    }
}
