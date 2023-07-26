package org.example.loops;

import java.util.Scanner;

// For Loops
// a loop that
// - Count Controlled   -> runs a specified number of times.
// - Pre-test           -> condition is tested `before` entering the loop.
// - Execution          -> use when `you know how many times the loop should be executed`
//
// problem:
// Write a cashier program that will scan a given number of items and tally
// the cost.
public class Cashier {
    public static void main(String[] args) {
        System.out.println("Enter the number of items you would like to scan");
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();

        // "total" is declared outside the loop to accumulate
        // the costs of the scanned items.
        double total = 0;

        for (int i = 0; i < quantity; i++) {
            System.out.println("Enter the cost of the item");
            double price = scanner.nextDouble();

            total = total + price;
        }

        scanner.close();
        System.out.println("Your total is " + total);
    }
}
