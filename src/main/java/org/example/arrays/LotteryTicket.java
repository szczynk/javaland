package org.example.arrays;

import java.util.Arrays;
import java.util.Random;

// Array
//
// Arrays can hold multiple values of the same data type.
//
// syntax for declaring an array:
//      `data_type[] array_name = new data_type[number_of_elements];`
//
// can be initialized with values directly:
//      `data_type[] array_name = {value1, value2, value3, ...};`
//
// Array indices start at 0.
// The first element of an array is accessed using index 0, the second with index 1, and so on.
//
// Once an array is defined, its length (number of elements) cannot be changed.
//
// Tips: type "/**" and enter above a method signature will create Javadoc stubs for you.
//
//
// problem:
// Create a Lottery Quick Pick application that will generate a lottery ticket
// with 6 random numbers between 1-69.
public class LotteryTicket {

    // `private`, `static`, and `final` is used to create `constant` variables.
    public static final int LENGTH = 6;
    public static final int MAX_TICKET_NUMBER = 69;

    public static void main(String[] args) {
        int[] ticket = generateNumbers();
        printTicket(ticket);
    }

    /**
     * Prints the lottery ticket.
     *
     * @param array The lottery ticket.
     */
    private static void printTicket(int[] array) {
        // We can use the sort()` method in the `Arrays` class without
        // instantiating the `Arrays` class because they are declared as static.
        // A static method belongs to the class itself rather than an instance of the class.
        // Therefore, you can directly access and use static methods using the class name,
        // without needing to create an object.
        Arrays.sort(array);

        for (int number : array) {
            System.out.print(number + " | ");
        }

        // Using array.length allows you to determine the number of elements in an array.
        //
        // or we can use this
        // for (int i = 0; i < array.length; i++) {
        //     System.out.print(array[i] + " | ");
        // }
    }

    /**
     * Generates a lottery ticket with 6 random numbers between 1-69.
     *
     * @return The lottery ticket.
     */
    private static int[] generateNumbers() {
        // Create a new array to store the lottery numbers.
        int[] ticket = new int[LENGTH];

        // Create a random number generator.
        Random random = new Random();

        // Loop through the array and generate a random number for each index.
        for (int i = 0; i < LENGTH; i++) {
            // using do while
            int randomNumber;

            do {
                // The method used is nextInt(int bound), which generates
                // a random integer between 0 (inclusive) and the specified bound (exclusive).
                // Since you want the random number to be between 1 and MAX_TICKET_NUMBER (both inclusive),
                // you add 1 to the result to shift the range.
                //
                // For example, if MAX_TICKET_NUMBER is 69,
                // random.nextInt(MAX_TICKET_NUMBER) can return a value between 0 and 68 (inclusive),
                // and by adding 1, the final result will be between 1 and 69 (inclusive).
                //
                // Generate a new random number.
                randomNumber = random.nextInt(MAX_TICKET_NUMBER) + 1;

                // if the random number has already been generated.
                // generate a new number
            } while (search(ticket, randomNumber));

            // using while
            // int randomNumber = random.nextInt(MAX_TICKET_NUMBER) + 1;
            //
            // while (search(ticket, randomNumber)) {
            //     randomNumber = random.nextInt(MAX_TICKET_NUMBER) + 1;
            // }

            // Store the random number in the array.
            ticket[i] = randomNumber;
        }

        return ticket;
    }

    /**
     * Searches the array for the specified number to avoid duplicates.
     *
     * @param array             The array to search.
     * @param numberToSearchFor The number to search for.
     * @return True if the number was found, false otherwise.
     */
    private static boolean search(int[] array, int numberToSearchFor) {
        // The enhanced for loop is introduced as a shorter way
        // to iterate over arrays or collections. But it needs the values
        // inside the array
        for (int value : array) {
            if (value == numberToSearchFor) {
                return true;
            }
        }
        return false;
    }
}
