package test2015up.com.day02.table3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JTableView extends JFrame{
	
	private Vector rowData,columnName;
	private JTable jt=null;
	private JScrollPane jsp=null;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTableView jtable=new JTableView();
		
	}
	
	public JTableView(){
		columnName=new Vector();
		columnName.add("学号");
		columnName.add("名字");
		columnName.add("性别");
		columnName.add("年龄");
		columnName.add("籍贯");
		columnName.add("系别");
		
		rowData=new Vector();
		Vector hang=new Vector ();

		hang.add("sp001");
		hang.add("孙悟空");
		hang.add("男");
		hang.add("500");
		hang.add("花果山");
		hang.add("少林派");
		
		rowData.add(hang);
		
		jt=new JTable(rowData,columnName);
		jsp=new JScrollPane(jt);
		
		this.add(jsp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}

}
