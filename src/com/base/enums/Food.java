package com.base.enums;

/**
 * @Description: 用法六：使用接口组织枚举
 * @author wutp 2017年2月24日
 * @version 1.0
 */
public interface Food {
	enum Coffee implements Food{  
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO  
    }  
    enum Dessert implements Food{  
        FRUIT, CAKE, GELATO  
    }  
}
