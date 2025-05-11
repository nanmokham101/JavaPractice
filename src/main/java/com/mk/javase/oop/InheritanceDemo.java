package com.mk.javase.oop;
/*
    Parent / Child, Super/Sub, Base/Derived, Generalized / Specialized
    Additional feature + added feature
    Not to Destructive modification. Can use the parent code, modification, extend without touch the parent code.
    Should write override method with same feature from parent.
    Can reuse method and properties. Child own that parent own.
    In design, should use the properties only internal state. If the outside want to use call from behavior like method. Like direct use the parent phone, should say please call the phone for me.
    Can insert every child object to parent object reference.
    Super class reference = super , child -> super typing / sub typing

*/

class Button{
    protected String color;

    public Button(String color) {
        this.color = color;
    }

    void paint(){
        System.out.println("Button paint with "+ this.color );
    }
}
class Win95Button extends Button{
    public Win95Button(String color) {
        super(color);
    }

    void paint(){
        super.paint();
        System.out.println("Win95 Button paint with " + color);
    }
}
public class InheritanceDemo {
    public static void main(String[] args) {
        Button button = new Win95Button("red");
        button.paint();
    }
}

