package org.example.payroll.model;

public class Salary {
    private int id;
    private int grade;
    private long basicSalary;
    private long payCut;
    private long allowance;
    private long headOfFamily;

    public Salary(int grade, long basicSalary, long payCut, long allowance, long headOfFamily) {
        setGrade(grade);
        setBasicSalary(basicSalary);
        setPayCut(payCut);
        setAllowance(allowance);
        setHeadOfFamily(headOfFamily);
    }

    public Salary(int id, int grade, long basicSalary, long payCut, long allowance, long headOfFamily) {
        setId(id);
        setGrade(grade);
        setBasicSalary(basicSalary);
        setPayCut(payCut);
        setAllowance(allowance);
        setHeadOfFamily(headOfFamily);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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

    public long getAllowance() {
        return allowance;
    }

    public void setAllowance(long allowance) {
        this.allowance = allowance;
    }

    public long getHeadOfFamily() {
        return headOfFamily;
    }

    public void setHeadOfFamily(long headOfFamily) {
        this.headOfFamily = headOfFamily;
    }
}
