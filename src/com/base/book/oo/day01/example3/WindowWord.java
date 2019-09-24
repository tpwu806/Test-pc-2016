package com.base.book.oo.day01.example3;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class WindowWord extends JFrame{

	JTextField inputText,showText;
	WordPolice police;//监视器
	
	WindowWord()
	{
		setLayout(new FlowLayout());
		inputText =new  JTextField(10);
		showText = new JTextField(10);
		add(inputText);
		add(showText);
		police = new WordPolice();
		police.setJTextField(showText);
		inputText.addActionListener(police);
		setBounds(100,100,400,280);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
