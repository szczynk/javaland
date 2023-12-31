package org.example.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Multiple Exception
//
// Java allows handling multiple exceptions at once using three methods:
// - polymorphism
// - multiple catch blocks
// - a single catch block with multiple exceptions
//
// Polymorphism involves catching broader exceptions by using
// a superclass in the catch block.
// Catching "Exception" will handle any subclass exception as well.
//
// e.g. if `ArrayIndexOutOfBoundsException` occurred, we can use "Exception"
// because
// ```java
//  java.lang.Object
//      java.lang.Throwable
//          java.lang.Exception
//              java.lang.RuntimeException
//                  java.lang.IndexOutOfBoundsException
//                      java.lang.ArrayIndexOutOfBoundsException
// ```
//
// Multiple catch blocks can be used to handle different
// types of exceptions individually.
//
// A single catch block with multiple exceptions can handle
// multiple related exceptions in one block.
//
// If using a single catch block with multiple exceptions,
// it's essential to place the "most specific exceptions first and the broader ones last",
// as only the first matching catch block will be executed.
//
// we can separate that multiple exception with a pipe "|".
//
// It's essential to close resources like file readers properly
// to avoid resource leaks and ensure smooth resource management.
//
// Using the `finally` block to close resources is a way to guarantee cleanup,
// but it may not handle exceptions ideally.
//
// best practices:
// - use specific exception
// - do not hide the exception
// - close resource properly
// - log exceptions
// - test your exceptions
//
//
// problem:
// Read File
// Write a program that reads decimal numbers from a file, and handle the
// two types of exceptions that come from that
public class MultipleExceptionHandling {
    public static void main(String[] args) {
        File file = new File("files/numbers.txt");
        Scanner fileReader = null;

        // Multiple catch blocks - individual exception
        try {
            fileReader = new Scanner(file);
            while (fileReader.hasNext()) {
                System.out.println(fileReader.nextDouble());
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound occurred: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("InputMismatch occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the file reader in a `finally` block to ensure resource closed
            //
            //
            // problem:
            // Close the File Reader
            // Update the program to close the file reader
            if (fileReader != null) {
                fileReader.close();
            }
        }

        System.out.println();

        // a single catch block - multiple exception
        try {
            fileReader = new Scanner(file);
            while (fileReader.hasNext()) {
                System.out.println(fileReader.nextDouble());
            }
        } catch (FileNotFoundException | InputMismatchException e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace(); // prints a stack trace
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }
}
