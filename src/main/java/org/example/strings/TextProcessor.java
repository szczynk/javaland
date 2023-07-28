package org.example.strings;

// Strings.
//
// Strings are objects representing a sequence of characters.
//
// Not primitive data types or wrapper classes.
//
// but offers helpful convenience methods for manipulating strings
// similar  to wrapper classes.
//
// Some methods in the String class are static,
// while others are non-static (part of the object).
public class TextProcessor {
    public static void main(String[] args) {
        countWords("I love Java");
    }

    // problem:
    // Write a method that counts the number of words in a String and
    // prints them individually on new lines
    private static void countWords(String text) {
        // The `split()` method can be used to split a string into an array
        // based on a specified delimiter (e.g., spaces).
        //
        // The `split()` method is called on a `specific string object`,
        var words = text.split(" ");

        // The `length` property of arrays can be used to determine
        // the number of elements in an array.
        int numberOfWords = words.length;

        // The `format()` method allows for string formatting with
        // placeholders (%d, %s, etc.) to be replaced by provided values.
        //
        // the `format()` method is a `static` method, not tied to any specific
        // instance of a string.
        String message = String.format("Your text contains %d words", numberOfWords);
        System.out.println(message);

        for (String word : words) {
            System.out.println(word);
        }
    }
}
