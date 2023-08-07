package org.example.payroll.handler;

import org.example.payroll.model.Payroll;
import org.example.payroll.model.PayrollRequest;
import org.example.payroll.service.PayrollService;

import java.util.Scanner;

public class PayrollCLIHandlerImpl implements PayrollHandler {
    private final Scanner scanner;
    private final PayrollService payrollService;

    public PayrollCLIHandlerImpl(Scanner scanner, PayrollService payrollService) {
        this.scanner = scanner;
        this.payrollService = payrollService;
    }

    @Override
    public void list() {
        var payrolls = payrollService.list();

        System.out.println("|--------|---------------|---------------|-------------------|-------------|");
        System.out.print("| ID\t | Basic Salary\t | Pay Cut\t | Additional Salary | Employee ID |\n");
        System.out.println("|--------|---------------|---------------|-------------------|-------------|");

        for (Payroll payroll : payrolls) {
            System.out.printf("| %d\t | %d\t | %d\t | %d\t     | %d\t   |\n", payroll.getId(), payroll.getBasicSalary(), payroll.getPayCut(), payroll.getAdditionalSalary(), payroll.getEmployeeId());
        }

        System.out.println("|--------|---------------|---------------|-------------------|-------------|");
    }

    @Override
    public void add() {
        System.out.print("employee id = ");
        int employeeId;
        try {
            employeeId = scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("invalid employee id");
            return;
        }
        if (employeeId < 1) {
            System.out.println("invalid employee id");
            return;
        }

        System.out.print("total hari masuk = ");
        int totalHariMasuk;
        try {
            totalHariMasuk = scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("invalid total hari masuk");
            return;
        }
        if (totalHariMasuk < 0) {
            System.out.println("invalid total hari masuk");
            return;
        }

        System.out.print("total hari tidak masuk = ");
        int totalHariTidakMasuk;
        try {
            totalHariTidakMasuk = scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("invalid total hari tidak masuk");
            return;
        }
        if (totalHariTidakMasuk < 0) {
            System.out.println("invalid total hari tidak masuk");
            return;
        }

        PayrollRequest payrollRequest = new PayrollRequest(employeeId, totalHariMasuk, totalHariTidakMasuk);

        int payrollId = payrollService.add(payrollRequest);
        System.out.println("successfully adding payroll with id " + payrollId);
    }

    @Override
    public void detail() {
        int payrollId;
        System.out.print("payroll id = ");
        try {
            payrollId = scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("invalid payroll id");
            return;
        }

        try {
            Payroll payroll = payrollService.detail(payrollId);

            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.println("| Salary Slip\t\t\t\t\t\t\t\t\t |");
            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.printf("| Payroll ID\t\t | %d\t\t | Nama Employee\t | %s\t |\n", payroll.getId(), payroll.getEmployee().getName());
            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.println("| Penghasilan\t\t | Jumlah\t | Potongan\t\t | Jumlah\t |");
            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.printf("| Basic Salary\t\t | %d\t | Pay Cut\t\t | %d\t |\n", payroll.getBasicSalary(), payroll.getPayCut());
            System.out.printf("| Additional Salary\t | %d\t | \t\t\t | \t\t |\n", payroll.getAdditionalSalary());
            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.printf("| Jumlah Salary\t\t | %d\t | Jumlah Potongan\t | %d\t |\n", (payroll.getBasicSalary() + payroll.getAdditionalSalary()), payroll.getPayCut());
            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.printf("| Jumlah gaji bersih\t\t\t | %d\t\t\t\t |\n", payroll.getBasicSalary() + payroll.getAdditionalSalary() - payroll.getPayCut());
            System.out.println("|--------------------------------------------------------------------------------|");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Payroll with id " + payrollId + " not exist");
        }
    }
}
