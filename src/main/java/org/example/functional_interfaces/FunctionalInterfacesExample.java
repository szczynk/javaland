package org.example.functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

// Functional programming is programming style that based on pure
// mathematical functions applied to input sets to produce output sets.
//
// A functional interface is interface that has just one abstract method
// and can be implemented using lambda expressions or method references.
//
// Java has the java.util.function package that contains several functional interfaces.
// Core functional interfaces in java.util.function:
// - Consumer       : Accepts one argument and returns no result.
// - Supplier       : Returns a value without accepting any input.
// - Predicate      : Accepts one argument and returns a Boolean value.
// - Function       : Accepts one argument and produces a result.
// - UnaryOperator  : A specific type of Function that accepts and returns the same type.
// - BinaryOperator : A specific type of Function that accepts two arguments of the same type
//                    and returns the same type.
//
// Functional interfaces can have default and static methods
// in addition to the single abstract method.
//
// To create a custom functional interface, annotate it with `@FunctionalInterface`,
// which enforces the single abstract method rule.
//
// Generic types (`T` and `R`) can be used in functional interfaces
// to represent any object type.
//
// Custom functional interfaces can also include static and default methods,
// just like the core functional interfaces.
public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        // Example 1: Consumer functional interface
        // Consumer: Accepts one argument and performs an action on it
        List<String> countries = Arrays.asList("USA", "Canada", "UK", "Australia");
        // Consumer<String> printCountry = country -> System.out.println(country);
        Consumer<String> printCountry = System.out::println;
        countries.forEach(printCountry);
        System.out.println();

        // Example 2: Supplier functional interface
        // Supplier: Provides a value without taking any input
        Supplier<Integer> randomNumberSupplier = () -> (int) (Math.random() * 100);
        int randomNum = randomNumberSupplier.get();
        System.out.println("Random number: " + randomNum);
        System.out.println();

        // Example 3: Predicate functional interface
        // Predicate: Tests a condition on the input and returns a boolean
        Predicate<String> startsWithU = country -> country.startsWith("U");
        System.out.println("Countries starting with 'U':");
        for (String country : countries) {
            if (startsWithU.test(country)) {
                System.out.println(country);
            }
        }
        System.out.println();

        // Example 4: Function functional interface
        // Function: Accepts an argument, processes it, and returns a result
        Function<String, Integer> getCountryLength = country -> country.length();
        System.out.println("Length of each country name:");
        for (String country : countries) {
            int length = getCountryLength.apply(country);
            System.out.println(country + ": " + length);
        }
        System.out.println();

        // Example 5: UnaryOperator functional interface
        // UnaryOperator: A specific type of Function where input and output types are the same
        UnaryOperator<Integer> doubleOperator = num -> num * 2;
        int doubledValue = doubleOperator.apply(6);
        System.out.println("Double of 6: " + doubledValue);
        System.out.println();

        // Example 6: BinaryOperator functional interface
        // BinaryOperator: A specific type of Function where input and output types are the same
        BinaryOperator<Integer> sumOperator = (num1, num2) -> num1 + num2;
        int sumResult = sumOperator.apply(10, 20);
        System.out.println("Sum of 10 and 20: " + sumResult);
        System.out.println();

        // Example 7: Custom functional interface
        // Custom functional interface example
        MathOperation addOperation = (a, b) -> a + b;
        System.out.println("Custom addition: " + addOperation.operate(15, 7));
    }

    // Custom functional interface with one abstract method 'operate'
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }
}
