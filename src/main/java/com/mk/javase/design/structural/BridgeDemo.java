package com.mk.javase.design.structural;

import com.mk.javase.design.structural.bridge.abstraction.Circle;
import com.mk.javase.design.structural.bridge.abstraction.Rectangle;
import com.mk.javase.design.structural.bridge.abstraction.Shape;
import com.mk.javase.design.structural.bridge.implementation.CanvasAPI;
import com.mk.javase.design.structural.bridge.implementation.DrawingAPI;
import com.mk.javase.design.structural.bridge.implementation.SVGAPI;

/*
       2. Bridge ->connect abstraction and implementation, circle rectangle have SVGCircle, CavasCircle want to decoupling
        abstract class Circle{
        }
        class SVGCircle extends Circle{
        }
        class CavasCircle extends Circle{
        }

        Abstraction use polymorphism -> inheritance , implementation use DI composition
 */
public class BridgeDemo {
    public static void main(String[] args) {
        DrawingAPI api = new SVGAPI();
        Shape s = new Circle(api);
        s.draw();

        api = new CanvasAPI();
        s = new Rectangle(api);
        s.draw();
    }
}
