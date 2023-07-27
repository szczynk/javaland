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
// convention:
// - field
// - constructor
// - method
//
//
// problem:
// Write a class that describes the fields and methods of a rectangle.
public class Rectangle {
    protected double length;
    protected double width;
    protected int sides = 4;

    // Constructors are part of classes and are used to initialize objects before use.
    //
    // Constructors are `special` methods -they look like a method but they not really a method-,
    // with the same name as the class and no return type.
    //
    // Constructors can have different types, such as:
    // - default constructors   -> do not take any arguments and set default values for the fields.
    // - all-args constructors  -> take values for all the fields in the class and pass it during
    //                             object creation.
    //
    // by default in Java, the default constructor is already there.
    // if you wanted to actually do something, then go ahead and write an explicit one.
    // So you're really just exposing something that exists under the hood to manipulate it
    // and put in a body there.
    //
    // It is best to use setter methods to set field values instead of directly manipulating
    // them in the constructor.
    //
    // "static" classes do not have default constructors because they do not require sets up
    // state for that object, the initial values.
    public Rectangle() {
        setLength(0);
        setWidth(0);
    }

    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    public void print() {
        System.out.println("I am a rectangle");
    }

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
