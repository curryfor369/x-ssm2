# 0. SSM整合流程

## 1. 新建maven项目,导入依赖

## 2. 添加web框架支持,将lib依赖添加到lib里![](D:\user\Desktop\冉辰星总结\97-ssm\ssm整合.assets\20200818152556.gif)

## 3. 修改web.xml

## 4. 新建包 

​		pojo  dao service controller config 

​		db.properties  log4j.properties

## 5. 配置mybatis-config.xml

## 6. 配置applicationContext.xml

## 7. 配置 spring-dao -service -mvc



# 1. pom.xml

```xml
   <dependencies>
        <!-- servlet,jsp,jstl-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <!--        mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <!--        c3p0-->
        <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.5.4</version>
        </dependency>

        <!--        mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.3</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.2</version>
        </dependency>

        <!--        spring,springmvc,spring jdbc ,spring aop-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.1.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.4</version>
        </dependency>

        <!-- json, jackson, fastJson-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.11.2</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.73</version>
        </dependency>

        <!-- lombok,junit , log4j-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.10</version>
        </dependency>
         <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
    </dependencies>

    <!--在build中配置resources，防止我们资源导出失败的问题-->
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>

```

# 2. web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
<!--   1. dispatcherServlet
        2. 中文乱码
        3. session过期时间
-->
    <!--    dispatcherServlet中心处理器-->
    <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:applicationContext.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <!--    中文乱码过滤-->
    <filter>
        <filter-name>encoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter
        </filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encoding</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <!--    session超时-->
    <session-config>
        <session-timeout>15</session-timeout>
    </session-config>
</web-app>
```

# 3. spring-xml配置头

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xmlns:tx="http://www.springframework.org/schema/tx"
    xmlns:aop="http://www.springframework.org/schema/aop" 
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
        https://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">
```

# 4. mybatis-xml 配置头

```xml

<?xml version="1.0" encoding="UTF-8" ?><!DOCTYPE configuration
    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration></configuration>


<?xml version="1.0" encoding="UTF-8" ?><!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace=""></mapper>
```

# 5. log4j.properties

```properties
#将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
log4j.rootLogger=DEBUG,console,file

#控制台输出的相关设置
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%c]-%m%n

#文件输出的相关设置
#log4j.appender.file = org.apache.log4j.RollingFileAppender
#log4j.appender.file.File=./log/xing.log
#log4j.appender.file.MaxFileSize=10mb
#log4j.appender.file.Threshold=DEBUG
#log4j.appender.file.layout=org.apache.log4j.PatternLayout
#log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n

log4j.appender.file = org.apache.log4j.FileAppender
log4j.appender.file.File = ./logg/xxx.log
log4j.appender.file.Encoding=UTF-8
log4j.appender.file.name = fileLogDemo
log4j.appender.file.Threshold=DEBUG
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%-d{yyyy-MM-dd HH:mm:ss}[ %p ]%m%n
log4j.appender.file.append = true

#日志输出级别
log4j.logger.org.mybatis=DEBUG
log4j.logger.java.sql=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
```

# 6. db.properties

```properties
jdbc.url=jdbc:mysql://localhost:3306/ssmbuild?useSSL=false&serverTimezone=UTC&charset=utf8
jdbc.driver=com.mysql.jdbc.Driver
jdbc.username=root
jdbc.password=123123
```

# 7. mybatis-config

```xml
 	<!-- 导入文件-->
    <properties resource="db.properties"/>
    <!--    设置-->
    <settings>
        <!--  日志-->
        <setting name="logImpl" value="LOG4J" />
    </settings>

    <!-- 起别名-->
    <typeAliases>
        <package name="com.xing.pojo" />
    </typeAliases>

    <!-- 环境-->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC" />
            <dataSource type="POOLED">
                <property name="driver" value="${driver}" />
                <property name="url" value="${url}" />
                <property name="username" value="${username}" />
                <property name="password" value="${password}" />
            </dataSource>
        </environment>
    </environments>

    <!--映射文件-->
    <mappers>
        <!--  1. 通过资源路径-->
        <mapper resource="com/xing/mapper/UserMapper.xml" />
    </mappers>
```



