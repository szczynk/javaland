package org.example.payroll.repository;

import org.example.payroll.helper.PostgresDataSource;
import org.example.payroll.model.Employee;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePostgresRepoImpl implements EmployeeRepo {
    private final DataSource dataSource;

    public EmployeePostgresRepoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        DataSource dataSource = PostgresDataSource.getDataSource();
        var employeeRepo = new EmployeePostgresRepoImpl(dataSource);
        System.out.println(employeeRepo.list());
        System.out.println(employeeRepo.detail(1));
        System.out.println(employeeRepo.detail(6));
    }

    @Override
    public List<Employee> list() {
        String sqlQuery = "SELECT id, name, gender, grade, married FROM employees ORDER BY id ASC";

        List<Employee> employees = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery);
        ) {
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("grade"),
                        resultSet.getBoolean("married")
                );

                employees.add(employee);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return employees;
    }

    @Override
    public int add(Employee employee) {
        String sqlQuery = "INSERT INTO employees (name, gender, grade, married) VALUES (?, ?, ?, ?) RETURNING id";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getGender());
            statement.setInt(3, employee.getGrade());
            statement.setBoolean(4, employee.getMarried());

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
    public Employee detail(int id) {
        String sqlQuery = "SELECT id, name, gender, grade, married FROM employees WHERE id = ? LIMIT 1";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("grade"),
                        resultSet.getBoolean("married")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null; // not found
    }

    @Override
    public int update(int employeeId, Employee newEmployee) {
        String sqlQuery = "UPDATE employees SET name = ?, gender = ?, grade = ?, married = ? WHERE id = ? RETURNING id";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ) {
            statement.setString(1, newEmployee.getName());
            statement.setString(2, newEmployee.getGender());
            statement.setInt(3, newEmployee.getGrade());
            statement.setBoolean(4, newEmployee.getMarried());

            statement.setInt(5, newEmployee.getId());

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
    public void delete(int employeeId) {
        String sqlQuery = "DELETE FROM employees WHERE id = ?";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ) {
            statement.setInt(1, employeeId);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
