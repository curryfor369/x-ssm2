package com.xing.utils;

import java.util.UUID;

public class IDUtils {
    public static String getId(){
      return UUID.randomUUID().toString().toString().replaceAll("-","");
    }
}
