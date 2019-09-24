package com.base.book.oo.day02.table2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JTableViewTwo extends JFrame{
	
	private Vector rowData,columnName,row;
	private JTable jt=null;
	private JScrollPane jsp=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private Connection ct=null;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTableViewTwo jtable=new JTableViewTwo();
		
	}
	
	public JTableViewTwo() {
		columnName=new Vector();
		columnName.add("Cno");
		columnName.add("Cname");
		columnName.add("Cnum");
		columnName.add("Tem");
		columnName.add("Hum");
		columnName.add("Smo");
		columnName.add("Gps");
		
		
		rowData=new Vector();
		
			
		
		
		
		try {
			
			String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String connectDB = "jdbc:sqlserver://127.0.0.1:1499;DatabaseName=VDRMS";
			String user = "sa";
			String pwd ="522300";
			String sql="select * from C";
			
			Class.forName(JDriver);
			ct=DriverManager.getConnection(connectDB,user,pwd);
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				row=new Vector ();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				row.add(rs.getString(6));
				row.add(rs.getString(7));
				
				
				rowData.add(row);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		jt=new JTable(rowData,columnName);
		jsp=new JScrollPane(jt);
		
		this.add(jsp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}

}
