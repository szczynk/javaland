package org.example.data_structures;

import java.util.HashSet;
import java.util.Set;

// Data Structures
//
// stores and organizes a collection of objects and perform operations on them.
//
// Java's collections framework as Java's data structures and algorithms
//
// Java's collections framework provides interfaces, classes, and methods for working with
//
// Four common collections in Java are set, list, queue, and map.
public class CollectionDemos {
    public static void main(String[] args) {
        setDemo();
    }

    // Set
    //
    // is an unordered collection of unique objects, and duplicate elements are not allowed.
    //
    // are mutable, meaning you can add and remove elements.
    //
    // are suitable when the order of elements doesn't matter, and uniqueness is essential.
    //
    // To create a set, you can use classes like `HashSet` from the `java.util package`.
    //
    // problem:
    // Create a Set of fruit
    private static void setDemo() {
        Set fruits = new HashSet();

        fruits.add("apple");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("apple");

        System.out.println(fruits);

        fruits.remove("lemon");
        System.out.println("contains lemon? " + fruits.contains("lemon"));

        System.out.println("size: " + fruits.size());

        // `Set.of()` method can be used to initialize a set
        // with predefined elements, but the resulting set will be immutable.
        //
        // Immutable sets cannot be modified, and attempts to modify them will result in
        // an `UnsupportedOperationException`.
        Set moreFruits = Set.of("pear", "raisin", "cherry");
        // moreFruits.add("cranberry"); //can't do this because Set.of makes immutable collection
        System.out.println(moreFruits);
    }
}