# 8. applicationContext.xml

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
         http://www.springframework.org/schema/mvc
         https://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <import resource="classpath:spring-dao.xml"/>
    <import resource="classpath:spring-service.xml"/>
    <import resource="classpath:spring-mvc.xml"/>
</beans>
```



# 9. spring-dao.xml

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc" xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--    1. 关联数据库配置文件 -->
    <context:property-placeholder location="classpath:db.properties" />

    <!--    2. dataSource 连接池 C3P0 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}" />
        <property name="jdbcUrl" value="${jdbc.url}" />
        <property name="user" value="${jdbc.username}" />
        <property name="password" value="${jdbc.password}" />
        <!--       c3p0私有属性-->
        <property name="maxPoolSize" value="30" />
        <property name="minPoolSize" value="10" />
        <!--        关闭后不自动commit-->
        <property name="autoCommitOnClose" value="false" />
        <!--        获取连接超时时间-->
        <property name="checkoutTimeout" value="10000" />
        <!--        当前取连接失败重试次数-->
        <property name="acquireIncrement" value="2" />
    </bean>

    <!--    3. SqlSessionFactory -->
    <bean id="sqlSessionFactory"
        class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--        绑定mybatis文件-->
        <property name="configLocation" value="classpath:mybatis-config.xml" />
        <!--        关联ds-->
        <property name="dataSource" ref="dataSource" />

    </bean>
    <!--    4. 配置dao接口掃描包,动态实现了Dao接口注入Spring容器-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
        <property name="basePackage" value="com.xing.dao" />
    </bean>
</beans>
```



# 10. spring-service.xml

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xmlns:tx="http://www.springframework.org/schema/tx"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
        https://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">
    <!--    1. 扫描service下的包-->
    <context:component-scan base-package="com.xing.service" />
    <!--    2. 将所有业务类,注册到Spriing-->
    <bean id="booksServiceImpl" class="com.xing.service.BooksServiceImpl">
        <!-- 注入属性-->
        <property name="booksMapper" ref="booksMapper" />
    </bean>
    <!--    3. 声明式事务配置
               1. 注册事务对象
               2. 配置事务通知
               3. 配置AOP，将事务通知作为aop通知
    -->
    <!--    注册事务对象-->
    <bean id="transactionManager"
        class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>

    <!--    配置事务通知-->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <!--  配置那些方法使用什么样的事务-->
            <tx:method name="query" read-only="true" />
            <tx:method name="*" propagation="REQUIRED" />
        </tx:attributes>
    </tx:advice>

    <!--    配置aop-->
    <!-- 注解支持-->
    <aop:aspectj-autoproxy />
    <aop:config>
        <aop:pointcut id="pointcut"
            expression="execution(* com.xing.mapper..*(..))" />
        <aop:advisor advice-ref="txAdvice" pointcut-ref="pointcut" />
    </aop:config>
</beans>
```



# 11. spring-mvc.xml

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
         http://www.springframework.org/schema/mvc
         https://www.springframework.org/schema/mvc/spring-mvc.xsd">
    <!-- 1. 注解驱动-->
    <mvc:annotation-driven />
    <!-- 2. 静态资源过滤-->
    <mvc:default-servlet-handler />
    <!-- 3. 扫描包-->
    <context:component-scan base-package="com.xing.controller" />
    <!-- 4. 视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/" />
        <property name="suffix" value=".jsp" />
    </bean>
    <!--    5. json中文乱码-->
    <mvc:annotation-driven>
        <mvc:message-converters register-defaults="true">
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <constructor-arg value="UTF-8" />
            </bean>
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                <property name="objectMapper">
                    <bean class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                        <property name="failOnEmptyBeans" value="false" />
                    </bean>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
    <!--    6. 拦截器-->
    <!--    拦截器: interceptor: 只对controller层拦截-->
    <mvc:interceptors>
        <mvc:interceptor>
            <!-- 拦截所有controller的请求-->
            <mvc:mapping path="/**" />
            <!-- 自定义拦截器的类-->
            <bean class="com.xing.config.MyInterceptor" />
        </mvc:interceptor>
    </mvc:interceptors>
</beans>
```

