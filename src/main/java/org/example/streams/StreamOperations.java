package org.example.streams;

import java.util.List;

// Streams
//
// represent a sequence of elements from a data source
//
// do not store elements like collections;
// instead, they allow operations on the data without affecting the original data source.
//
// built-in methods and classes for performing operations.
// To create a stream from an array, use the `Arrays.stream()` method.
// The forEach method can be used to perform an operation on each element in the stream.
// e.g.
// ```java
// int[] numbers = {0, 2, 4, 6, 8, 10};
// Arrays.stream(numbers)
//     .forEach(n-> System.out.print(n + 1 + " ")); //1 3 5 7 9 11
// ```
//
// Stream operations can be processed in parallel using multiple threads.
// Parallel processing may not preserve the order of elements.
// e.g.
// ```java
// int[] numbers = {0, 2, 4, 6, 8, 10};
// Arrays.stream(numbers).parallel()
//     .forEach(n-> System.out.print(n + 1 + " ")); //7 11 9 3 1 5
// ```
//
// Streams offer 2 operations:
// - intermediate   : perform operation and return resulting stream for further processing
// - terminal       : return a result, close the stream,
//                    and are the final operations on the stream.
public class StreamOperations {
    static List<String> veggies = List.of(
            "spinach",
            "cabbage",
            "peas",
            "green beans",
            "brussels sprouts",
            "carrots"
    );

    public static void main(String[] args) {
        // Examples of intermediate operations
        // include "anyMatch", "allMatch", and "filter".
        anyMatchDemo();
        System.out.println();

        allMatchDemo();
        System.out.println();

        filterDemo();
        System.out.println();
    }

    // "Filter" is an intermediate operation that
    // narrows down the elements in the stream based on a given condition.
    private static void filterDemo() {
        veggies.stream()                        // cabbage
                .filter(v -> v.startsWith("c")) // carrots
                .forEach(System.out::println);  // -> Terminal operations
    }

    // The "allMatch" operation determines
    // if all elements in the stream match a certain condition.
    private static void allMatchDemo() {
        boolean allMatches = veggies.stream().allMatch(v -> v.contains("s"));
        System.out.println("allMatches: " + allMatches); // false
    }

    // The "anyMatch" operation checks
    // if any element in the stream matches a given condition.
    private static void anyMatchDemo() {
        boolean anyMatches = veggies.stream().anyMatch(v -> v.contains(" "));
        System.out.println("anyMatches: " + anyMatches); // true
    }

}
