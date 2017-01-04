package com.code2015.book.oo.day01.example4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EC_Dictionary extends JFrame{ 

    private JTextField input; 
    private JButton search; 
    private JTextArea output;      

    public EC_Dictionary(){ 
        super("英汉词典");          

        input = new JTextField(14); 
        search = new JButton("查询"); 
        search.setFont(new Font("宋体", Font.PLAIN, 15)); 
        search.addActionListener(new ActionListener(){ 

            public void actionPerformed(ActionEvent e){ 
                searchWords(); 
            } 
        }); 

        output = new JTextArea(10,18); 
        output.setEditable(false); 
        output.setFont(new Font("宋体", Font.PLAIN, 18)); 
        output.setForeground(Color.RED);         

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20)); 
        getContentPane().add(input); 
        getContentPane().add(search); 
        getContentPane().add(output); 
         
        setSize(300,320); 
        setResizable(false); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(3); 
        setVisible(true); 
    }       
    //查询单词 
    public void searchWords(){ 
        try { 
            BufferedReader br = new BufferedReader(new FileReader("dictionary.txt")); 
            String line, inputWord; 
            boolean isFound = false;              
            inputWord = input.getText(); 
            if(inputWord.equals("")){ 
                return; 
            } 
                          
            while((line = br.readLine()) != null){ 
                Scanner in = new Scanner(line);  
                if(in.next().equals(inputWord)){ 
                    int offset = inputWord.length(); 
                    output.setText("\n\n\n\n"+line.substring(offset)); 
                    isFound = true; 
                    break; 
                } 
            }              
            if(!isFound){ 
                output.setText("没找到相应项>..<"); 
            } 
        } 
        catch (Exception ex) { 
            ex.printStackTrace(); 
        } 
    }      

    public static void main (String[] args) { 
        new EC_Dictionary(); 
    } 

}