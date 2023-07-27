package org.example.objects;

// Wrapper classes.
//
// Wrapper classes, which are objects representing primitive data types
// (e.g., Integer for int, Double for double).
//
// | Primitive Data Type | Wrapper Class |
// | ------------------- | ------------- |
// | int                 | Integer       |
// | double              | Double        |
// | long                | Long          |
// | float               | Float         |
// | boolean             | Boolean       |
// | char                | Char          |
// | byte                | Byte          |
//
// Wrapper classes allow the use of methods and provide more flexibility
// than primitive data types.
//
// String is an object, but not a wrapper class, as it represents
// textual data and not a primitive data type.
public class WrapperExample {
    public static void main(String[] args) {
        // Using wrapper classes for primitive data types
        Integer num1 = 10; // Autoboxing (converting int to Integer)
        Double num2 = 3.14; // Autoboxing (converting double to Double)

        // Unboxing (converting Integer to int)
        int intNum = num1;

        // Using wrapper class methods
        System.out.println("intNum: " + intNum);
        System.out.println("Sum: " + (num1 + num2.intValue()));
        System.out.println("Is num1 greater than num2? " + num1.compareTo(num2.intValue()));
    }
}

