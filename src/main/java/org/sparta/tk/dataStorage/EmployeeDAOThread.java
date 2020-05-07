package org.sparta.tk.dataStorage;

import org.sparta.tk.data.Employee;
import org.sparta.tk.data.Password;
import org.sparta.tk.employeeManager.SQLQueries;

import java.sql.*;

public class EmployeeDAOThread implements Runnable, SQLQueries, Password {


    @Override
    public void run() {

    }

    public void addEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection(URL, "root", password)) {
            int hasRun = 0;
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, employee.getEmployeeID());
            statement.setString(2, employee.getNamePrefix());
            statement.setString(3, employee.getFirstName());
            statement.setString(4, String.valueOf(employee.getMiddleInitial()));
            statement.setString(5, employee.getLastName());
            statement.setString(6, String.valueOf(employee.getGender()));
            statement.setString(7, employee.getEmail());
            statement.setDate(8, Date.valueOf(employee.getDateOfBirth()));
            statement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
            statement.setInt(10, employee.getSalary());
            hasRun = statement.executeUpdate();
            if (hasRun == 1) {
                System.out.println("actor Added");
            } else {
                System.out.println("Actor not added");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
