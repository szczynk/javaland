package org.example.payroll.model;

public class Payroll {
    private int id;
    private long basicSalary;
    private long payCut;
    private long additionalSalary;
    private Employee employee;
    private int employeeId;

    public Payroll(long basicSalary, long payCut, long additionalSalary, Employee employee, int employeeId) {
        setBasicSalary(basicSalary);
        setPayCut(payCut);
        setAdditionalSalary(additionalSalary);
        setEmployee(employee);
        setEmployeeId(employeeId);
    }

    public Payroll(int id, long basicSalary, long payCut, long additionalSalary, Employee employee, int employeeId) {
        setId(id);
        setBasicSalary(basicSalary);
        setPayCut(payCut);
        setAdditionalSalary(additionalSalary);
        setEmployee(employee);
        setEmployeeId(employeeId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public long getPayCut() {
        return payCut;
    }

    public void setPayCut(long payCut) {
        this.payCut = payCut;
    }

    public long getAdditionalSalary() {
        return additionalSalary;
    }

    public void setAdditionalSalary(long additionalSalary) {
        this.additionalSalary = additionalSalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
