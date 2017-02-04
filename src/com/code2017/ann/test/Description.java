package com.code2017.ann.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})//作用域
@Retention(RetentionPolicy.RUNTIME)//注解类型：运行时注解
@Inherited//可继承
@Documented//可以生成文档
public @interface Description {
	
	String value();
	
	//String author();
	
	//int age() default 18;

}
