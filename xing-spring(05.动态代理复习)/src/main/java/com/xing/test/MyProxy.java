package com.xing.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {

    //    要代理的目标对象
    private Object target;

    // 设置要代理的目标对象
    public void setTarget(Object target) {
        this.target = target;
    }

    // 生成代理类实例
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

    }

    //    代理类调用方法时自动调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        return invoke;
    }


}
