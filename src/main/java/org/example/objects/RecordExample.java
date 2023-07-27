package org.example.objects;

// Records are a newer construct in Java used to create simple classes
// with fields and optional methods.
//
// They are similar to POJOs (Plain Old Java Objects) and used to model
// different types of objects.
//
// Getter methods for the fields are automatically generated in records,
// reducing the need for boilerplate code.
//
// Records can have additional methods, but they cannot modify the fields
// as they are declared as `final`.
//
// The use of records is efficient for cases where you only need
// to model data and don't require mutable objects,
// such as for deserializing JSON from API responses and
// representing data objects without complex behaviors.
//
// Defining a record named "Person"
record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {
        // Creating a new Person record object
        Person person = new Person("John", 30);

        // Accessing fields using record's automatically generated getter methods
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
    }
}
