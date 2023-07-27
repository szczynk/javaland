package org.example.methods;

import java.util.Scanner;

// Methods
// - used to break complex programs into smaller, manageable pieces.
// - designed to be used by other code
// - can be accessed from outside the class.
//
// The method header consists of the access modifier, non-access modifier,
// return type, method name, and parameter list.
//
// Access modifiers (e.g., public, private, protected)
// control the visibility of methods outside the class.
//
// Non-access modifiers (e.g., static, final, abstract)
// modify the behavior of methods.
//
// the "static" keyword is not related to Java's static typing;
// it means that the method can be used without instantiating
// an object.
// Also, "static" indicate that the method belongs to the class,
// not instances of the class.
//
// All methods are required to specify a return type,
// indicating the data type of the value that will be returned
// to the caller.
//
// If a method does not return anything, the return type is
// specified as "void"
//
// The method name, by convention, starts with a lowercase `verb` and
// uses camel case.
//
// Methods can have parameters in the parameter list, which
// specify the data that must be sent to the method when it's called.
//
// Methods are uniquely identified by their signatures,
// consisting of the method name and parameter list.
//
// Overloaded methods:
// A class can have multiple methods with the same name,
// but they must have unique parameter lists.
// providing flexibility in calling methods with different data types.
//
// Variables declared inside a method are local to that method and
// do not conflict with variables of the same name in other methods.
//
//
// introducing Java's `local variable type inference`
// allowing the use of 'var' to infer the data type of
// variable based on its assigned value.
//
// Instead of explicitly declaring a variable, like `boolean isWaterWet = true;`,
// you can use var, like `var isWaterWet = true;`.
//
// 'var' does not make Java dynamically typed; it still retains static typing.
//
// and it can only be used for `local` variables, not `global` ones.
//
// It is useful for situations where the data type is not known beforehand,
// like when calling methods that return values of unspecified types.
//
// Java will show the inferred data type when hovering over a 'var' variable.
//
// It is essential to ensure that the inferred type matches the required type
// for certain operations (e.g., int vs. double).
//
//
// problem:
// Write a method that asks a user for their name,
// then another method that greets the user by name.
public class GreetUser {
    // The `String[] args` parameter allows the program to receive
    // these command-line arguments as an array of strings.
    public static void main(String[] args) {
        String name = getUserName();
        greetUser(name);
    }

    public static String getUserName() {
        System.out.println("Enter your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        scanner.close();

        return name;
    }

    public static void greetUser(String name) {
        System.out.println("Hi there, " + name);
    }
}
