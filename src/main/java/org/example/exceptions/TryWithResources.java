package org.example.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Try With Resources
//
// declaration of resources that should be automatically closed
// after the execution of a try block
//
// "Try with resources" is a better approach as it automatically closes
// the declared resources after the try block execution,
// providing more concise and effective resource management.
//
// When using "try with resources", the resources should
// implement the "AutoClosable" interface for this automatic behavior to work.
//
// the syntax for The syntax for "try with resources" is
// declaring the resources within the parentheses "()" after the try keyword.
//
// Multiple resources can be declared within the parentheses,
// and they will all be closed automatically at the end of the try block.
//
//
// problem:
// Auto-close File Reader
// Automatically close file reader within try block
public class TryWithResources {
    public static void main(String[] args) {
        File inputFile = new File("files/numbers.txt");

        try (
                Scanner fileReader = new Scanner(inputFile);
        ) {
            while (fileReader.hasNext()) {
                System.out.println(fileReader.nextDouble());
            }
        } catch (FileNotFoundException | InputMismatchException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
