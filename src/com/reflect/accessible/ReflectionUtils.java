package com.reflect.accessible;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的通用工具类
 */
public class ReflectionUtils {

	/**
	 * 用于对类的字段赋值，无视private,project修饰符,无视set/get方法
	 * 
	 * @param c
	 *            要反射的类
	 * @param args
	 *            类的字段名和值 每个字段名和值用英文逗号隔开
	 * @return
	 */
	public static Object fieldAccessible(Class<?> c, String... args) {
		try {
			Object object = Class.forName(c.getName()).newInstance();
			fieldAccessible(object,args);
			return object;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void fieldAccessible(Object object, String... args) {
		try {
			Class<?> obj = object.getClass();
			Field[] fields = obj.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				for (int j = 0; j < args.length; j++) {
					String str = args[j];
					String strs[] = str.split(",");
					if (strs[0].equals(fields[i].getName())) {
						fields[i].set(object, strs[1]);
						break;
					}
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static Object methodAccessible(Object object, String... args) {
		try {
			Class<?> cla = object.getClass();
			Method method =cla.getDeclaredMethod("setContent", new Class[]{String.class});
			method.setAccessible(true);
			method.invoke(object, new Object[]{"hhewwkh"});
			return object;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object constructorAccessible(Class c,String content) {
		try {
			Constructor constructor = c.getDeclaredConstructor(String.class);
			constructor.setAccessible(true);
			return constructor.newInstance(content);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
//		Object object = fieldAccessible(Smss.class, "destID,01201101", "mobile,15810022404", "content,测试数据。");
//		Smss sms = (Smss) object;
		
//		Smss sms = new Smss();
//		fieldAccessible(sms, "destID,01201101", "mobile,15810022404", "content,测试数据。");
		
//		Smss sms = new Smss();
//		Object object = methodAccessible(sms, "setContent", "测试数据");
		
		Smss sms = (Smss) constructorAccessible(Smss.class,"sjdkshd");
		
		System.out.println("短信内容：" + sms.getContent());
		System.out.println("手机号码：" + sms.getMobile());
		System.out.println("尾号：" + sms.getDestID());
	}
}