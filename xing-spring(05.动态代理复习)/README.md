1.  动态代理主要有两个东西
    1. Proxy类
        - Proxy提供了创建动态代理类和实例的静态方法，它也是由这些方法创建的所有动态代理类的超类。
    
    2.  代理类实现 InvocationHandler 接口，实现invoke方法
        - InvocationHandler是由代理实例调用处理程序实现的接口 
