package com.code2016.imooc.reflect;

public class MethodDemo3 {

	/**根据标准javaBean对象的属性名获取其属性值
	 * @param args
	 */
	public static void main(String[] args) {
		User u1 = new User("zhangsan", "123456", 30);
		System.out.println(JActiveFramework.InvokeObjectMethod(u1, "username"));
		System.out.println(JActiveFramework.InvokeObjectMethod(u1, "userpass"));
	}

}
