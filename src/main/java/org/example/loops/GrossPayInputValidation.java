package org.example.loops;

import java.util.Scanner;

// Repetition structures in Java are called loops, and they allow
// a block of code to be repeated multiple times.
//
// While Loop
// a loop that
// - Condition Controlled   -> continues running as long as the specified condition is true.
// - Pre-test               -> condition is tested `before` entering the loop
// - Execution              -> use when `loop may or may not need to be executed`
//
// problem:
// Each store employee makes $15 an hour. Write a program that allows the
// employee to enter the number of hours worked for the week. Do not allow
// overtime.
public class GrossPayInputValidation {
    public static void main(String[] args) {
        double rate = 15;
        double maxHours = 40;

        System.out.println("How many hours did you work?");
        Scanner scanner = new Scanner(System.in);
        double hoursWorked = scanner.nextDouble();

        // if `hoursWorked` is not valid (between 0 and 40),
        //      I want prompt you again until it's valid
        //
        // if valid, run the rest of the code
        while (hoursWorked > maxHours || hoursWorked < 0) {
            System.out.println("Invalid entry. Your hours must be between 0 and 40. Try again.");
            hoursWorked = scanner.nextDouble();
        }

        scanner.close();

        double grossPay = hoursWorked * rate;

        System.out.println("Gross pay: " + grossPay);
    }
}