# 12. 常用注解

>
>
>@Component @Repository @Service @Controller @AspectJ
>
>---
>
>@RestController 
>
>@ResponseBody
>
>@RequestMapping("/findAll/{name}")
>
>@RequestParam("username")
>
>@PathVariable String username
>
>---
>
>@Configuration 
>
>@Import(MyConfig2.class)  
>
>@ComponentScan("com.xing")
>
>---
>
>@Autowired  
>
>@Qualifier("userServiceImpl")

# 13. lombok的使用

```java
// 1. 导入lombok的依赖,idea支持lombok插件

package com.xing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
```

# 14. 注解aop的使用

```java
// 1. 开启注解支持
<aop:aspectj-autoproxy />
    
// 2. 写aop类
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

```

# 15. mybatis的使用

- 增删改查
- 多对一[对象],一对多[集合]
- 动态SQL

## 1. 增删改查

```xml
<?xml version="1.0" encoding="UTF-8" ?><!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.xing.dao.ProviderMapper">
    
    <!--    //查找所有供应商-->
    <select id="selectList" resultType="Provider">
        select * from smbms_provider
    </select>
    <!-- SQL片段-->
    <sql id="if-proCode-proName">
        <if test="proCode != null and proCode != ''">
            proCode = #{proCode}
        </if>
        <if test="proName != null and proName !='' ">
            or proName = #{proName}
        </if>
    </sql>

    <!--    //根据条件查询所有订单进行分页显示 selectByCondition
               通过代号/名字  页码/页码size 进行limit
      -->
    <select id="selectByCondition" resultType="Provider">
        select * from smbms_provider
        <where>
            <include refid="if-proCode-proName"></include>
        </where>
        limit #{pageNo},#{pageSize}
    </select>
    
    <!--    根据条件查找所有供应商数量selectCountByCondition-->
    <select id="selectCountByCondition" resultType="int">
        select count(*) from smbms_provider
        <where>
            <include refid="if-proCode-proName"></include>
        </where>
    </select>

	<!--    添加供应商 insert-->
    <insert id="insert" parameterType="Provider">
        insert into smbms_provider (proCode,proName,creationDate) 
        values (#{proCode},#{proName},#{creationDate});
    </insert>
    
	<!--    根据id查找供应商信息 selectProviderById-->
    <select id="selectProviderById" resultType="Provider">
        select * from smbms_provider where id = #{id}
    </select>
    
	<!--    修改供应商 updateProvider-->
    <update id="updateProvider" parameterType="Provider">
        update  smbms_provider
            <set>
                <if test="proCode != null and proCode !='' ">
                    proCode = #{proCode} ,
                </if>
                <if test="proName != null and proName !='' ">
                    proName = #{proName} ,
                </if>
                <if test="proDesc != null and proDesc !='' ">
                    proDesc = #{proDesc} ,
                </if>
                <if test="proContact != null and proContact !='' ">
                    proContact = #{proContact} ,
                </if>
                <if test="proAddress != null and proAddress !='' ">
                    proAddress = #{proAddress} ,
                </if>
                <if test="proFax != null and proFax !='' ">
                    proFax = #{proFax} ,
                </if>
                <if test="modifyBy != null ">
                    createdBy = #{modifyBy} ,
                </if>
                <if test="modifyDate != null">
                    modifyDate = #{modifyDate} ,
                </if>
            </set>
        where id = #{id}

    </update>

<!--   删除供应商 deleteProvider-->
    <delete id="deleteProvider">
        delete from smbms_provider where  id = #{id}
    </delete>
</mapper>
```



