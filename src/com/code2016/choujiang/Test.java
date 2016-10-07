package com.code2016.choujiang;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 简单抽奖
 * @author wutp 2016年10月4日
 * @version 1.0
 */
public class Test {

	
	public static void main(String[] args) {
        double baseNum = 0.99;
        String product = "矿泉水,打火机,雨伞,指甲刀";
        String num = "2,2,2,1";
        String[] p = product.split(",");
        String[] n = num.split(",");
 
        java.util.Random ran = new java.util.Random();
        double base = ran.nextDouble();
 
        if (base > baseNum) {
            System.err.println("没中奖");
            return;
        }
 
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < Integer.parseInt(n[i]); j++) {
                list.add(p[i]);
            }
        }
                //TODO 打乱奖池数据
        int l = ran.nextInt(list.size());
        System.err.println(list.get(l));
 
    }

}
