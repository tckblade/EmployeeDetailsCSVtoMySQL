package org.sparta.tk.employeeManager;

import org.apache.log4j.Logger;
import org.sparta.tk.data.Employee;
import org.sparta.tk.data.EmployeeCSVReader;
import org.sparta.tk.dataStorage.EmployeeDAO;

import java.util.HashMap;

public class EmployeeManager {
    static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    static Logger log = Logger.getLogger(Starter.class.getName());
    private HashMap<String, Employee> employeeRecords = new HashMap<String, Employee>();
    private static String fileName = "resources/EmployeeRecords.csv";

    public void setEmployeeRecord(HashMap<String, Employee> employeeRecords) {
        this.employeeRecords = employeeRecords;
    }

    public void addEmployeeRecordsIntoDB(){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addAllEmployees(employeeRecords);
    }
    public void countEmployeeRecordsInDB(){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.countAllEmployeesInDB();
    }

    public void getEmployeeDetailFromCSV(){
        EmployeeCSVReader detailsFromCSV = new EmployeeCSVReader();
        detailsFromCSV.readAllEmployeesFromCSV(fileName);
        setEmployeeRecord(detailsFromCSV.getEmployeeRecord());
    }
}
