package org.example.payroll.model;

public class PayrollRequest {
    private int employeeId;
    private int totalHariMasuk;
    private int totalHariTidakMasuk;

    public PayrollRequest(int employeeId, int totalHariMasuk, int totalHariTidakMasuk) {
        setEmployeeId(employeeId);
        setTotalHariMasuk(totalHariMasuk);
        setTotalHariTidakMasuk(totalHariTidakMasuk);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTotalHariMasuk() {
        return totalHariMasuk;
    }

    public void setTotalHariMasuk(int totalHariMasuk) {
        this.totalHariMasuk = totalHariMasuk;
    }

    public int getTotalHariTidakMasuk() {
        return totalHariTidakMasuk;
    }

    public void setTotalHariTidakMasuk(int totalHariTidakMasuk) {
        this.totalHariTidakMasuk = totalHariTidakMasuk;
    }
}
