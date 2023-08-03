package org.example.payroll.handler;

import org.example.payroll.helper.Helper;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final EmployeeHandler employeeHandler;
    private final SalaryHandler salaryHandler;
    private final PayrollHandler payrollHandler;


    public Menu(Scanner scanner, EmployeeHandler employeeHandler, SalaryHandler salaryHandler, PayrollHandler payrollHandler) {
        this.scanner = scanner;
        this.employeeHandler = employeeHandler;
        this.salaryHandler = salaryHandler;
        this.payrollHandler = payrollHandler;
    }

    public void show() {
        Helper.clearTerminal();

        Helper.menuList();

        while (true) {
            String menu = scanner.next();

            if (menu.equals("7") || menu.equals("x")) {
                Helper.clearTerminal();
                scanner.close();
                break;
            }

            switch (menu) {
                case "1" -> {
                    System.out.println("Tambah employee");
                    employeeHandler.add();
                }
                case "2" -> {
                    System.out.println("Daftar employee");
                    employeeHandler.list();
                }
                case "3" -> {
                    System.out.println("Daftar salary");
                    salaryHandler.list();
                }
                case "4" -> {
                    System.out.println("Hitung payroll");
                    payrollHandler.add();
                }
                case "5" -> {
                    System.out.println("Daftar payroll");
                    payrollHandler.list();
                }
                case "6" -> {
                    System.out.println("Detail payroll");
                    payrollHandler.detail();
                }
                default -> {
                    Helper.clearTerminal();
                    Helper.menuList();
                }
            }
        }
    }

}
