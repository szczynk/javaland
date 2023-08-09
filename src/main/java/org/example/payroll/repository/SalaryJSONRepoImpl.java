package org.example.payroll.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.payroll.model.Salary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalaryJSONRepoImpl implements SalaryRepo {
    private static final String FILE_PATH = "salary.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<Salary> salaries;

    public SalaryJSONRepoImpl() {
        salaries = decodeJSONFile();
    }

    public static void main(String[] args) {
        var salaryRepo = new SalaryJSONRepoImpl();
        System.out.println(salaryRepo.list());
        salaryRepo.encodeJSONFile();
    }

    private List<Salary> decodeJSONFile() {
        try {
            File jsonFile = new File(FILE_PATH);

            // Read JSON array from file into List<Salary>
            return objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            System.err.println("decodeJSONFile error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void encodeJSONFile() {
        try {
            File jsonFile = new File(FILE_PATH);

            // Write List<Salary> back to the file
            objectMapper.writeValue(jsonFile, salaries);
        } catch (IOException e) {
            System.err.println("encodeJSONFile error: " + e.getMessage());
        }
    }

    @Override
    public List<Salary> list() {
        return salaries;
    }


    @Override
    public Salary detailByGrade(int grade) {
        int idx = getIdxByGrade(grade);
        var salaries = list();

        return salaries.get(idx);
    }

    private int getIdxByGrade(int grade) {
        var salaries = list();
        for (int i = 0; i < salaries.size(); i++) {
            if (grade == salaries.get(i).getGrade()) {
                return i;
            }
        }
        return -1;
    }
}
