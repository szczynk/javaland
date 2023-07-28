package org.example.inheritence;

// Sealed Classes.
//
// classes that restrict inheritance to specific classes.
//
// Sealed classes are declared using the "sealed" keyword
// followed by the "permits" keyword and a list of permitted subclasses.
//
// Subclasses of sealed classes are required to declare themselves
// as `sealed`, `non-sealed`, or `final`.
//
// Non-sealed classes are open to be extended by any other class and
// do not require subclasses to declare themselves further.
//
// Final classes cannot have any subclasses and
// mark the final stop in the inheritance chain.
//
// The final keyword can also be used on methods or fields
// to prevent overriding or changing them.
//
// e.g.
//
//       ┌───────────┐
//       │   Shape   │
//       └─┬───────┬─┘
//         │       │
//         ▼       ▼
// ┌─────────┐   ┌──────┐
// │Rectangle│   │Circle│
// └────┬────┘   └──────┘
//      │
//      ▼
//  ┌──────┐
//  │Square│
//  └──────┘
//
// public sealed class Shape permits Rectangle, Circle {}
// public sealed class Rectangle extends Shape permits Square {}
// public non-sealed class Circle extends Shape {}
// public final class Square extends Rectangle {}
//
// in this example we have:
// - Shape is a sealed class that allows only Rectangle and Circle to inherit from it.
// - Rectangle is a sealed class that allows only Square to inherit from it.
// - Circle is a non-sealed class, allowing unrestricted inheritance from other classes.
// - Square is a final class that cannot be subclassed further.
public class Sealed {
}
