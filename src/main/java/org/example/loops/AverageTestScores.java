package org.example.loops;

import java.util.Scanner;

// problem:
// Nested Loops
// Find the average test scores for each student in the class.
// - 1st loop, go through every student in the class
// - 2nd loop, go through every test grade that student has
public class AverageTestScores {
    public static void main(String[] args) {
        // init what we know
        int numOfStudents = 4;
        int numOfTests = 3;

        Scanner scanner = new Scanner(System.in);

        // process all the students
        for (int i = 0; i < numOfStudents; i++) {
            double total = 0;

            // process all the student's test
            for (int j = 0; j < numOfTests; j++) {
                System.out.println("Score for test #" + (j + 1));

                double score = scanner.nextDouble();
                total = total + score;
            }

            double average = total / numOfTests;
            System.out.println("The test average for student #" + (i + 1) + " is " + average);
        }

        scanner.close();
    }

}
