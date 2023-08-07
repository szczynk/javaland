package org.example.payroll.service;

import org.example.payroll.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> list();

    int add(Employee employee);

    Employee detail(int id);

    int update(int employeeId, Employee employee);

    void delete(int employeeId);
}
