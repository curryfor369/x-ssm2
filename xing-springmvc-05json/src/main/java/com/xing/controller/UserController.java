package com.xing.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.xing.pojo.User;
import com.xing.utils.JsonUtils;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class UserController {

    //  将List集合格式化为json
    @RequestMapping("/user/j")
    @ResponseBody
    public String test1() throws JsonProcessingException {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"xing1",11));
        users.add(new User(2,"xing2",22));
        users.add(new User(3,"xing3",13));
        users.add(new User(4,"xing4",15));
        /*
         [{"id":1,"name":"xing1","age":11},
             {"id":2,"name":"xing2","age":22},
             {"id":3,"name":"xing3","age":13},
             {"id":4,"name":"xing4","age":15}]
         */
       return JsonUtils.getJson(users);

    }

    // 时间格式
    @Test
    public void testDate() throws JsonProcessingException {
        System.out.println(JsonUtils.getJson(new Date()));//"2020-08-17 15:35:38"
    }

    // fastJson
    @Test
    public void testFastJson()  {
        ArrayList<User> users = new ArrayList<>();
        User xing1 = new User(1, "xing1", 11);
        User xing2 = new User(1, "xing2", 11);
        User xing3 = new User(1, "xing3", 11);
        users.add(xing1);
        users.add(xing2);
        users.add(xing3);
        // 对象 => json
        String s1 = JSON.toJSONString(xing1);
        System.out.println(s1);

        // 集合 => json
        String s2 = JSON.toJSONString(users);
        System.out.println(s2);

        // java => json
        JSONObject o = (JSONObject) JSON.toJSON(xing1);
        System.out.println(o);
        // json => list
        User user = JSON.toJavaObject(o, User.class);
        System.out.println(user);

    }
}
