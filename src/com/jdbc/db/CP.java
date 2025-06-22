package com.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	static Connection con;
	public static Connection createC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employee";
			String username = "root";
			String password = "root";
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	

}