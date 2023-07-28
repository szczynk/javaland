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
//
// Strings in Java are "immutable",
// meaning they cannot be modified directly.
public class TextProcessor {
    public static void main(String[] args) {
        countWords("I love Java");
        reverseString("Hello World");
        addSpaces("Hello!It'sMeSzczynk");
    }

    // problems:
    // Write a method that adds spaces to a jumbled String where all words
    // were written together with no spaces. Each new word begins with a
    // capital letter.
    private static void addSpaces(String text) {
        // StringBuilder
        //
        // Used to create a mutable `String` that can be modified
        //
        // allows for inserting, deleting, and modifying characters in a string.
        StringBuilder modifiedText = new StringBuilder(text);

        for (int i = 0; i < modifiedText.length(); i++) {
            // If not the first character and the character is uppercase
            if (i != 0 && Character.isUpperCase(modifiedText.charAt(i))) {
                // insert a space before uppercase character
                // using the `insert()` method
                modifiedText.insert(i, " ");
                i++;
            }
        }

        System.out.println(modifiedText);
    }

    // problem:
    // Write a method that prints a given String backwards.
    // For example, if given “pots”, it prints “stop”.
    private static void reverseString(String text) {
        // The `length()` method can be used to find
        // the number of characters in the string.
        //
        // a for loop to loop through the characters of the string in reverse order.
        // Start at the end of the string and decrement the index.
        //
        // The last index of a string is equal to
        // its length minus one (length() - 1).
        for (int i = text.length() - 1; i >= 0; i--) {

            // The `charAt()` method can be used to access
            // individual characters in the string by their index.
            System.out.print(text.charAt(i));
        }
        System.out.println();
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
