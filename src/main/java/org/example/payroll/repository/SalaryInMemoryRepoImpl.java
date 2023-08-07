package org.example.payroll.repository;

import org.example.payroll.model.Salary;

import java.util.List;

public class SalaryInMemoryRepoImpl implements SalaryRepo {
    private final List<Salary> salaries = List.of(
            new Salary(1, 1, 5_000_000,
                    100_000, 150_000, 1_000_000),
            new Salary(2, 2, 10_000_000,
                    200_000, 300_000, 2_000_000),
            new Salary(3, 3, 15_000_000,
                    400_000, 600_000, 4_000_000)
    );

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
