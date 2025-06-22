package com.jdbc.main;


import java.util.Scanner;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.pojo.Employee;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			System.out.println("-----Employee Management System----");
			System.out.println("1. Add Employee data");
			System.out.println("2. Get Employee by id : ");
			System.out.println("3. Update Employee data");
			System.out.println("4. Delete Employee data");
			System.out.println("5. Show Employee data");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			ch = sc.nextInt();
			switch(ch) {
			case 1:
				AddData(sc);
				break;
			case 2:
				GetDataById(sc);
				break;
			case 3:
				UpdateData(sc);
				break;
			case 4:
				DeleteData(sc);
				break;
			case 5:
				ShowData();
				break;
			case 6:
				System.out.println("Exiting from program...");
				System.exit(0);
				break;
			default:
				System.out.println("Enter vaild choice from (1-5)");			
			}
		}while(ch!=6);

	}

	private static void AddData(Scanner sc) {
		System.out.println("Enter Employee name : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter Employee Department : ");
		String department = sc.nextLine();
		System.out.println("Enter Employee Salary : ");
		double salary = sc.nextDouble();
		Employee e = new Employee(name,department,salary);
		EmployeeDao.addEmployee(e);
	}
	
	private static void GetDataById(Scanner sc) {
		System.out.println("Enter Employee id : ");
		int id = sc.nextInt();
		EmployeeDao.getEmployee(id);
		
	}
	private static void UpdateData(Scanner sc) {
		System.out.println("Enter employee id to update : ");
		int id = sc.nextInt();
		System.out.println("Enter updated employee name : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter updated employee department : ");
		String department = sc.nextLine();
		System.out.println("Enter updated employee salary : ");
		double salary = sc.nextDouble();
		Employee e = new Employee(id,name,department,salary);
		EmployeeDao.updateEmployee(e);
	}
	
	private static void DeleteData(Scanner sc) {
		System.out.println("Enter Employee id to be deleted : ");
		int id = sc.nextInt();
		EmployeeDao.deleteEmployee(id);
		
	}
	private static void ShowData() {
		EmployeeDao.showEmployee();
		
	}


}  