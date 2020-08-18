package com.xing.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Data
@Component
public class User {
    @Value("1")
    private int id;

    @Value("admin")
    private String username;

    @Value("hehehe")
    private String password;

    @Nullable
    @Autowired
    @Qualifier("address")
    private Address address;

    @Resource
    private Hobby hobby;
}
