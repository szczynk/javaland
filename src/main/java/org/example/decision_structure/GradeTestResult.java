package org.example.decision_structure;

import java.util.Scanner;

// If Else-if statement
// If situation A occurs, <do something>
// Else if situation B occurs, <do something else>
// Else if situation C occurs, <do something else>
//
// problem:
// Display a letter grade for a student based on their test score.
public class GradeTestResult {
    public static void main(String[] args) {
        System.out.println("Enter your test score");
        Scanner scanner = new Scanner(System.in);
        double score = scanner.nextDouble();
        scanner.close();

        // single characters are called char
        char grade;

        if (score < 60) {
            grade = 'F';
        } else if (score < 70) {
            grade = 'D';
        } else if (score < 80) {
            grade = 'C';
        } else if (score < 90) {
            grade = 'B';
        } else {
            grade = 'A';
        }

        System.out.println("Your grade: " + grade);
    }
}
