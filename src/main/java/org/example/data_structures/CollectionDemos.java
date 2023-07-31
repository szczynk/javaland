package org.example.data_structures;

import java.util.*;

// Data Structures
//
// stores and organizes a collection of objects and perform operations on them.
//
// Java's collections framework as Java's data structures and algorithms
//
// Java's collections framework provides interfaces, classes, and methods for working with
//
// Four common collections in Java are set, list, queue, and map.
//
// ==============================
//
// Iterators
//
// is an object used to loop through collections
//
// are used to traverse elements in a collection and
// help in accessing elements sequentially in a collection.
//
// can be used with sets, lists, and queues directly.
//
// For maps, the entrySet method is used to get a set of key-value pairs.
//
// The iterator can be used with the set of entries obtained from the map
// to loop through its elements.
//
// While using iterators with maps may be effective,
// there are more efficient ways to work with maps.
//
// ==============================
//
// Iterating with Enhanced For Loop
//
// Enhanced for loop can be used to loop through collections in Java,
// providing a simplified and more readable syntax.
//
// To use the enhanced for loop, the data type of the collection should be *specified*
// in angle brackets (e.g., List<String> for a list of strings).
//
// The enhanced for loop works for various types of collections,
// including lists, sets, and queues.
//
// For maps, `entrySet()` provides a set of key-value pairs (`Map.Entry`)
// that can be accessed during iteration.
//
// For maps, the enhanced for loop uses `Map.Entry` as the data type
// and iterates through `mapName.entrySet()`.
//
// Collections can only hold *objects*, not primitive data types,
// so *wrapper classes like `Integer` should be used*
// to store primitive values in collections.
//
// If a specific data type is not specified for a collection (i.e., using raw types),
// the compiler may issue warnings about using a generic object (`Object` type) and
// suggest adding type specifications.
//
// ==============================
//
// Iterating with forEach
//
// built-in convenience or efficient method to iterate over collections
//
// It is available for every collection type, including lists and maps.
//
// The syntax for using forEach with a list is `list.forEach(element -> { /* action */ });`
// For maps, the syntax is `map.forEach((key, value) -> { /* action */ });`.
//
// Lambda expressions are used inside the `forEach` method
// to specify the action to be performed
// on each element or key-value pair.
//
// Lambda expressions in this context are similar to anonymous functions
// and allow for functional programming capabilities.
//
// *Method references* are another syntactic shortcut for using `forEach`.
// They are used when the lambda expression contains only a single method call,
// providing a cleaner way to write the code.
//
// When using *method references*, the syntax is `ClassName::methodName`.
//
// *Method references* work for both static and non-static methods.
//
// The forEach method is a preferred approach for iterating over collections
// compared to traditional methods like iterators or enhanced for loops
// due to its simplicity and readability.
public class CollectionDemos {
    public static void main(String[] args) {
        setDemo();
        System.out.println();

        listDemo();
        System.out.println();

        queueDemo();
        System.out.println();

        mapDemo();
        System.out.println();
    }

