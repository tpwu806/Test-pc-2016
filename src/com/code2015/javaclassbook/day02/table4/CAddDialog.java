package com.code2015.javaclassbook.day02.table4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class CAddDialog extends JDialog implements ActionListener{

	private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	private JButton jb1,jb2;
	private JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;
	private JPanel jp1,jp2,jp3;
	private TableModel jt=null;
	
	public CAddDialog(Frame owner,String title,boolean modal)
	{
		super(owner,title,modal);
		
		jl1=new JLabel("Cno");
		jl2=new JLabel("Cname");
		jl3=new JLabel("Cnum");
		jl4=new JLabel("Tem");
		jl5=new JLabel("Hum");
		jl6=new JLabel("Smo");
		jl7=new JLabel("Gps");	
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		jtf6=new JTextField();
		jtf7=new JTextField();
		
		jb1=new JButton("添加");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		
		jp1=new JPanel(new GridLayout(8,1));
		jp2=new JPanel(new GridLayout(8,1));		
		jp3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		this.setSize(250,300);
		this.setVisible(true);
				
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1){		
			String sql="insert into Test values(?,?,?,?,?,?,?)";
			String []params={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText()};
			TableModel tm=new TableModel();
			if(!tm.UpdateModel(sql, params)){
				JOptionPane.showMessageDialog(null, "添加失败");
			}
			JOptionPane.showMessageDialog(null, "添加成功");
			this.dispose();		
		}else if(arg0.getSource()==jb2){
			this.dispose();
		}
		
	}
	
}
