package org.example.inheritence;


// Chain of Inheritance
//
// a class can only explicitly inherit from one superclass.
// but a superclass can also inherit from another class.
//
// There is no inherent limit to how deep the inheritance chain can be.
//
// The Object class is the root class in Java,
// and every class implicitly or explicitly inherits from it.
//
// The Object class provides these common methods
// are available to all classes:
// - equals
// - hashCode
// - toString
//
//
// Inheritance is a one-way relationship.
// A parent or ancestor class does not inherit anything from its subclasses.
// The hierarchy flows from parent to child.
// e.g.
//           Vehicle
//              ↓
//             Car
//              ↓
//          SportsCar
//              ↓
//      ConvertibleSportsCar
//
// The objects of `ConvertibleSportsCar` have access to all the fields and methods
// defined in each class along the inheritance chain.
//
// Classes that inherit from the same superclass are not considered related to each other
// beyond having the same parent. There is no Java-specific term for two classes that
// inherit from the same parent.
//
// Java does not support sibling relationships between classes,
// where two classes inherit from the same parent and are related to each other.
// All relationships in inheritance are hierarchical,
// with one class inheriting from another.
//
// inheritance allows the subclass to access and use methods and fields
// from its parent classes, providing code reuse and organization benefits.
public class ChainOfInherit {
    public static void main(String[] args) {
        ConvertibleSportsCar car = new ConvertibleSportsCar("Ferrari", 2, true, "Soft-top");
        car.displayInfo();
    }
}

// The top-level class in the hierarchy
class Vehicle {
    String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
    }
}

// Car class inherits from Vehicle
class Car extends Vehicle {
    int numDoors;

    public Car(String brand, int numDoors) {
        super(brand);
        this.numDoors = numDoors;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of doors: " + numDoors);
    }
}

// SportsCar class inherits from Car
class SportsCar extends Car {
    boolean isConvertible;

    public SportsCar(String brand, int numDoors, boolean isConvertible) {
        super(brand, numDoors);
        this.isConvertible = isConvertible;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Is convertible: " + isConvertible);
    }
}

// ConvertibleSportsCar class inherits from SportsCar
class ConvertibleSportsCar extends SportsCar {
    String roofType;

    public ConvertibleSportsCar(String brand, int numDoors, boolean isConvertible, String roofType) {
        super(brand, numDoors, isConvertible);
        this.roofType = roofType;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Roof type: " + roofType);
    }
}

