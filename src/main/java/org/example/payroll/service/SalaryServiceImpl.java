package org.example.payroll.service;

import org.example.payroll.model.Salary;
import org.example.payroll.repository.SalaryRepo;

import java.util.List;

public class SalaryServiceImpl implements SalaryService {
    private final SalaryRepo salaryRepo;

    public SalaryServiceImpl(SalaryRepo salaryRepo) {
        this.salaryRepo = salaryRepo;
    }

    @Override
    public List<Salary> list() {
        return salaryRepo.list();
    }
}