    // Map
    // unordered unique key-value pairs
    //
    // do not inherit from the Collection interface
    // but are still considered part of Java's collections framework.
    //
    // take objects as keys and values. Keys must be unique, and values can be repeated.
    //
    //
    // problem:
    // Create a Map of fruit
    private static void mapDemo() {
        Map<String, Integer> fruitCalories = new HashMap();

        // To add elements to a map,
        // use the "put" method, specifying the key-value pair.
        //
        // if a key is already present in the map,
        // "put" method will replace an existing value
        fruitCalories.put("apple", 95);
        fruitCalories.put("lemon", 20);
        fruitCalories.put("banana", 105);
        fruitCalories.put("orange", 45);

        // To avoid accidentally overwriting values, use the "putIfAbsent" method,
        // which checks for the existence of the key before adding it.
        fruitCalories.putIfAbsent("lemon", 17);

        // To remove an entry from the map, use the "remove" method, providing the key.
        fruitCalories.remove("lemon");

        // Iterator in Map
        Set mapEntries = fruitCalories.entrySet();
        var i = mapEntries.iterator();

        while (i.hasNext()) {
            Map.Entry entry = (Map.Entry) i.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Iterating with Enhanced For Loop over Map
        //
        //
        // problem:
        // Use Enhanced For loop to iterate over Map
        for (Map.Entry calorieInfo : fruitCalories.entrySet()) {
            System.out.println(calorieInfo.getKey() + " : " + calorieInfo.getValue());
        }

        // Iterating with forEach
        //
        //
        // problem:
        // Use forEach to print elements of the fruit Map
        fruitCalories.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println(fruitCalories);

        // Retrieving a value from the map is done by using the "get" method, providing the key.
        System.out.println("banana calories: " + fruitCalories.get("banana"));

        // The "containsKey" method allows checking if a specific key exists in the map
        System.out.println("contain orange? " + fruitCalories.containsKey("orange"));

        // Immutable maps can be created using the "Map.of" method,
        // but they cannot be modified after creation.
        Map immutableFruitCalories = Map.of(
                "apple", 95,
                "lemon", 20
        );
    }

    // Queue.
    //
    // are ordered elements that are processed in the order
    // in which they are added
    //
    // follow the "first in, first out" (FIFO) processing
    //
    // can be implemented using a linked list data structure in Java.
    //
    // can contain duplicate elements.
    //
    //
    // problem:
    // Create a Queue of fruit
    private static void queueDemo() {
        Queue fruits = new LinkedList();

        // Elements can be added to the "end of the queue" using
        // the "add" method
        fruits.add("apple");
        fruits.add("lemon");
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("lemon");

        // The "remove" method removes the first element from the queue.
        // returns the `removed` object, while most other removes in queues return void.
        var removed = fruits.remove();
        System.out.println("removed: " + removed);

        // The "peek" method allows viewing the first element in the queue
        // without removing it.
        System.out.println("head of queue: " + fruits.peek());

        System.out.println(fruits);
    }

    // List
    //
    // are ordered elements accessible by position
    //
    // allow duplicates
    //
    // can be modified, and elements can be added or removed at specific positions
    // using methods like `add`, `remove`, and `set`.
    //
    // allow access to elements using their indexes. The index starts from 0.
    //
    // To create a list in Java, you can use the `ArrayList` class,
    // which implements the `List` interface from the `java.util package`.
    //
    //
    // problem:
    // Create a List of fruit
    private static void listDemo() {
        List<String> fruits = new ArrayList();

        fruits.add("apple");
        fruits.add("lemon");
        fruits.add("banana");
        fruits.add("orange");

        fruits.set(2, "grape");
        fruits.add("lemon");
        fruits.remove("lemon"); // remove first found
        fruits.remove(3);

        // Iterating with Enhanced For Loop over List
        //
        //
        // problem:
        // Use Enhanced For loop to iterate over List
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Iterating with forEach
        //
        //
        // problem:
        // Use forEach to print elements of the fruit list
        fruits.forEach(f -> System.out.println(f));
        fruits.forEach(System.out::println); // alternative - method reference

        // multiple statement
        fruits.forEach(f -> {
            int idx = fruits.indexOf(f);
            f = "fruit: " + f;

            System.out.println("index: " + idx + ", Fruits: " + f);
        });


        System.out.println(fruits);

        // The method fruits.get(index) allows accessing an element
        // at a specific index in the list.
        System.out.println("index 2: " + fruits.get(2));

        // The method fruits.indexOf(object) returns the index of the first
        // occurrence of the specified object in the list.
        System.out.println("index of grape: " + fruits.indexOf("grape"));

        // The method fruits.lastIndexOf(object) returns the index of the last
        // occurrence of the specified object in the list.
        System.out.println("last index of lemon: " + fruits.lastIndexOf("lemon"));

        // An ArrayList can be created using the List.of method,
        // creating an immutable list that cannot be modified.
        List moreFruits = List.of("cherry", "plum"); // immutable
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
    //
    // problem:
    // Create a Set of fruit
    private static void setDemo() {
        Set fruits = new HashSet();

        fruits.add("apple");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("apple");

        // Iterator in Set
        //
        //
        // problem:
        // Use an iterator to loop through the
        // Set of fruit
        var i = fruits.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

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
