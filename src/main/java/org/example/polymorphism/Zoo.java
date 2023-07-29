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
// Demonstrate an example of polymorphism between an Animal, Dog, and Cat
public class Zoo {
    public static void main(String[] args) {
        System.out.println("-rocky fetch and make sound-");

        Dog rocky = new Dog();
        rocky.fetch();
        rocky.makeSound();

        System.out.println("----------------------------");
        System.out.println("-sasha make sound as a dog-");

        Animal sasha = new Dog(); // Up-casting
        sasha.makeSound();

        System.out.println("----------------------------");
        System.out.println("-sasha make sound as a cat-");

        sasha = new Cat();
        sasha.makeSound();

        // Type Casting.
        //
        // the action of converting an object’s type into a different type.
        //
        // It can be implicit or explicit and can be performed
        // upward or downward on the inheritance tree.
        //
        // Up-casting:
        // - converting an object of a subclass as an object of its superclass
        // - is an implicit type casting and does not require any special syntax.
        //
        // Down-casting:
        // - converting an object of a superclass as an object of its subclass
        // - is an explicit type cast and can be potentially unsafe
        //   if the object being referred to is not an instance of the target subclass.
        //
        // Care should be taken when using type casting as:
        // - should only be used when absolutely necessary,
        //   and alternatives should be considered to avoid potential issues.
        // - it can throw `ClassCastException` at runtime if the casting is not valid.
        //   e.g. you can not do this:
        //
        //   ```java
        //      Animal sasha = new Cat();
        //      Dog sashaTheDog = (Dog) sasha;
        //   ```
        //
        //
        // problem:
        // Downcast sasha to enable her to scratch her itch.
        ((Cat) sasha).scratch(); // `(Cat) sasha` is Down-casting
    }
}
