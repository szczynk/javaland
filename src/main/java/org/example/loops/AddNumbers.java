package org.example.loops;

import java.util.Scanner;

// Do While Loops
// a loop that
// - Condition Controlled   -> continues running as long as the specified condition is true.
// - Post-test              -> condition is tested `after` entering the loop
// - Execution              -> use when `should run at least once, and possibly more`
//
// problem:
// Write a program that allows a user to enter two numbers, and then sums up
// the two numbers. The user should be able to repeat this action until they
// indicate they are done.
public class AddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean again;

        do {
            System.out.println("Enter the first number");
            double num1 = scanner.nextDouble();

            System.out.println("Enter the second number");
            double num2 = scanner.nextDouble();

            System.out.println("Sum: " + (num1 + num2));

            System.out.println("Would you like to run again? false for no, true for yes");
            again = scanner.nextBoolean();
        } while (again);

        // The instructor mentions that using the do-while loop is not common
        // in the industry, and many developers prefer using while loops instead.
        // However, the do-while loop is suitable when a loop should run at least
        // once before checking the condition.
    }
}
