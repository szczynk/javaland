package org.example.payroll.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.payroll.model.Employee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJSONRepoImpl implements EmployeeRepo {
    private static final String FILE_PATH = "employee.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Employee> employees;

    public EmployeeJSONRepoImpl() {
        employees = decodeJSONFile();
    }

    public static void main(String[] args) {
        var employeeRepo = new EmployeeJSONRepoImpl();
        System.out.println(employeeRepo.list().toString());
        employeeRepo.encodeJSONFile();
    }

    private List<Employee> decodeJSONFile() {
        File jsonFile = new File(FILE_PATH);

        try {
            // Read JSON array from file into List<Employee>
            employees = objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
            return employees;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            employees = new ArrayList<>();
            return employees;
        }
    }

    private void encodeJSONFile() {
        try {
            File jsonFile = new File(FILE_PATH);

            // Write List<Employee> back to the file
            objectMapper.writeValue(jsonFile, employees);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Employee> list() {
        return employees;
    }

    @Override
    public int add(Employee employee) {
        int id = getLastID() + 1;

        employee.setId(id);
        employees.add(employee);

        encodeJSONFile();

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

        encodeJSONFile();

        return oldEmployee.getId();
    }

    @Override
    public void delete(int employeeId) {
        int idx = getIdxById(employeeId);
        var employees = list();

        employees.remove(idx);

        encodeJSONFile();
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
