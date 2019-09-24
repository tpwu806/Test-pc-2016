package com.base.book.datadtructures.part4.MianDemo;

import com.base.book.datadtructures.part4.BinarySearchTree;

public class MainDemo {

	public static void main(String[] args) {
		BinarySearchTree<Integer> b=new BinarySearchTree<Integer>(); 
		b.insert(new Integer(5));
		b.insert(new Integer(4));
		b.insert(new Integer(7));
		//b.remove(new Integer(4));
		b.printTree();
		System.out.println(b.contains(new Integer(4)));
		
	}

}
