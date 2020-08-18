package com.xing.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class JsonUtils {
    public static String getJson(Object object) throws JsonProcessingException {
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object, String sdf) throws JsonProcessingException {
//        1. 声明mapper对象,操作json
        ObjectMapper mapper = new ObjectMapper();

//       2.  不使用jackSon的默认时间格式化格式
        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);

//        3.   设置mapper的DataFormat格式
        mapper.setDateFormat(new SimpleDateFormat(sdf));
//        4. 将对象格式化为json并返回
        return mapper.writeValueAsString(object);
    }


}
