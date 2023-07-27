package org.example.objects;

// Instantiating Objects
//
// you didn't have to import Rectangle because it's in the same package
//
// problems:
// Write a class that creates instances of Rectangle to find the total area of
// two rooms in a house.
public class HomeAreaCalculator {
    public static void main(String[] args) {

        // Rectangle or any other object can be a type
        //
        // creating objects of the "Rectangle" class using `new` keyword and call one
        // of its constructors
        Rectangle room1 = new Rectangle(); // using the default constructor
        room1.setLength(50);
        room1.setWidth(25);

        double areaOfRoom1 = room1.calculateArea();

        Rectangle room2 = new Rectangle(30, 75); // using the all-arg constructor

        double areaOfRoom2 = room2.calculateArea();

        double totalArea = areaOfRoom1 + areaOfRoom2;
        System.out.println("Area of both room: " + totalArea);


    }
}
