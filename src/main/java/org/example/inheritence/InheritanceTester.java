package org.example.inheritence;

import org.example.objects.Rectangle;

public class InheritanceTester {
    public static void main(String[] args) {
        // The subclass has access to all non-private members
        // (attributes and methods) of the superclass.
        // e.g.
        Person person = new Person();
        System.out.println("person.getName(): " + person.getName());

        Employee employee = new Employee();
        System.out.println("employee.getName(): " + employee.getName());
        System.out.println("employee.getTitle(): " + employee.getTitle());

        // To verify if an overridden method is correctly executed in the subclass,
        // create an object of the subclass, set necessary fields, and call the overridden method.
        // The method from the subclass should be executed instead of the superclass' method.
        Square square = new Square();
        square.setLength(25);
        System.out.println(square.calculatePerimeter());

        Rectangle rectangle = new Rectangle();
        rectangle.print();

        square.print("square");
    }
}
