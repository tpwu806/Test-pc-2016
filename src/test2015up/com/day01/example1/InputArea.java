package test2015up.com.day01.example1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputArea extends JPanel implements ActionListener {
	
	File f=null;
	Box baseBox,box1,box2;
	JTextField name,mount,price;
	JButton button;
	LinkedList<Goods> goodsList;
	
	InputArea(File f)
	{
		this.f=f;
		goodsList=new LinkedList<Goods>();
		name=new JTextField(12);
		mount=new JTextField(12);
		price=new JTextField(12);
		button=new JButton("录入");
		button.addActionListener(this);
		box1=Box.createVerticalBox();
		box1.add(new JLabel("输入名称"));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("输入库存"));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("输入单价"));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("点击录入"));
		box2=Box.createVerticalBox();
		box2.add(name);
		box2.add(Box.createVerticalStrut(8));
		box2.add(mount);
		box2.add(Box.createVerticalStrut(8));
		box2.add(price);
		box2.add(Box.createVerticalStrut(8));
		box2.add(button);
		baseBox=Box.createHorizontalBox();
		baseBox.add(box1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(box2);
		add(baseBox);				
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == button)
		{
			JOptionPane.showMessageDialog(this,"录入成功");
		}
		
		if(f.exists()){
			try{
				FileInputStream fis=new FileInputStream(f);				
				ObjectInputStream ois=new ObjectInputStream(fis);				
				goodsList=(LinkedList<Goods>)ois.readObject();				
				fis.close();
				ois.close();
				Goods goods = new Goods();
				goods.setName(name.getText());
				goods.setMount(mount.getText());
				goods.setPrice(price.getText());
				goodsList.add(goods);
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(goodsList);
				oos.close();
	
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			try {
				f.createNewFile();
				Goods goods =new Goods();
				goods.setName(name.getText());
				goods.setMount(mount.getText());
				goods.setPrice(price.getText());
				goodsList.add(goods);
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(goodsList);
				oos.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
	}

}
