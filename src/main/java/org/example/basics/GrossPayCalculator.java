package org.example.basics;

import java.util.Scanner;

// The name of the class has to be the same name as the file
// Java is case-sensitive
public class GrossPayCalculator {

    // we can write code within the methods
    // the main method is where all Java applications start from
    public static void main(String[] args) {
        // Using System.out.println() to display messages to the command line.
        System.out.println("How many hours did you work?");

        // Reading input from the command line using the Scanner class.
        Scanner scanner = new Scanner(System.in);

        // reads the next token (word) entered by the user until
        // the next whitespace character (space, tab, or newline)
        // is encountered. It then returns the input as an int.
        // and save to variable that we can use
        int hours = scanner.nextInt();

        // Tips: type "sout" for `System.out.println();`
        System.out.println("What is your hourly pay?");

        double rate = scanner.nextDouble();

        // if you don't close the scanner, essentially that resource is leaking,
        // running in a background and start interfering with others
        scanner.close();

        double payRate = hours * rate;

        System.out.println("Gross Pay: " + payRate);
    }
}
