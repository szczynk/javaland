package org.example.payroll.handler;

import org.example.payroll.helper.Helper;
import org.example.payroll.service.SalaryService;
import org.example.payroll.model.Salary;

public class SalaryCLIHandlerImpl implements SalaryHandler {
    private final SalaryService salaryService;

    public SalaryCLIHandlerImpl(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @Override
    public void list() {
        Helper.clearTerminal();

        var salaries = salaryService.list();

        System.out.println("|--------|-------|---------------|---------------|---------------|----------------|");
        System.out.print("| ID\t | Grade | Basic Salary\t | Pay Cut\t | Allowance\t | Head of Family |\n");
        System.out.println("|--------|-------|---------------|---------------|---------------|----------------|");

        for (Salary salary : salaries) {
            System.out.printf("| %d\t | %d\t | %d\t | %d\t | %d\t | %d\t  |\n", salary.getId(), salary.getGrade(), salary.getBasicSalary(), salary.getPayCut(), salary.getAllowance(), salary.getHeadOfFamily());
        }

        System.out.println("|--------|-------|---------------|---------------|---------------|----------------|");
    }
}
