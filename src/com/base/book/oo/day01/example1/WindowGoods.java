package com.base.book.oo.day01.example1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class WindowGoods extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	File file=null;
	JMenuBar bar;
	JMenu fileMenu;
	JMenuItem 录入,显示;
	JTextArea show;
	InputArea inputMessage;
	JPanel pCenter;
	JTable table;
	Object 表格单元[][],列名[]={"名称","库存","单价"};
	CardLayout card;
	
    WindowGoods()
	{   	
		file=new File("src\\com\\code2015\\book\\oo\\库存.txt");
		录入 = new JMenuItem("录入");
		显示  = new JMenuItem("显示");	
		bar = new JMenuBar();
		fileMenu = new JMenu("菜单选项");
		fileMenu.add(录入);
		fileMenu.add(显示);				
		bar.add(fileMenu);
		setJMenuBar(bar);
		录入.addActionListener(this);
		显示.addActionListener(this);		
		inputMessage =new InputArea(file);
		card= new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		pCenter.add("录入",inputMessage);
		add(pCenter,BorderLayout.CENTER);
		setVisible(true);
		setBounds(100, 50, 420, 380);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == 录入){
			this.dispose();
			//pCenter.removeAll();
			//card.show(pCenter, "录入");
			System.out.println("录入");
		}else if(e.getSource() == 显示){
			try {
				
				System.out.println("显示");
				FileInputStream fis =new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				LinkedList<Goods> goodsList= (LinkedList<Goods>)ois.readObject();
				fis.close();
				ois.close();
				int length = goodsList.size();
				表格单元 = new Object[length][3];
				table = new JTable(表格单元,列名);
				pCenter.removeAll();
				//pCenter.add("录入",inputMessage);
				pCenter.add("显示", new JScrollPane(table));
				pCenter.validate();
				Iterator<Goods> iter =goodsList.iterator();
				int i=0;
				while(iter.hasNext()){
					Goods 商品 = iter.next();
					表格单元[i][0]= 商品.getName();
					表格单元[i][1]= 商品.getMount();
					表格单元[i][2]= 商品.getPrice();
					i++;
				}
				table.repaint();		
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				System.out.println("erro");
				
			}
		}
		
		
	}

}