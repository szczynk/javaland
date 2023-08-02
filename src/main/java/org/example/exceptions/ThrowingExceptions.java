package org.example.exceptions;

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
}
