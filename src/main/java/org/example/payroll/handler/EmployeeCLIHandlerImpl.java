package org.example.payroll.handler;

import org.example.payroll.model.Employee;
import org.example.payroll.service.EmployeeService;

import java.util.Scanner;

public class EmployeeCLIHandlerImpl implements EmployeeHandler {
    private final Scanner scanner;
    private final EmployeeService employeeService;

    public EmployeeCLIHandlerImpl(Scanner scanner, EmployeeService employeeService) {
        this.scanner = scanner;
        this.employeeService = employeeService;
    }

    @Override
    public void list() {
        var employees = employeeService.list();

        System.out.println("|--------|-----------------------|---------------|-------|---------------|");
        System.out.print("| \tID | Nama\t\t\t\t | Gender\t\t | Grade | Married\t\t |\n");
        System.out.println("|--------|-----------------------|---------------|-------|---------------|");

        for (Employee employee : employees) {
            System.out.printf("| %d\t | %s\t\t | %s\t | %d\t\t | %b\t\t\t |\n", employee.getId(), employee.getName(), employee.getGender(), employee.getGrade(), employee.getMarried());
        }

        System.out.println("|--------|-----------------------|---------------|-------|---------------|");
    }

    @Override
    public void add() {
        System.out.print("name = ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("invalid name");
            return;
        }


        System.out.print("gender (laki-laki (p) / perempuan (p)) = ");
        String gender = scanner.nextLine().toLowerCase();
        gender = switch (gender) {
            case "l", "laki-laki" -> "laki-laki";
            case "p", "perempuan" -> "perempuan";
            default -> "";
        };
        if (gender.isEmpty()) {
            System.out.println("invalid gender, laki-laki (p) / perempuan (p) only");
            return;
        }


        int grade;
        System.out.print("grade = ");
        try {
            grade = scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("invalid married");
            return;
        }
        if (grade < 1) {
            System.out.println("invalid grade");
            return;
        }


        boolean married;
        System.out.print("married (true / false) = ");
        try {
            married = scanner.nextBoolean();
        } catch (RuntimeException e) {
            System.out.println("invalid married, true / false only");
            return;
        }


        Employee employee = new Employee(name, gender, grade, married);

        int employeeId = employeeService.add(employee);

        if (employeeId < 1) {
            System.out.println("failed adding employee, check your input");
            return;
        }

        System.out.println("successfully adding employee with id " + employeeId);
    }

    public void detail() {
        int employeeId;
        System.out.print("employee id = ");
        try {
            employeeId = scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("invalid employee id");
            return;
        }


        try {
            Employee employee = employeeService.detail(employeeId);

            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.println("| Employee\t\t\t\t\t\t\t\t\t |");
            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.printf("| ID\t\t | %d\t\t | Nama\t | %s\t |\n", employee.getId(), employee.getName());
            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.printf("| Gender\t\t | %s\t\t | Grade\t | %s\t |\n", employee.getGender(), employee.getGrade());
            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.printf("| Married\t\t | %s\t\t | \t\t |\n", employee.getMarried());
            System.out.println("|--------------------------------------------------------------------------------|");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Employee with id " + employeeId + " not exist");
        }
    }
}
