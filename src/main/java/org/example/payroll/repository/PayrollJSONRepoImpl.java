package org.example.payroll.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.payroll.model.Payroll;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PayrollJSONRepoImpl implements PayrollRepo {
    private static final String FILE_PATH = "payroll.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Payroll> payrolls;

    public PayrollJSONRepoImpl() {
        payrolls = decodeJSONFile();
    }

    public static void main(String[] args) {
        var payrollRepo = new PayrollJSONRepoImpl();
        System.out.println(payrollRepo.list().toString());
        payrollRepo.encodeJSONFile();
    }

    private List<Payroll> decodeJSONFile() {
        File jsonFile = new File(FILE_PATH);

        try {
            // Read JSON array from file into List<Payroll>
            payrolls = objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
            return payrolls;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            payrolls = new ArrayList<>();
            return payrolls;
        }
    }

    private void encodeJSONFile() {
        try {
            File jsonFile = new File(FILE_PATH);

            // Write List<Payroll> back to the file
            objectMapper.writeValue(jsonFile, payrolls);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Payroll> list() {
        return payrolls;
    }

    @Override
    public int add(Payroll payroll) {
        int id = getLastID() + 1;

        payroll.setId(id);
        payrolls.add(payroll);

        encodeJSONFile();

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
        var payrolls = list();

        int tempId = 0;
        for (Payroll payroll : payrolls) {
            if (tempId < payroll.getId()) {
                tempId = payroll.getId();
            }
        }

        return tempId;
    }
}
