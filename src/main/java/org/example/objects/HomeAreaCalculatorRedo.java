package org.example.objects;

import java.util.Scanner;

// Sending & Receiving Objects.
//
// Objects can be passed into methods and returned from methods.
//
// Objects can be used similar to primitive data types but offer more capabilities.
//
//
// problem:
// Redo HomeAreaCalculator to include a `calculateArea()` method that accepts
// two Rectangles and a `getRoom()` method that returns a `Rectangle`.
public class HomeAreaCalculatorRedo {
    private Scanner scanner = new Scanner(System.in);

    // in this specific example, it's done for demonstration purposes.
    // In real-world applications, it's not typical to instantiate a class inside the main method.
    // Usually, the main method serves as an entry point to the application
    // and kicks off the rest of the program,
    // which involves working with other classes and methods
    // rather than creating instances within main.
    public static void main(String[] args) {
        // we need to instantiate the `HomeAreaCalculatorRedo` class to:
        // 1. Accessing Non-Static Methods: The methods inside the `HomeAreaCalculatorRedo` class,
        //    such as `getRoom()` and `calculateAreaOfRoom()`, are non-static. Non-static methods
        //    are associated with objects, and they require an instance of the class to be called.
        //    By instantiating the class, we create an object that can invoke these non-static
        //    methods.
        //
        //    In short, It grants access to non-static methods,
        //    like `getRoom()` and `calculateAreaOfRoom()`.
        //
        // 2. Accessing Instance Variables: In the `getRoom()` method, the instructor uses
        //    a `Scanner` object called `scanner` to read user input for room's length and width.
        //    The `scanner` object is a member of the class and referred to as an instance
        //    variable. To use `scanner` inside the method, we need to have an instance of
        //    the class, which is achieved through instantiation.
        //
        //    In short, It allows us to use instance variables,
        //    such as the `scanner` object for user input.
        //
        // 3. Encapsulation and State Management: The `HomeAreaCalculatorRedo` class encapsulates
        //    the behavior and data related to the home area calculations. By creating
        //    an instance of the class, we ensure that each calculation and set of data
        //    is independent and isolated from other instances. This encapsulation helps
        //    manage the state and data of each calculator separately.
        //
        //    In short, it enables encapsulation and
        //    state management for independent calculations.
        //
        // 4. Object Identity: Each instance of a class represents a unique object in memory.
        //    By instantiating the class, we create a specific object with its own memory space
        //    and unique identity. This allows us to manipulate and work with different instances
        //    independently.
        //
        //    In short, it creates unique objects with their own identity
        //    for distinct manipulations.
        HomeAreaCalculatorRedo calculatorRedo = new HomeAreaCalculatorRedo();
        Rectangle room1 = calculatorRedo.getRoom();
        Rectangle room2 = calculatorRedo.getRoom();

        double totalArea = calculatorRedo.calculateAreaOfRoom(room1, room2);
        System.out.println("Area of both room: " + totalArea);
    }

    // for example, we didn't instantiate the `HomeAreaCalculatorRedo` class and
    // make `getRoom()` a static method, such as `public static Rectangle getRoom()`.
    // now the problem is we don't access to the global variables in this class.
    //
    // so we need that instantiating the `HomeAreaCalculatorRedo` class and make
    // `getRoom()` a non-static method,
    //
    // getRoom(), which prompts the user for room length and width
    // and returns a Rectangle object.
    public Rectangle getRoom() {
        System.out.println("Enter length of the room");
        double length = scanner.nextDouble();

        System.out.println("Enter width of the room");
        double width = scanner.nextDouble();

        return new Rectangle(length, width);
    }

    // calculateAreaOfRoom() method takes two Rectangle objects
    // as arguments and returns the total area of both rooms.
    public double calculateAreaOfRoom(Rectangle room1, Rectangle room2) {
        return room1.calculateArea() + room2.calculateArea();
    }
}
