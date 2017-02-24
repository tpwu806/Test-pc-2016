package com.code2016.design.structural.composite;

import java.util.Enumeration;

/**
 * @Description: 组合模式
 * 组合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便
 * 将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等。
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class Tree {
	TreeNode root = null;  
	  
    public Tree(String name) {  
        root = new TreeNode(name);  
    }  
  
    public static void main(String[] args) {  
        Tree tree = new Tree("A");  
        TreeNode nodeB = new TreeNode("B");  
        TreeNode nodeC = new TreeNode("C");  
          
        nodeB.add(nodeC);  
        tree.root.add(nodeB);  
               
        System.out.println("build the tree finished!"); 
        
        Enumeration<TreeNode> childrens = tree.root.getChildren();
        while(childrens.hasMoreElements()){
        	TreeNode t = childrens.nextElement();
        	System.out.println(t.getName());
        }
    } 
}