## 2. 多对一

```xml
<?xml version="1.0" encoding="UTF-8" ?><!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.xing.dao.StudentMapper">
    <!--    第一种： 多对一 关联查询-->
    <select id="getStudentList" resultMap="studentTeacher">
        select
            s.id sid,
            s.name sname,
            t.name tname
        from
            student s,
            teacher t
        where s.tid = t.id
    </select>

    <resultMap id="studentTeacher" type="Student">
        <result property="id" column="sid"></result>
        <result property="name" column="sname"></result>
        <association property="teacher" javaType="Teacher">
            <result property="name" column="tname"></result>
        </association>
    </resultMap>
</mapper>
```



## 3. 一对多

```xml
<?xml version="1.0" encoding="UTF-8" ?><!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.xing.dao.TeacherMapper">
    <!--    第一种： 一对多 关联查询-->
    <select id="getTeacherStus2" resultMap="ts">
        select
            t.id tid,
            t.name tname,
            s.id sid,
            s.name sname
        from
            teacher t,
            student s
        where
            t.id = #{tid} and
            s.tid = #{tid}

    </select>

    <resultMap id="ts" type="Teacher">
        <result property="id" column="tid"></result>
        <result property="name" column="tname"></result>
        <collection property="students" javaType="ArrayList" ofType="Student">
            <result property="id" column="sid"></result>
            <result property="name" column="sname"></result>
            <result property="tid" column="tid"></result>
        </collection>
    </resultMap>

    <!--    第二种 一对多：子查询-->
    <select id="getTeacherStus" resultMap="ts2">
        select * from teacher where id = #{tid}
    </select>

    <resultMap id="ts2" type="Teacher">
        <result property="id" column="id"></result>
        <result property="name" column="name"></result>
        <collection property="students" javaType="ArrayList" ofType="Student"
            column="id" select="getSsByTid"/>
    </resultMap>

    <select id="getSsByTid" resultType="Student">
        select * from student where tid = #{id}
    </select>
</mapper>
```



## 4. 动态SQL

```xml
<?xml version="1.0" encoding="UTF-8" ?><!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.xing.dao.BlogMapper">
    <!--    插入：测试-->
    <insert id="addBlog" parameterType="Blog">
        insert into blog(id,title,author,create_time,views) 
        values (#{id},#{title},#{author},#{createTime},#{views})
    </insert>
    
    <!--    根据条件查询 if where-->
    <select id="getBlogList" resultType="Blog" parameterType="map">
        select * from blog
        <where>
            <if test="title != null">
                and title like "%" #{title} "%"
            </if>
            <if test="author != null">
                and author like "%" #{author} "%"
            </if>
        </where>
    </select>
    <!--    根据条件查询 choose when otherwise-->
    <select id="getBlogListChoose" resultType="Blog" parameterType="map">
        select * from blog
        <where>
            <choose>
                <when test="title != null">
                    title = #{title}
                </when>
                <when test="title != null and author != null">
                    and title = #{title} and author = #{author}
                </when>
                <otherwise>
                    views > 600
                </otherwise>
            </choose>
        </where>
    </select>

    <!--    更新 set-->
    <update id="updateBlog" parameterType="map">
        update blog
        <set>
            <include refid="if-1"></include>
        </set>
        where id = #{id}
    </update>
    <!--    sql片段-->
    <sql id="if-1">
        <if test="title != null">
            title = #{title},
        </if>
        <if test="author != null">
            author = #{author},
        </if>
        <if test="views != null">
            views = #{views}
        </if>
    </sql>

    <!--    查询： 通过 foreach拼接
        select * from blog where views in ( 888,777);
    -->
    <select id="getBlogListForeach" parameterType="map" resultType="Blog">
        select * from blog
        <where>
            <foreach collection="views" item="view" open="views in (" separator="," close=")">
                #{view}
            </foreach>
        </where>

    </select>
</mapper>
```

