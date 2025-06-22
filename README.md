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
```
## Project Structure and Package Overview

The project is organized into separate packages to keep the code clean, modular, and maintainable by clearly separating different responsibilities:

- **`dao` (Data Access Object) package**  
  This package contains classes responsible for interacting with the database. It handles all CRUD operations (Create, Read, Update, Delete) by executing SQL queries through JDBC. By isolating database logic here, the rest of the application doesn’t need to know how data is stored or retrieved.

- **`pojo` (Plain Old Java Object) package**  
  This package contains simple Java classes that represent the data structure of your application entities. For example, the `Employee` class holds employee attributes like id, name, department, and salary. These classes are used to transfer data between different layers of the app.

- **`db` package**  
  This package manages the database connection setup. It provides a reusable connection object so the rest of the application can easily access the database without worrying about connection details or configuration.

- **`main` package**  
  This package contains the entry point of the application (`App.java`). It handles the user interface (console inputs/outputs) and orchestrates interactions between the user, the DAO layer, and other parts of the program.

---

By separating the application into these logical parts, the project achieves:  
- **Separation of concerns:** Each package has a single responsibility.  
- **Easier maintenance:** Changes in one part (like database queries) don’t affect unrelated parts (like UI).  
- **Better readability:** Anyone new to the project can easily understand and navigate the codebase.

## Note: Adding the MySQL JDBC Driver

To run this project successfully, you need to have the **MySQL JDBC driver (JAR file)** added to your project’s build path.

### 📦 Steps to Add MySQL JAR in Eclipse

1. **Download** the MySQL Connector (JDBC driver) from the official site:  

2. **Extract** the ZIP file if it's downloaded in a compressed format.

3. In **Eclipse**:
   - Right-click on your project name in the **Project Explorer**
   - Go to **Build Path** → **Configure Build Path**
   - In the **Libraries** tab, click on **"Add External JARs..."**
   - Browse to the location where you downloaded the MySQL connector and select the `.jar` file (e.g., `mysql-connector-java-8.0.xx.jar`)
   - Click **Apply and Close**

That's it! Your project can now communicate with MySQL using JDBC.

> 💡 Make sure MySQL is installed and running, and that your connection details in the code (username, password, DB name, etc.) are correct.


