package org.example.payroll.model;

public class Employee {
    private int id;
    private String name;
    private String gender;
    private int grade;
    private boolean married;

    public Employee(String name, String gender, int grade, boolean married) {
        setName(name);
        setGender(gender);
        setGrade(grade);
        setMarried(married);
    }

    public Employee(int id, String name, String gender, int grade, boolean married) {
        setId(id);
        setName(name);
        setGender(gender);
        setGrade(grade);
        setMarried(married);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean getMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}
