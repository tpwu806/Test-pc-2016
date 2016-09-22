package com.sql.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: 获得Connection
 * @author wutp 2016年9月22日
 * @version 1.0
 */
public class DBUtils {
	
	private Connection con=null;	
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/test";
	private String user = "root";
	private String pwd = "123456";		
	
	public DBUtils()throws Exception
	{
		try {
			Class.forName(driver);			
			con=DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {			
			e.printStackTrace();
			throw e;
		}
	}
	
	public Connection getCon() {
		return this.con;
	}
		
	public void BackPreparedStatement() throws SQLException
	{
		try {			
			if(con!=null) 
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public  void BackPreparedStatement(PreparedStatement stmt)
			throws SQLException {
		if (stmt == null)
			return;
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public  void BackPreparedStatement(PreparedStatement stmt,
			ResultSet rs)throws SQLException {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

		if (stmt == null)
			return;
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}


