package org.example.payroll.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Salary {
    private int id;
    private int grade;
    @JsonProperty("basic_salary")
    private long basicSalary;

    @JsonProperty("pay_cut")
    private long payCut;
    private long allowance;
    @JsonProperty("head_of_family")
    private long headOfFamily;

    public Salary() {
        setGrade(0);
        setBasicSalary(0);
        setPayCut(0);
        setAllowance(0);
        setHeadOfFamily(0);
    }

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

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", grade=" + grade +
                ", basicSalary=" + basicSalary +
                ", payCut=" + payCut +
                ", allowance=" + allowance +
                ", headOfFamily=" + headOfFamily +
                '}';
    }
}
