package org.example.payroll.repository;

import org.example.payroll.model.Employee;

import java.util.List;

public interface EmployeeRepo {
    List<Employee> list();

    int add(Employee employee);

    Employee detail(int id);

    int update(int employeeId, Employee newEmployee);

    void delete(int employeeId);
}
