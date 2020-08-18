package com.xing.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class Log2 implements AfterReturningAdvice  {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println(o1.getClass().getName()+"类的"+method.getName()+"方法执行了--"+"后置日志");
    }
}
