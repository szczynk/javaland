package org.example.payroll.repository;

import org.example.payroll.model.Payroll;

import java.util.ArrayList;
import java.util.List;

public class PayrollInMemoryRepoImpl implements PayrollRepo {
    private final List<Payroll> payrolls = new ArrayList<>();

    @Override
    public List<Payroll> list() {
        return payrolls;
    }

    @Override
    public int add(Payroll payroll) {
        int id = getLastID() + 1;

        payroll.setId(id);
        payrolls.add(payroll);

        return id;
    }

    @Override
    public Payroll detail(int id) {
        int idx = getIdxById(id);
        var payrolls = list();

        return payrolls.get(idx);
    }

    private int getIdxById(int id) {
        var payrolls = list();
        for (int i = 0; i < payrolls.size(); i++) {
            if (id == payrolls.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    private int getLastID() {
        var employees = list();

        int tempId = 0;
        for (Payroll payroll : employees) {
            if (tempId < payroll.getId()) {
                tempId = payroll.getId();
            }
        }

        return tempId;
    }
}
