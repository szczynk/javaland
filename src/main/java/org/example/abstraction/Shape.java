package org.example.abstraction;

// Abstraction
//
// structures that represent abstract ideas
//
// Abstract classes are implemented by their subclasses
//
// Abstract classes are designed to be extended
// and serve as templates for subclasses.
//
// Abstract classes cannot be instantiated directly;
// they are only used as superclasses for other classes.
//
// Abstract classes can contain both
// `abstract` methods and methods with bodies.
//
// Declare using `abstract` keyword before the class declaration
//
// Useful for defining common characteristics
// and behaviors shared by multiple subclasses.
//
// Abstract methods are methods without a body,
// subclasses *must* implement all the inherited abstract methods
// or declare themselves as abstract classes.
//
// Abstract methods provide a common structure for subclasses to follow,
// ensuring consistent behavior.
//
//
// problem:
// Create an abstract `Shape` class and create a `Rectangle` class that
// inherits from it.
public abstract class Shape {
    abstract double calculateArea();

    public void print() {
        System.out.println("I'm a shape");
    }
}
