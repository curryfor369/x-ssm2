1. xml里通过autowired自动装配
    - byName
    - byType

2. 使用注解
     开启注解  <context:annotation-config/>
     
3. 常用注解
    - autowired  通过byName自动匹配
    - resource (name="") 通过byName自动匹配，若匹配不到，则byType
    - nullabld  可以为Null
    - qualifier 唯一指定
    - required=false 找不到可以不报错 