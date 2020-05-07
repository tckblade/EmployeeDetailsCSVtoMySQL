package org.sparta.tk.dataStorage;

import org.sparta.tk.data.Employee;
import org.sparta.tk.data.Password;
import org.sparta.tk.employeeManager.SQLQueries;

import java.sql.*;
import java.util.HashMap;

public class EmployeeDAO implements Password, SQLQueries {

    public void getEmployeeDetails(String id) {
        try (Connection connection = DriverManager.getConnection(URL, "root", password)) {
            PreparedStatement statement = connection.prepareStatement(getActor);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString(3);
                String lastName = resultSet.getString(5);
                System.out.println("Actor is " + firstName + " " + lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void countAllEmployeesInDB() {
        try (Connection connection = DriverManager.getConnection(URL, "root", password)) {
            PreparedStatement statement = connection.prepareStatement(getActor);

            ResultSet resultSet = statement.executeQuery();

            String countedRecords = resultSet.getString(1);

            System.out.println("Number Of Employees in table" + countedRecords);

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void addAllEmployees(HashMap<String, Employee> employeeToBeAddedDB) {
        try (Connection connection = DriverManager.getConnection(URL, "root", password)) {
            int hasRun = 0;
            for (Employee employee : employeeToBeAddedDB.values()) {
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
            }
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

    public void removeEmployee(String id) {
        try (Connection connection = DriverManager.getConnection(URL, "root", password)) {
            PreparedStatement statement = connection.prepareStatement(getActor);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            if (resultSet.getString(1) != null) {
                statement = connection.prepareStatement(REMOVE);
                statement.setString(1, id);
                int hasRun = statement.executeUpdate();
                if (hasRun == 1) {
                    System.out.println("Actor Removed Successful");
                } else {
                    System.out.println("Actor not removed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}