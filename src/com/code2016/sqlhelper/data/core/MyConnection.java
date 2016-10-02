package com.code2016.sqlhelper.data.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.code2016.sqlhelper.common.tools.SqlTools;
import com.code2016.sqlhelper.data.path.MyProperties;

/**
 * @Description: 获得Connection
 * @author wutp 2016年9月22日
 * @version 1.0
 */
public class MyConnection {

	private Connection con=null;	
	
	private String driver;
	private String url;
	private String user;
	private String pwd;	
	
	
	
	private MyConnection()throws Exception{
		 new MyConnection(1);
	}

	public MyConnection(int id)throws Exception{
		try {
			MyProperties.getDbMessage(id);
			driver = MyProperties.getDriver();
			url = MyProperties.getUrl();
			user = MyProperties.getName();
			pwd = MyProperties.getPwd();
			if(!SqlTools.checkNull(driver,url,user,pwd)){
				throw new Exception("获取数据库配置文件信息失败！");
			}			
			initConnection();
		} catch (Exception e) {			
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	private void initConnection()throws Exception{
		try {
			Class.forName(driver);			
			con=DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {			
			e.printStackTrace();
			throw e;
		}
	}

	public Connection getCon() throws Exception{
		return this.con;
	}
		
	public static void BackPreparedStatement(Connection conn) throws SQLException{
		if(conn ==null)
			return;
		try {			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void BackPreparedStatement(Connection conn,PreparedStatement stmt)
			throws SQLException {
		if (stmt == null)
			return;
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void BackPreparedStatement(Connection conn,PreparedStatement stmt,
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
		
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}


