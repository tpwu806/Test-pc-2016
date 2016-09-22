package test2015up.com.day01.example3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JTextField;

public class WordPolice implements ActionListener{
	JTextField showText;
	HashMap <String,String> hashtable;
	File file = new File("dictionary.txt");
	Scanner sc =null;
	WordPolice()
	{
		hashtable=new HashMap<String,String>();
		try {
			sc=new Scanner(file);
			while(sc.hasNext()){
				String englishWord=sc.next();
				String chinesaWord=sc.next();
				hashtable.put(englishWord, chinesaWord);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String englishWord = arg0.getActionCommand();
		if(hashtable.containsKey(englishWord))
		{
			String chineseWold=hashtable.get(englishWord);
			showText.setText(chineseWold);
		}else{
			showText.setText("没有此单词");
		}
		
		
	}

	public void setJTextField(JTextField showText) {
		// TODO Auto-generated method stub
		this.showText=showText;
		
	}

}
