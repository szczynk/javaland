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
// e.g. on `ArrayIndexOutOfBoundsException`
// ```java
// String[] places = {“work”, “school”, “the cinema”};
// for(int i=0; i<4; i++){
//     System.out.println(“I am going to “ + places[i]);
// }
// ```
//
// ==============================
//
// Exceptions in Java are divided into two categories:
// - checked    : - exceptions that are "checked" by the compiler.
//                - The compiler ensures that calling methods "must handle"
//                  these exceptions.
//                - are used when it's "reasonable" that a calling method
//                  can recover from the error.
//                - e.g. on creating a new file
//                  ```java
//                  File file = new File("resources/nonexistent.txt");
//
//                  file.createNewFile();
//                  // we can't compile this directly, we must put a try-catch
//                  // because `createNewFile()` throwing an exception
//                  ```
//
// - unchecked  : - exceptions that are "not checked" by the compiler.
//                - are runtime exceptions, and handling these exceptions
//                  is "optional".
//                - are used when "there is no practical way to recover"
//                  from the error.
//                - While it's "optional", they can be caught and handled
//                  using a try-catch block if needed.
//                - e.g. on `InputMismatchException`
//                  ```java
//                  Scanner console = new Scanner(System.in);
//
//                  double input = console.nextDouble();
//                  // this can compile, we don't have put a try-catch
//                  // because `nextDouble()` didn't tell us it
//                  // throwing an exception
//                  ```
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
            System.out.println("Sorry, an error occurred: " + e.getMessage());
        }
    }
}
