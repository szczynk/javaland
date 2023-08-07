package org.example.payroll.service;

import org.example.payroll.model.Employee;
import org.example.payroll.model.Salary;
import org.example.payroll.repository.EmployeeRepo;
import org.example.payroll.repository.SalaryRepo;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final SalaryRepo salaryRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, SalaryRepo salaryRepo) {
        this.employeeRepo = employeeRepo;
        this.salaryRepo = salaryRepo;
    }

    @Override
    public List<Employee> list() {
        return employeeRepo.list();
    }

    @Override
    public int add(Employee employee) {
        var salaries = salaryRepo.list();

        boolean isValidGrade = false;
        for (Salary salary : salaries) {
            if (employee.getGrade() == salary.getGrade()) {
                isValidGrade = true;
                break;
            }
        }
        if (!isValidGrade) {
            return -1;
        }

        return employeeRepo.add(employee);
    }

    @Override
    public Employee detail(int id) {
        return employeeRepo.detail(id);
    }

    @Override
    public int update(int employeeId, Employee newEmployee) {
        var salaries = salaryRepo.list();

        boolean isValidGrade = false;
        for (Salary salary : salaries) {
            if (newEmployee.getGrade() == salary.getGrade()) {
                isValidGrade = true;
                break;
            }
        }
        if (!isValidGrade) {
            return -1;
        }

        return employeeRepo.update(employeeId, newEmployee);
    }

    @Override
    public void delete(int employeeId) {
        employeeRepo.delete(employeeId);
    }
}
