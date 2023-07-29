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
        feed(rocky);

        System.out.println("----------------------------");
        System.out.println("-sasha make sound as a dog-");

        Animal sasha = new Dog(); // Up-casting
        sasha.makeSound();
        feed(sasha);

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
        // If you want to store the type-casted object permanently,
        // you need to do so explicitly.
        //
        // Changes made to a stored type-casted object do not affect
        // the original object or vice versa.
        //
        // Care should be taken when using type casting as:
        // - should only be used when absolutely necessary,
        //   and alternatives should be considered to avoid potential issues.
        // - it can throw `ClassCastException` exception at runtime if the casting is not valid.
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
        ((Cat) sasha).scratch(); // `(Cat) sasha` is temporary Down-casting

        // Cat sashaTheCat = (Cat) sasha; Explicitly storing the type-casted object

        feed(sasha);
    }

    // instanceof Operator
    //
    // allows you to check if an object is an instance of a specific class
    // and return it as boolean
    //
    // we can use the `instanceof` operator to check before performing the down-casting
    // to ensure safe down-casting and avoid the `ClassCastException` exception,
    //
    // The `instanceof` operator can be used in logical conditions
    // to perform different actions based on the type of the object.
    //
    // Storing a reference to a type-casted object does not create a new object;
    // it's only a temporary casting for access purposes.
    //
    // The use of "var" to declare variables with type-casting is possible
    // but should be used with caution as it can lead to potential issues.
    //
    //
    // problem:
    // Create a method that feeds any animal the type of food it eats.
    private static void feed(Animal animal) {
        if (animal instanceof Dog) {
            System.out.println("here's your dog food");
        } else if (animal instanceof Cat) {
            System.out.println("here's your cat food");
        }

        // instanceof Pattern Matching
        //
        // introduced in Java 16 to simplify the common usage of
        // the instanceof operator along with type casting.
        //
        // allows you to perform both the type-checking and type-casting
        // in a more concise and readable way.
        //
        // e.g.
        // if(animal instanceof Dog sashaTheDog) {
        //     sashaTheDog.fetch();
        //     System.out.print(" - from `feed()` method\n");
        // }
        // //same as:
        // if(animal instanceof Dog){
        //     Dog sashaTheDog = (Dog)animal;
        //     sashaTheDog.fetch();
        //     System.out.print(" - from `feed()` method\n");
        // }
    }
}
