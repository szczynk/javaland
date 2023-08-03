package org.example.payroll.service;

import org.example.payroll.model.Payroll;
import org.example.payroll.model.PayrollRequest;

import java.util.List;

public interface PayrollService {
    List<Payroll> list();

    int add(PayrollRequest payrollRequest);

    Payroll detail(int id);
}
