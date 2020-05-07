package org.sparta.tk.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class EmployeeCSVReader {

    private HashMap<String, Employee> employeeRecord = new HashMap<String, Employee>();

    public HashMap<String, Employee> getEmployeeRecord() {
        return employeeRecord;
    }

    public void readAllEmployeesFromCSV(String fileName) {
        readFromCSV(fileName); // let's print all the person read from CSV file
        for (Employee i : employeeRecord.values()) {
            System.out.println(i.toString());
        }
    }

    private void readFromCSV(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine(); // removes the header
            line = br.readLine();
            while (line != null) {
                String[] valueInTheRow = line.split(",");
                Employee employee = createEmployeeObject(valueInTheRow);
                employeeRecord.put(employee.getEmployeeID(),employee);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Employee createEmployeeObject(String[] metadata) {
        String employeeID = metadata[0];
        String namePrefix = metadata[1];
        String firstName = metadata[2];
        char middleInitial = metadata[3].charAt(0);
        String lastName = metadata[4];
        char gender = metadata[5].charAt(0);
        String email = metadata[6];
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(metadata[7], formatter);
        LocalDate dateOfJoining = LocalDate.parse(metadata[8], formatter);
        int salary = Integer.parseInt(metadata[9]);

        return new Employee(employeeID, namePrefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, salary);
    }
}
