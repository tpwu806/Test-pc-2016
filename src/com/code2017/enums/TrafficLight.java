package com.code2017.enums;

/**
 * @Description: 用法二：switch
 * @author wutp 2017年2月24日
 * @version 1.0
 */
public class TrafficLight {
	Color color = Color.RED;  
    public void change() {  
        switch (color) {  
        case RED:  
            color = Color.GREEN;  
            break;  
        case YELLOW:  
            color = Color.RED;  
            break;  
        case GREEN:  
            color = Color.YELLOW;  
            break;  
        }  
    }  
}
