package org.sparta.tk;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.tk.data.EmployeeCSVReader;
import org.sparta.tk.employeeManager.EmployeeManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Tolga Komur.
 */
public class Tester
{

    EmployeeManager employeeManager = new EmployeeManager();

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Testing CSV Reader")
    public void checkIfCSVWorks()
    {

        employeeManager.addEmployeeRecordsIntoDB();
    }
    @Test
    @DisplayName("Look Up Employee in DB")
    public void testLookUpToDB()
    {

    }
    @Test
    @DisplayName("Count Employees in DB")
    public void countEmployees()
    {
        employeeManager.countEmployeeRecordsInDB();
    }
}
