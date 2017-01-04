package com.code2015.book.oo.day02.table4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;




public class JTableView_4 extends JFrame implements ActionListener{
	
	private JPanel jp1,jp2;
	private JLabel jl1;
	private JButton jb1,jb2,jb3,jb4;
    private JTextField jtf;
    private JTable jt;
    private JScrollPane jsp=null;
    private TableModel tm;	

	public static void main(String[] args) {
		new JTableView_4();
	}
	
	public JTableView_4()
	{
		//上面
		jp1=new JPanel();
		jl1=new JLabel("请输入ID");
		jtf=new JTextField(10);
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);

		//下面
		jp2=new JPanel();
		jb2=new JButton("添加");
		jb2.addActionListener(this);
		jb3=new JButton("修改");
		jb3.addActionListener(this);
		jb4=new JButton("删除");
		jb4.addActionListener(this);
		//jb4.setActionCommand(arg0);
		
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
			
		//中间
		String []params={"1"};
		String sql="select * from Test where 1=?";
		tm=new TableModel();
		tm.query(sql, params);
		jt= new JTable(tm);		
		jsp=new JScrollPane(jt);
		
		this.add(jp1,"North");
		this.add(jsp);
		this.add(jp2,"South");		
		this.setSize(400,300);
		//this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1){
			System.out.println("用户想要查询");
			
			String []params={this.jtf.getText()};			
			String sql="select * from Test where Cname=?";
			tm=new TableModel();
			tm.query(sql, params);			
			jt.setModel(tm);
		}else if(arg0.getSource()==jb2){
			CAddDialog sa=new CAddDialog(this, "添加窗口", true );
		}
	}

}
