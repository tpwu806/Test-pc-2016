package com.code2016.design.behavioral.state;

/**
 * @Description: 状态模式
 * State类是个状态类，Context类可以实现切换
 * 根据这个特性，状态模式在日常开发中用的挺多的，尤其是做网站的时候，
 * 我们有时希望根据对象的某一属性，区别开他们的一些功能，比如说简单的权限控制等。
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class Test {
	public static void main(String[] args) {

		State state = new State();
		Context context = new Context(state);

		// 设置第一种状态
		state.setValue("state1");
		context.method();

		// 设置第二种状态
		state.setValue("state2");
		context.method();
	}
}
