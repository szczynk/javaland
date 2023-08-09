package org.example.payroll;

import org.example.payroll.helper.PostgresDataSource;
import org.example.payroll.repository.*;
import org.example.payroll.service.*;
import org.example.payroll.handler.*;

import javax.sql.DataSource;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // EmployeeRepo employeeRepo = new EmployeeInMemoryRepoImpl();
        // SalaryRepo salaryRepo = new SalaryInMemoryRepoImpl();
        // PayrollRepo payrollRepo = new PayrollInMemoryRepoImpl();

        // EmployeeRepo employeeRepo = new EmployeeJSONRepoImpl();
        // SalaryRepo salaryRepo = new SalaryJSONRepoImpl();
        // PayrollRepo payrollRepo = new PayrollJSONRepoImpl();


        DataSource dataSource = PostgresDataSource.getDataSource();
        EmployeeRepo employeeRepo = new EmployeePostgresRepoImpl(dataSource);
        SalaryRepo salaryRepo = new SalaryPostgresRepoImpl(dataSource);
        PayrollRepo payrollRepo = new PayrollPostgresRepoImpl(dataSource);


        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepo, salaryRepo);
        SalaryService salaryService = new SalaryServiceImpl(salaryRepo);
        PayrollService payrollService = new PayrollServiceImpl(payrollRepo, employeeRepo, salaryRepo);


        Scanner scanner = new Scanner(System.in);
        EmployeeHandler employeeHandler = new EmployeeCLIHandlerImpl(scanner, employeeService);
        SalaryHandler salaryHandler = new SalaryCLIHandlerImpl(salaryService);
        PayrollHandler payrollHandler = new PayrollCLIHandlerImpl(scanner, payrollService);


        Menu menu = new Menu(scanner, employeeHandler, salaryHandler, payrollHandler);
        menu.show();
    }
}

