package org.example.polymorphism;

// Polymorphism
//
// ability to take multiple forms
//
// Polymorphism is one of the core principles of object-oriented programming.
//
// allowing a subclass to have its own unique behaviors and
// inherit some behaviors from its superclass.
//
// In OOP, an object can have a superclass type but be an instance of a subclass.
//
// Overriding a method in a subclass allows it to execute the method
// defined in the subclass rather than the superclass.
//
// Polymorphism is a powerful tool in Java,
// as it allows for dynamic behavior changes at runtime.
//
// The key point to remember is that
// an object can have a superclass type,
// but its actual behavior might be based on the subclass it belongs to.
//
// e.g.
//       ┌───────────┐
//       │   Animal  │
//       └─┬───────┬─┘
//         │       │
//         ▼       ▼
//     ┌─────┐   ┌─────┐
//     │ Dog │   │ Cat │
//     └─────┘   └─────┘
//
// we can write as this:
// Animal dog = new Dog();
// Animal cat = new Cat();
//
// problem:
// Transforming Animals.
// Demonstrate an example of polymorphism between
// an Animal, Dog, and Cat
public class Zoo {
    public static void main(String[] args) {
        System.out.println("-rocky fetch and make sound-");

        Dog rocky = new Dog();
        rocky.fetch();
        rocky.makeSound();

        System.out.println("----------------------------");
        System.out.println("-sasha make sound as a dog-");

        Animal sasha = new Dog();
        sasha.makeSound();

        System.out.println("----------------------------");
        System.out.println("-sasha make sound as a cat-");

        sasha = new Cat();
        sasha.makeSound();


    }
}
