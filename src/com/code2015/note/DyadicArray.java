package com.code2015.note;

import java.util.Vector;


/**
 * @Description: 二维数组
 * @author wutp 2016年10月2日
 * @version 1.0
 */
public class DyadicArray {

	/**
	 *@Description:
	 *@param args
	 *@return void
	 */
	public static void main(String[] args) {
		
		String [][]ss=new String[2][2];
		ss[0][0]="aa";
		ss[0][1]="bb";
		ss[1][0]="cc";
		ss[1][1]="dd";
		
		for(int i=0;i<ss.length;i++){
			for(int m=0;m<ss[i].length;m++){
				System.out.println(ss[i][m]);
			}
			
		}
		

	}

}
