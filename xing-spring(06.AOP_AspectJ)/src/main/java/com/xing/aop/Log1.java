package com.xing.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Log1 implements MethodBeforeAdvice {
//    method 执行的方法
//    objects 参数
//    o target 目标对象
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName()+" 类执行了"+method.getName()+"方法，前置日志");
    }
}
