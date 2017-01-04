package com.code2015.pub;

import java.util.StringTokenizer;
import java.util.Vector;

/**
 * @Description:  截取字符串
 * @author: wutp 
 * @time: 2016-9-21上午8:21:09
 * @version: 1.0
 */
public class StringTokenizerDemo {

	/**
	 * 截取字符串
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] stringArrays=getStringByToken("helloworld","o");
		for(int i=0;i<stringArrays.length;i++){
			System.out.println(stringArrays[i]);
		}
		

	}

	public static String[] getStringByToken(String str, String token) {
        Vector<String> SList = new Vector<String>();
        String Tmp;
        StringTokenizer st = new StringTokenizer(str.trim(), token);
        while (st.hasMoreTokens()) {
            Tmp = st.nextToken();
            SList.add(Tmp);
        }
        String[] stringArray = new String[SList.size()];
        for (int i = 0; i < SList.size(); i++) {
            stringArray[i] = (String) (SList.elementAt(i));
        }
        return stringArray;
	}
}
