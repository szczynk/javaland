package org.example.interfaces;

// Interfaces
//
// a stateless construct with `abstract` behaviors
// which mean, similar to `abstract` classes but are purely `abstract` and do not have any state.
//
// They are used as templates for abstract concepts and are not instantiated directly.
//
// if we have an interface, we can't create objects using only that interface.
// we need to have a concrete implementing class or an abstract class that *implements*
// the interface. Then, you can create objects using the concrete implementing class
// or subclasses of the abstract class based on an interface's type.
//
// Interfaces do not have constructors or mutable fields.
//
// Implementing an interface is done using the "implements" keyword, not "extends."
// and the implementing class *must provide* concrete implementations for
// *all the interface's abstract methods*
// (except for `default` and `static` methods introduced in Java 8).
//
// `Default` methods provide a default implementation,
// which can be overridden by implementing classes
// but are not inherited.
//
// `Static` methods in interfaces are not inherited by implementing classes,
// contain implementation or body, and
// can be accessed using the interface name directly.
//
// Interface methods are abstract by default and do not require the "abstract" keyword.
//
// Fields in an interface are implicitly public, static, and final,
// and should only be used for constant values.
//
// Interfaces can be extended *only* by other interfaces.
//
// Note:
// - An interface in Java defines a contract that classes must adhere to.
//
//
// problem:
// - Create a Product interface.
// - Create a Book class that implements Product.
public class Book implements Product {
    private String name;
    private String author;
    private int page;
    private String isbn;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
