package com.reflect.aop.proxy;

import java.lang.reflect.Method;
 
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import com.reflect.aop.proxy.imp.AOPMethod;
import com.reflect.aop.proxy.imp.AnimalInterface;
 
@RunWith(BlockJUnit4ClassRunner.class)
public class AOPTest2 {
 
    public static void main(String[] args) {
 
        AnimalInterface dog = AnimalFactory.getAnimal(DogImp.class, new AOPMethod() {
            // 这里写方法执行前的AOP切入方法
            public void before(Object proxy, Method method, Object[] args) {
                System.err.println("我在" + method.getName() + "方法执行前执行");
            }
 
            // 这里系方法执行后的AOP切入方法
            public void after(Object proxy, Method method, Object[] args) {
                System.err.println("我在 " + method.getName() + "方法执行后执行");
 
            }
        });
        dog.say();
        String name1="我的名字是" + dog.getName();
        System.out.println(name1);
        dog.setName("二狗子");
        String name2="我的名字是"+dog.getName();
        System.out.println(name2);
    }
}
