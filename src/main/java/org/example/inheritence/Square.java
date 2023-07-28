package org.example.inheritence;

import org.example.objects.Rectangle;

// Overriding Inherited Methods.
//
// subclasses can override the behavior of a method it inherited.
//
// Method Overriding: It refers to the process of providing a new implementation
// for an inherited method in a subclass. The new implementation should have the
// *same method signature as the one inherited*.
//
// When a field or method is declared as "protected" in the superclass,
// it can be inherited and accessed by its subclasses.
//
// When inheritance is limited
// (e.g., the superclass is from an external library and cannot be modified),
// the subclass can use getter and setter methods to interact with
// the superclass' private fields.
//
// Access Modifier:
// - "public" can be accessed from anywhere, both within the class and from any other class,
//   regardless of the package or subclass relationship. They have the widest scope of
//   accessibility.
// - "protected" are accessible from within the same class, from any subclass
//   (even if it is in a different package), and from any class in the same package
//   as the defining class. However, they are not accessible from classes that are
//   outside the package and are not subclasses of the defining class.
// - "private" can only be accessed from within the same class where they are defined.
//   They are not accessible from any other class, including subclasses or classes in
//   the same package.
//
// Limited Access in Inheritance
//
// - Private fields and constructors are not inherited.
// - Members with public and protected access modifiers are inherited,
//   but members with private access modifiers are not.
// - Final methods and final fields are inherited but cannot be overridden in the subclass.
// - Access modifiers (public, protected, private) affect the accessibility of inherited members.
// - When overriding a method in the subclass, the access modifier must be
//   the same or less strict than the superclass' method. It cannot be more strict.
//
//
// problem:
// Create a Square class that inherits from Rectangle, and override its
// `calculatePerimeter()` method
public class Square extends Rectangle {

    // The "@override" annotation is used to indicate that a method in the subclass
    // is intended to override a method in the superclass. It is not mandatory but
    // helps catch potential mistakes if the overridden method's signature is incorrect.
    @Override
    public double calculatePerimeter(){
        return sides * length;
    }

    // Overload Inherited Method.
    //
    // subclasses can overload methods that are inherited from a superclass.
    //
    // Overloading:
    // methods with the same name as those in the superclass,
    // but they must have different parameter lists.
    //
    // Overriding vs. Overloading:
    // Overriding occurs when a subclass provides a new implementation (body)
    // for a method inherited from the superclass,
    // while overloading involves adding methods with the same name but
    // different parameter lists
    // in the same class or between a parent and subclass.
    //
    // Constructors should be accessible to subclasses,
    // so they are typically made public or protected
    // to allow inheritance and method overloading in subclasses.
    //
    // overloading a method in a subclass *increases* its scope,
    // allowing it to be called on objects of both the subclass and its parent class,
    // providing more versatility in using the method.
    //
    // problem:
    // Create a `print()` method in superclass then overload it in subclass
    public void print(String what) {
        System.out.println("I am a " + what);
    }
}
