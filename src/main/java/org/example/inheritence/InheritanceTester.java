package org.example.inheritence;

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
    }
}
