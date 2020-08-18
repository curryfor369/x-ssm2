package com.xing.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("singleton")
public class Dog {
    public void shout(){
        System.out.println("汪汪~");
    }
}
