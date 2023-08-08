package org.example.payroll.repository;

import org.example.payroll.helper.PostgresDataSource;
import org.example.payroll.model.Employee;
import org.example.payroll.model.Payroll;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PayrollPostgresRepoImpl implements PayrollRepo{
    private final DataSource dataSource;

    public PayrollPostgresRepoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        DataSource dataSource = PostgresDataSource.getDataSource();
        var payrollRepo = new PayrollPostgresRepoImpl(dataSource);
        System.out.println(payrollRepo.list());
        System.out.println(payrollRepo.detail(1));
        System.out.println(payrollRepo.detail(6));
    }

    @Override
    public List<Payroll> list() {
        String sqlQuery = "SELECT id, name, gender, grade, married FROM employees ORDER BY id ASC";

        List<Employee> employees = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery);
        ) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setGrade(resultSet.getInt("grade"));
                employee.setMarried(resultSet.getBoolean("married"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return employees;
    }

    @Override
    public int add(Payroll payroll) {
        return 0;
    }

    @Override
    public Payroll detail(int id) {
        return null;
    }
}
