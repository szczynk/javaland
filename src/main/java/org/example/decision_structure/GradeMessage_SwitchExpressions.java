package org.example.decision_structure;

import java.util.Scanner;

// Switch Expressions
// Similar to switch statements but allow you to directly assign a value
// when a case is matched.
//
// problem:
// Have a user enter their letter grade, and using a `switch expression`, print
// out a message letting them know how they did.
public class GradeMessage_SwitchExpressions {
    public static void main(String[] args) {
        System.out.println("Enter your test score");
        Scanner scanner = new Scanner(System.in);
        String grade = scanner.next();
        scanner.close();

        String message = switch (grade) {
            // Unlike switch statements, switch expressions do not require "break"
            // statements because there is no fall-through behavior.
            case "A" -> "Excellent!";
            case "B" -> "Great!";

            // If there are multiple statements to be executed in a case, use curly braces {}
            case "C" -> {
                // you can do what you want on this
                System.out.println("print");

                // and end with a "yield" statement to assign the value to the variable.
                yield "Good job!"; // last line must yield
            }

            // When using multiple cases with the same code to execute,
            // separate them with commas in the switch expression.
            case "D", "F" -> "Uh oh";

            // The switch expression should cover all possible cases,
            // and a "default" case is necessary to handle any unmatched conditions.
            // otherwise it runtime error.
            default -> "Error: Invalid grade";
        };

        System.out.println(message);
    }
}
