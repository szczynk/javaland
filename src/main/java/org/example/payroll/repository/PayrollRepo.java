package org.example.payroll.repository;

import org.example.payroll.model.Payroll;

import java.util.List;

public interface PayrollRepo {
    List<Payroll> list();

    int add(Payroll payroll);

    Payroll detail(int id);
}
