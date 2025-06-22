 package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbc.db.CP;
import com.jdbc.pojo.Employee;

public class EmployeeDao {
	public static boolean addEmployee(Employee e) {
		boolean flag = false;
		try {
			Connection con = CP.createC();
			String sql = "Insert into employeeData(name,department,salary) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getDepartment());
			ps.setDouble(3, e.getSalary());
			ps.executeUpdate();
			flag = true;
			System.out.println("Data added successfully!!!");
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		return flag;
	}
	public static boolean getEmployee(int id) {
		boolean flag = false;
		try {
			Connection con = CP.createC();
			String sql = "select * from employeeData where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Employee e = new Employee();
			while(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDepartment(rs.getString(3));
				e.setSalary(rs.getDouble(4));	
			}
			System.out.println("Employee name : " + e.getName());
			System.out.println("Employee Department : " + e.getDepartment());
			System.out.println("Employee salary : " + e.getSalary());
			flag = true;
		}catch(Exception e1) {
			System.out.println("No data with " + id + "is found!!");
			e1.printStackTrace();
		}
		return flag;
	}
	public static boolean updateEmployee(Employee e) {
		boolean flag = false;
		try {
			Connection con = CP.createC();
			String sql = "update employeeData set name=?,department=?,salary=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getDepartment());
			ps.setDouble(3, e.getSalary());
			ps.setInt(4,e.getId());
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				flag = true;
				System.out.println("Data updated successfully!!");
			}else {
				System.out.println("ID not found to be updated");
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		return flag;
	}
	public static boolean deleteEmployee(int id) {
		boolean flag = false;
		try {
			Connection con = CP.createC();
			String sql = "delete from employeeData where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			flag = true;
			System.out.println("Data deleted successfully!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static void showEmployee() {
		try {
			Connection con = CP.createC();
			String sql = "select * from employeeData";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String department = rs.getString(3);
				double salary = rs.getDouble(4);
				System.out.println("Employee id : " + id);
				System.out.println("Employee name : " + name);
				System.out.println("Employee department : " + department);
				System.out.println("Employee salary : " + salary);
				System.out.println("------------------------------------");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}  

