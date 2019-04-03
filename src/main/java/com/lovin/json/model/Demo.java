/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.json.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @version $Id: Demo.java, v 0.1 2019年03月01日 9:35 lovin Exp $
 */
public class Demo {

    public static void main(String[] args) {

        Map<String,String> map1 = new HashMap<>();
        map1.put("alipay","www.alipay.com");
        map1.put("mkbank","www.mkbank.com");

        Object o = JSONObject.toJSON(map1);
        System.out.println(o.toString());

        Map<String,String> map2 = new HashMap<>();
        map2.put("pageName","www.pageName.com");
        map2.put("address","http://www.alipay.com");
        map2.put("chWhiteList","11111111");

        Object o2 = JSONObject.toJSON(map2);
        System.out.println(o2.toString());

        Map<String,String> map3 = new HashMap<>();
        map3.put("recmd_index_page",o.toString());
        map3.put("recmd_action_page",o2.toString());

        Object o3 = JSONObject.toJSON(map3);
        System.out.println(o3.toString());

        String jsonStr = "{\"chWhiteList\":\"11111111\",\"pageName\":\"www.pageName.com\",\"address\":\"http://www.alipay.com\"}";
        Map<String,String> map = (Map<String, String>) JSON.parse(jsonStr);
        map.forEach((key,value) -> {
            System.out.println(key+":"+value);
        });
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","value");
        System.out.println(jsonObject.toJSONString());

        System.out.println("-------------------");
        Map<String,String> ddd = new HashMap<>();
        if (ddd.isEmpty()){
            System.out.println("empty");
        }
    }
}