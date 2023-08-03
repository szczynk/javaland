package org.example.payroll.service;

import org.example.payroll.model.Payroll;
import org.example.payroll.model.PayrollRequest;
import org.example.payroll.model.Salary;
import org.example.payroll.repository.EmployeeRepo;
import org.example.payroll.repository.PayrollRepo;
import org.example.payroll.repository.SalaryRepo;

import java.util.List;

public class PayrollServiceImpl implements PayrollService {
    private final PayrollRepo payrollRepo;
    private final EmployeeRepo employeeRepo;
    private final SalaryRepo salaryRepo;

    public PayrollServiceImpl(PayrollRepo payrollRepo, EmployeeRepo employeeRepo, SalaryRepo salaryRepo) {
        this.payrollRepo = payrollRepo;
        this.employeeRepo = employeeRepo;
        this.salaryRepo = salaryRepo;
    }

    @Override
    public List<Payroll> list() {
        return payrollRepo.list();
    }

    @Override
    public int add(PayrollRequest payrollRequest) {
        var employee = employeeRepo.detail(payrollRequest.getEmployeeId());

        long basicSalary = 0;
        long payCut = 0;
        long additionalSalary = 0;

        var salaries = salaryRepo.list();

        for (Salary salary : salaries) {
            if (salary.getGrade() == employee.getGrade()) {
                basicSalary = salary.getBasicSalary();
                payCut = salary.getPayCut() * payrollRequest.getTotalHariTidakMasuk();
                additionalSalary = salary.getAllowance() * payrollRequest.getTotalHariMasuk();
                if (employee.getGender().equals("laki-laki") && employee.getMarried()) {
                    additionalSalary += salary.getHeadOfFamily();
                }
            }
        }

        var payroll = new Payroll(basicSalary, payCut, additionalSalary, employee, payrollRequest.getEmployeeId());
        return payrollRepo.add(payroll);
    }

    @Override
    public Payroll detail(int id) {
        return payrollRepo.detail(id);
    }
}
