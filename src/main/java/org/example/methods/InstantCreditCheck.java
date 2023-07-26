package org.example.methods;

import java.util.Scanner;

// problem:
// Write a program that approves anyone who makes more than
// $25,000 and has a credit score of 700 or better. Reject all others.
public class InstantCreditCheck {

    // Global variables: Variables defined at the class level
    // can be accessed by all methods within that class.
    //
    // anything else is local
    static double requiredSalary = 25000;
    static int requiredCreditScore = 700;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double salary = getSalary();
        int creditScore = getCreditScore();
        scanner.close();

        boolean qualified = isUserQualified(salary, creditScore);

        notifyUser(qualified);
    }

    public static void notifyUser(boolean qualified) {
        if (qualified) {
            System.out.println("Congrats, you've been approved");
        } else {
            System.out.println("Sorry, you've been declined");
        }
    }

    public static boolean isUserQualified(double salary, int creditScore) {
        if (salary >= requiredSalary && creditScore >= requiredCreditScore) {
            return true;
        } else {
            return false;
        }
    }

    public static int getCreditScore() {
        System.out.println("Enter your credit score");
        int creditScore = scanner.nextInt();
        return creditScore;
    }

    public static double getSalary() {
        System.out.println("Enter your salary");
        double salary = scanner.nextDouble();
        return salary;
    }
}
