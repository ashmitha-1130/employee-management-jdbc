# Employee Management System (Java + JDBC)

A basic console-based CRUD application to manage employee records using Java and JDBC.

## Features
- Add new employee
- View employee by ID
- Update employee details
- Delete employee
- Show all employees

## Technologies Used
- Java
- JDBC
- MySQL
- Eclipse IDE

## How to Run
1. Clone the repo
2. Import the project in Eclipse
3. Create a MySQL table using this SQL:
```sql
CREATE TABLE employeeData (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DOUBLE
);
