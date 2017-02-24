package com.code2016.design.creational.prototype;

/**
 * @Description: 原型模式
 * 原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，
 * 该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。
 * 简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class Prototype implements Cloneable {
	@Override
	public Object clone() throws CloneNotSupportedException {  
        Prototype proto = (Prototype) super.clone();  
        return proto;  
    }
}
