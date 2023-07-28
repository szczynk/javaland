package org.example.inheritence;

// Inheritance
//
// one class becomes an extension of another class, therefore
// inheriting the members of that class
//
// in other word, when a subclass inherits the members of a superclass.
//
// A superclass is also called a parent class or base class,
// while a subclass is called a child class or derived class.
//
// Inheritance represents an "is-a" relationship,
// where a subclass is a specialized type of the superclass.
// e.g. an `Employee` is a `Person`
//
// In Java, inheritance is created using the "extends" keyword.
//
// The subclass has access to all non-private members
// (attributes and methods) of the superclass.
//
// Superclass constructors run first or
// Constructors in the superclass are executed before constructors in the subclass.
//
// To call a superclass constructor explicitly,
// use "super()" followed by the appropriate arguments.
//
// The "super()" call must be the first statement in the subclass constructor.
//
// if the superclass doesn't have a default constructor,
// A subclass must explicitly call a superclass constructor
//
// problem:
// Create a `Person` class, then create an `Employee` class that inherits from
// `Person`.
public class Person {
    private String name;
    private int age;
    private String gender;

    public Person() {
        System.out.println("In Person default constructor");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("In Person 2nd constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
