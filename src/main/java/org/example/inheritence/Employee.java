package org.example.inheritence;

public class Employee extends Person {
    private String employeeId;
    private String title;

    public Employee() {
        // To call a superclass constructor explicitly,
        // use "super()" followed by the appropriate arguments.
        //
        // The "super()" call must be the first statement in the subclass constructor.
        //
        // if the superclass doesn't have a default constructor,
        // A subclass must explicitly call a superclass constructor
        super("szczynk");

        System.out.println("In Employee default constructor");
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
