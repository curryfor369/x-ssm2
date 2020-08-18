package com.xing.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Log4 {

    @Before("execution(* com.xing.dao..*(..))")
    public void before(){
        System.out.println("before");
    }

    @After("execution(* com.xing.dao..*(..))")
    public void after(){
        System.out.println("after");
    }

    @Around("execution(* com.xing.dao..*(..))")
    public void aroud(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("前置环绕");
        jp.proceed(); // 执行方法
        System.out.println("后置环绕");

        System.out.println(jp.getSignature());// 获取签名 void com.xing.dao.UserDao.add()
    }
}
