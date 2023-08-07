package org.example.payroll.repository;

import org.example.payroll.model.Salary;

import java.util.List;

public interface SalaryRepo {
    List<Salary> list();

    Salary detailByGrade(int grade);
}
