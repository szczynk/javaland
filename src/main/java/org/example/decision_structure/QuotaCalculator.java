package org.example.decision_structure;

import java.util.Scanner;

// If else statement.
// If a certain situation occurs, <do something>
// Otherwise <do something else>.
//
// problem:
// All salespeople are expected to make at least 10 sales each week.
// For those who do, they receive a congratulatory message. For those
// who don’t, they are informed of how many sales they were short.
public class QuotaCalculator {
    public static void main(String[] args) {
        int quota = 10;

        System.out.println("How many sales did you made?");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();
        scanner.close();

        if (sales >= quota) {
            System.out.println("Congrats! you've meet your quota");
        } else {
            int salesShort = quota - sales;
            System.out.println("you didn't make your quota. you were " + salesShort + " sales short");
        }
    }
}
