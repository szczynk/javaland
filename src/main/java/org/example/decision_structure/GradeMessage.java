package org.example.decision_structure;

import java.util.Scanner;

// Switch Statements
// - solves problem in the same way that if-else-if does
// - good for when there’s more than 2 possible paths
// - each path checks for equality
//
// problem:
// Have a user enter their letter grade, and using a switch statement, print
// out a message letting them know how they did.
public class GradeMessage {
    public static void main(String[] args) {
        System.out.println("Enter your test score");
        Scanner scanner = new Scanner(System.in);
        String grade = scanner.next();
        scanner.close();

        String message;

        // the switch checks for equality on a condition.
        switch (grade) {
            case "A":
                message = "Excellent!";
                break;

            case "B":
                message = "Great!";
                break;

            case "C":
                message = "Good!";
                break;

            case "D":
                message = "Need to work a bit harder";
                break;

            case "F":
                message = "Uh oh!";
                break;

            // if you did not have the default case, there's a possibility that none
            // of these cases matched grade and nothing happens.
            //
            // if you didn't want the `default` you could just initialize `message`
            // to a blank string or whatever you wanted to such as ` String message = "";`
            // so the compile error `Variable 'message' might not have been initialized`
            // goes away.
            default:
                message = "Error: Invalid grade";
                break;
        }

        System.out.println(message);
    }
}
