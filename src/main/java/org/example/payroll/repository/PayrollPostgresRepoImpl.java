package org.example.payroll.repository;

import org.example.payroll.helper.PostgresDataSource;
import org.example.payroll.model.Employee;
import org.example.payroll.model.Payroll;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollPostgresRepoImpl implements PayrollRepo {
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
        String sqlQuery = "SELECT payrolls.id, payrolls.basic_salary, payrolls.pay_cut, payrolls.additional_salary, payrolls.employee_id, employees.id, employees.name, employees.gender, employees.grade, employees.married FROM payrolls INNER JOIN employees ON payrolls.employee_id = employees.id ORDER BY payrolls.id ASC";

        List<Payroll> payrolls = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery);
        ) {
            while (resultSet.next()) {
                Payroll payroll = new Payroll(
                        resultSet.getInt("id"),
                        resultSet.getLong("basic_salary"),
                        resultSet.getLong("pay_cut"),
                        resultSet.getLong("additional_salary"),
                        new Employee(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("gender"),
                                resultSet.getInt("grade"),
                                resultSet.getBoolean("married")
                        ),
                        resultSet.getInt("employee_id")
                );

                payrolls.add(payroll);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return payrolls;
    }

    @Override
    public int add(Payroll payroll) {
        String sqlQuery = "INSERT INTO payrolls (basic_salary, pay_cut, additional_salary, employee_id) VALUES (?, ?, ?, ?) RETURNING id";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ) {
            statement.setLong(1, payroll.getBasicSalary());
            statement.setLong(2, payroll.getPayCut());
            statement.setLong(3, payroll.getAdditionalSalary());
            statement.setInt(4, payroll.getEmployeeId());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return 0;
    }

    @Override
    public Payroll detail(int id) {
        String sqlQuery = "SELECT payrolls.id, payrolls.basic_salary, payrolls.pay_cut, payrolls.additional_salary, payrolls.employee_id, employees.id, employees.name, employees.gender, employees.grade, employees.married FROM payrolls INNER JOIN employees ON payrolls.employee_id = employees.id WHERE payrolls.id = ? LIMIT 1";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Payroll(
                        resultSet.getInt("id"),
                        resultSet.getLong("basic_salary"),
                        resultSet.getLong("pay_cut"),
                        resultSet.getLong("additional_salary"),
                        new Employee(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("gender"),
                                resultSet.getInt("grade"),
                                resultSet.getBoolean("married")
                        ),
                        resultSet.getInt("employee_id")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
}
