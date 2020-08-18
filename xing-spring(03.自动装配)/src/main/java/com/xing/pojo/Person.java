package com.xing.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Data
@Service
public class Person {
    @Value("星")
    private String name;

    @Autowired
    private Cat cat;

    @Resource
    private Dog dog;
}
