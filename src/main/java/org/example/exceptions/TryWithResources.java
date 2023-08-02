package org.example.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

// Multiple resources can be declared within the parentheses,
// and they will all be closed automatically at the end of the try block.
//
// The auto-closable resources are automatically closed
// in the reverse order of their declaration
// within the try block (i.e., first in, last out).
//
// If the order of resource closure matters,
// they can be arranged accordingly in the try-with-resources block.
//
//
// problem:
// Auto-close File Reader
public class TryWithResources {
    public static void main(String[] args) {
        File inputFile = new File("files/numbers.txt");
        File outputFile = new File("files/output.txt");

        try (
                Scanner fileReader = new Scanner(inputFile);

                // change the output of the program from printing to the console
                // to writing the contents to a new file.
                //
                // PrintWriter is widely used for writing formatted text data
                // to files, network sockets, or other output streams.
                //
                //
                // problem:
                // Print to File
                // Change printer from System to PrintWriter.
                // Auto-close both resources within try block
                PrintWriter fileWriter = new PrintWriter(outputFile);
        ) {
            while (fileReader.hasNext()) {
                // System.out.println(fileReader.nextDouble());

                fileWriter.println(fileReader.nextDouble());
            }
        } catch (FileNotFoundException | InputMismatchException e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}