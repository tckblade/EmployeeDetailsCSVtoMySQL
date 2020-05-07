# EmployeeDetailsCSVtoMySQL

The employee details program purposes is to read 160,000+ employee details from a CSV file and move it into a 
MySQL database while doing it efficiently and keeping integrity. 

This program was done using Intellij in Java with unit testing done using JUNIT, MVC software design pattern, Log4j for logging 
and error reporting. 

It extracts each employees detail from CSV file using Regex, saves it into Employee object and adds it to a HashMap so it could 
persist in the program.  Now you will be able to use queries in Java to efficiently and quickly add the employee details to the database, 
which is done by executing an updated query to pass along all the employee objects in the HashMap to the database.

# Prerequisite:
You will need a Relational database in MySQL workbench with a table of the corresponding columns for the employee details. An example is inside the `Employee Details SQL Table Schema.txt` file.
