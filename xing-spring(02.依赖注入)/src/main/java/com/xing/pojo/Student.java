package com.xing.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
public class Student {

    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbys;
    private Map<String, String> card;
    private Set<String> games;
    private String wife;
    private Properties info;

    public void show() {
        System.out.println("name=" + name + ",address=" + address.getAddress() + ",books=");
        for (String book : books) {
            System.out.print("<<" + book + ">>\t");
        }
        System.out.println("\n爱好:" + hobbys);
        System.out.println("card:" + card);
        System.out.println("games:" + games);
        System.out.println("wife:" + wife);
        System.out.println("info:" + info);
    }
}
