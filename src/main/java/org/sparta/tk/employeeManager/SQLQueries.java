package org.sparta.tk.employeeManager;

public interface SQLQueries {

    final String URL = "jdbc:mysql://localhost:3306/sparta_employees";
    final String getActor = "SELECT firstName, lastName FROM sparta_employees.employeedetails WHERE employee_ID = ?";
    final String INSERT = "INSERT INTO sparta_employees.employeedetails VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String REMOVE = "DELETE FROM sparta_employees.employeedetails WHERE  employee_ID = ?";
    final String COUNT = "SELECT COUNT(*) FROM sparta_employees.employeedetails";
}
