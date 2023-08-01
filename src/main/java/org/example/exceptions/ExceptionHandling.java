package org.example.exceptions;

import java.io.File;
import java.io.IOException;

// Exceptions
//
// error events that disrupt the normal flow of a program,
// leading to crashes.
//
// When an exception is thrown, it can be caught and handled
// using a `try-catch block`.
//
// In a `catch` block, you can obtain more details about the exception
// using methods like `getMessage()` to get the error message.
//
//
// problem:
// Create File
// Write a program that creates a new file, and handles any exception that
// may occur.
public class ExceptionHandling {
    public static void main(String[] args) {
        File file = new File("resources/nonexistent.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Sorry, an error occured: " + e.getMessage());
        }
    }
}
