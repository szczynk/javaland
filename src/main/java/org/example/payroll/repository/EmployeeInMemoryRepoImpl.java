package org.example.payroll.repository;

import org.example.payroll.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeInMemoryRepoImpl implements EmployeeRepo {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> list() {
        return employees;
    }

    @Override
    public int add(Employee employee) {
        int id = getLastID() + 1;

        employee.setId(id);
        employees.add(employee);

        return id;
    }

    @Override
    public Employee detail(int id) {
        int idx = getIdxById(id);
        var employees = list();

        return employees.get(idx);
    }

    @Override
    public int update(int employeeId, Employee newEmployee) {
        int idx = getIdxById(employeeId);
        var employees = list();

        Employee oldEmployee = employees.get(idx);
        oldEmployee.setName(newEmployee.getName());
        oldEmployee.setGender(newEmployee.getGender());
        oldEmployee.setGrade(newEmployee.getGrade());
        oldEmployee.setMarried(newEmployee.getMarried());

        return oldEmployee.getId();
    }

    @Override
    public void delete(int employeeId) {
        int idx = getIdxById(employeeId);
        var employees = list();

        employees.remove(idx);
    }

    private int getIdxById(int id) {
        var employees = list();
        for (int i = 0; i < employees.size(); i++) {
            if (id == employees.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    private int getLastID() {
        var employees = list();

        int tempId = 0;
        for (Employee employee : employees) {
            if (tempId < employee.getId()) {
                tempId = employee.getId();
            }
        }

        return tempId;
    }
}
