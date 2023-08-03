package org.example.payroll.handler;

import org.example.payroll.helper.Helper;
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
        Helper.clearTerminal();

        var employees = employeeService.list();

        System.out.println("|--------|-----------------------|---------------|-------|---------------|");
        System.out.print("| ID\t | Nama\t\t\t\t | Gender\t\t | Grade | Married\t\t |\n");
        System.out.println("|--------|-----------------------|---------------|-------|---------------|");

        for (Employee employee : employees) {
            System.out.printf("| %d\t | %s\t\t | %s\t | %d\t\t | %b\t\t\t |\n", employee.getId(), employee.getName(), employee.getGender(), employee.getGrade(), employee.getMarried());
        }

        System.out.println("|--------|-----------------------|---------------|-------|---------------|");
    }

    @Override
    public void add() {
        Helper.clearTerminal();

        System.out.print("name = ");
        String name = scanner.next();
        if (name.isEmpty()) {
            System.out.println("invalid name");
            return;
        }

        System.out.print("gender = ");
        String gender = scanner.next();
        gender = switch (gender) {
            case "l", "laki-laki" -> "laki-laki";
            case "p", "perempuan" -> "perempuan";
            default -> "";
        };
        if (gender.isEmpty()) {
            System.out.println("invalid gender, laki-laki or perempuan only");
            return;
        }

        System.out.print("grade = ");
        int grade = scanner.nextInt();
        if (grade <= 0) {
            System.out.println("invalid grade");
            return;
        }

        System.out.print("married = ");
        boolean married = scanner.nextBoolean();

        Employee employee = new Employee(name, gender, grade, married);

        int employeeId = employeeService.add(employee);
        System.out.println("successfully adding employee with id " + employeeId);
    }
}
