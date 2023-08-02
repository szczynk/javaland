package org.example.exceptions;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Throwing Exceptions
//
// Java allows us to flag errors within the code by "throwing exceptions".
//
// Checked exceptions (subclasses of "Exception") need to be declared
// in the method signature using the "throws" keyword,
// while unchecked exceptions (subclasses of "RuntimeException")
// do not require explicit declaration.
//
// To create a custom exception, you need to create a new class that
// extends the base "Exception" class and provides constructors
// with different messages.
//
// By providing default constructors for custom exceptions,
// you can use them to throw exceptions with pre-defined messages if needed.
//
// To throw an exception, use the "throw new ExceptionType(message)" syntax
//
//
// problem:
// Write a method that calculates an employee’s pay but does not allow
// overtime as input.
public class ThrowingExceptions {
    public static double calculatePay(double hours, double payRate)
            throws NegativeInputException {
        if (hours > 40) {

            // throw a built-in exception ("IllegalArgumentException")
            throw new IllegalArgumentException("Hours must be less then or equal to 40");
        } else if (hours < 40 || payRate < 40) {

            // throw a custom exception ("NegativeInputException")
            throw new NegativeInputException();
        }

        return hours * payRate;
    }

    // Rethrow Exceptions
    //
    // for this example, we can generate a new file without catch any exception
    //
    // there's no need for a try-catch block
    // if the method intends to propagate / forward the exception to the calling code.
    // the burden is transferred to whoever calls the method,
    // and they can choose to handle it or propagate it further.
    //
    // if multiple exceptions can be thrown,
    // a general Exception can be used as the catch-all
    // using Polymorphism.
    //
    //  if the interface declares an exception,
    //  the implementing class needs to follow the same declaration.
    //  Overriding methods cannot add additional exceptions.
    public static void rethrowException() throws IOException {
        File file = new File("files/nonexistent.txt");
        file.createNewFile(); // This line can throw an IOException
        // If it throws an exception, it will be propagated to the calling code
    }

    public static void rethrowMultipleExceptions()
            throws IOException, InputMismatchException {
        File file = new File("files/nonexistent.txt");
        file.createNewFile();
    }

    // Polymorphic throws statement
    public static void rethrowExceptionPolymorphic()
            throws Exception {
        File file = new File("files/nonexistent.txt");
        file.createNewFile();
        Scanner fileReader = new Scanner(file);
    }
}
