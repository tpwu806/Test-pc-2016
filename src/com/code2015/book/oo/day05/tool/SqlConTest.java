package com.code2015.book.oo.day05.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConTest {
	
	public static void main(String[] args) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDB = "jdbc:sqlserver://127.0.0.1:1499;DatabaseName=VDRMS";
		try {
			Class.forName(JDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();			
			System.exit(0);
		}		
		try {
			String user = "sa";
			String pwd ="522300";
			Connection con = DriverManager.getConnection(connectDB, user,pwd);
			Statement stmt = con.createStatement();			
			ResultSet rs = stmt.executeQuery("SELECT * FROM C");			
			while (rs.next()) {				
				System.out.println(rs.getString("Cname") + "\t"+ rs.getString("Cnum"));
			}			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();			
			System.exit(0);
		}
	}

}
