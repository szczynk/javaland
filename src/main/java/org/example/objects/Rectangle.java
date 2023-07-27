package org.example.objects;

// Object
// Java is an object-oriented programming language.
//
// Objects in Java contain data (fields/variables) and behavior (methods).
//
// Classes are used to define the structure of an object.
//
// Encapsulation is one of the core principles of object-oriented programming in Java.
// Encapsulation means containing data and behavior within the object and restricting
// access to data using private access modifiers.
//
// Getter and setter methods (accessor methods, mutator methods) are used to allow
// controlled access to the fields of an object.
//
// in IntelliJ, you can right-click and select Generate or
// you can `Alt + Ins`, select `Getter and Setter`, and select the field you want to generate
//
// Private access modifier is used to protect the fields from direct access.
//
// The "this" keyword is used to differentiate between local and global variables in the class.
//
//
// problem:
// Write a class that describes the fields and methods of a rectangle.
public class Rectangle {
    protected double length;
    protected double width;
    protected int sides = 4;


    public double calculatePerimeter() {
        return (2 * length) + (2 * width);
    }

    public double calculateArea() {
        return length * width;
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
}
