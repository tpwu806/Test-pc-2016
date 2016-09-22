package test2015up.com.day02.table1;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TableView extends JFrame{

    private JPanel jp1,jp2,jp3,jp4,jp5,jp6;
    private JLabel jl1,jl2,jl3;
    private JTextField jf1;
    private JButton jb1,jb2,jb3,jb4,jb5;
    private JTable table;
    private JScrollPane js1;
    private JSplitPane jsp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TableView tv=new TableView();
	}
    public  TableView(){
    	//顶部
    	jp1= new  JPanel(new FlowLayout(FlowLayout.CENTER));
    	jl1= new  JLabel("请输入ID");
    	jf1 = new JTextField(12);
    	jb1 = new JButton("查询");
    	jp1.add(jl1);
    	jp1.add(jf1);
    	jp1.add(jb1);
    	
    	//中部
    	jp2 =new JPanel(new FlowLayout(FlowLayout.CENTER));
    	table =new JTable();
    	js1 = new JScrollPane(table);  	
    	jp2.add(js1);
    	
    	//底部
    	
    	jp6=new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	//jp4=new JPanel(new FlowLayout(FlowLayout.LEFT));
    	jl2=new JLabel("总有**条记录");
    	//jp4.add(jl2);
    	
    	//jp5=new JPanel(new FlowLayout());
    	jl3=new JLabel("2015/9/5 23:00:00");
    	//jp5.add(jl3);
    	
    	
    	jb2=new JButton("详细");
    	jb3=new JButton("添加");
    	jb4=new JButton("删除");
    	jb5=new JButton("修改");
    	jp6.add(jl2);
    	jp6.add(jl3);
    	jp6.add(jb2);
    	jp6.add(jb3);
    	jp6.add(jb4);
    	jp6.add(jb5);
    	
  
    	
    	
    	//jp3=new JPanel(new BorderLayout());
    	//jp3.add(jb4,BorderLayout.WEST);
    	//jp3.add(jb5);
    	//jp3.add(jp6,BorderLayout.EAST);
    	//jsp=new JSplitPane(JSplitPane.VERTICAL_SPLIT ,true,jp4,jp6);
    	
    	
    	this.setLayout(new BorderLayout());
    	this.add(jp1,BorderLayout.NORTH);
    	this.add(jp2,BorderLayout.CENTER);
    	this.add(jp6,BorderLayout.SOUTH);
    	this.setVisible(true);
    	this.setSize(800,600);
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setTitle("表格显示");
			
    }
	
	
}
