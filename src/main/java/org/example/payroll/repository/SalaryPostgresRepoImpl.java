package org.example.payroll.repository;

import org.example.payroll.helper.PostgresDataSource;
import org.example.payroll.model.Salary;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryPostgresRepoImpl implements SalaryRepo {
    private final DataSource dataSource;

    public SalaryPostgresRepoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        DataSource dataSource = PostgresDataSource.getDataSource();
        var salaryRepo = new SalaryPostgresRepoImpl(dataSource);
        System.out.println(salaryRepo.list());
        System.out.println(salaryRepo.detailByGrade(1));
    }

    @Override
    public List<Salary> list() {
        String sqlQuery = "SELECT id, grade, basic_salary, pay_cut, allowance, head_of_family FROM salaries ORDER BY id ASC";

        List<Salary> salaries = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery);
        ) {
            while (resultSet.next()) {
                Salary salary = new Salary(
                        resultSet.getInt("id"),
                        resultSet.getInt("grade"),
                        resultSet.getLong("basic_salary"),
                        resultSet.getLong("pay_cut"),
                        resultSet.getLong("allowance"),
                        resultSet.getLong("head_of_family")
                );

                salaries.add(salary);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return salaries;
    }

    @Override
    public Salary detailByGrade(int grade) {
        String sqlQuery = "SELECT id, grade, basic_salary, pay_cut, allowance, head_of_family FROM salaries WHERE grade = ? LIMIT 1";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ) {
            statement.setInt(1, grade);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Salary(
                        resultSet.getInt("id"),
                        resultSet.getInt("grade"),
                        resultSet.getLong("basic_salary"),
                        resultSet.getLong("pay_cut"),
                        resultSet.getLong("allowance"),
                        resultSet.getLong("head_of_family")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null; // not found
    }
}
