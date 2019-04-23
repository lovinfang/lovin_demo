/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * JSON Utils 工具类
 *
 * @author lovin
 * @version $Id: FastjsonUtil.java, v 0.1 2019年03月25日 16:56 lovin Exp $
 */
public class FastjsonUtil {

    /**
     * 将对象序列化为Json串, 对象为空则返回null. 否则返回序列化后的对象. 需要确保数据库字段可为空.
     *
     * @param object
     * @param <T>
     * @return String or Null
     */
    public static <T> String toJson(T object) {
        return (object != null) ? JSON.toJSONString(object, SerializerFeature.SortField,
                SerializerFeature.SkipTransientField) : null;
    }

    /**
     * 将对象序列化为Json对象, 对象为空则返回null. 否则返回序列化后的对象. 需要确保数据库字段可为空.
     *
     * @param object
     * @return String or Null
     */
    public static JSONObject toJsonObject(Map<String, Object> object) {
        return (object != null) ? (JSONObject) JSON.toJSON(object) : new JSONObject();
    }

    /**
     * 将一个对象合并到一个JSON Object对象中去. 需要确保数据库字段可为空.
     *
     * @param object
     * @return String or Null
     */
    public static JSONObject combine(JSONObject jsonObject, String key, Object object) {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        jsonObject.put(key, object);
        return jsonObject;
    }

    /**
     * 反序列化字符串为Java对象. 如果是空字符串则返回null.
     *
     * @param jsonStr
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String jsonStr, TypeReference<T> typeReference) {
        return StringUtils.isBlank(jsonStr) ? null : JSON.parseObject(jsonStr, typeReference);
    }

    /**
     * 反序列化字符串为Java对象. 如果是空字符串则返回null.
     *
     * @param jsonStr
     * @param <T>
     * @return
     */
    public static <T> T getObjectFromJson(String jsonStr, String key, Class<T> clazz) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        return JSON.parseObject(jsonStr).getObject(key, clazz);

    }

    /**
     * 判断一个Json String 是不是一个基于Map的String.
     *
     * @param jsonStr
     * @return
     */
    public static boolean isJsonMap(String jsonStr) {
        return (StringUtils.isNotBlank(jsonStr) && jsonStr.length() >= 2 && jsonStr.startsWith("{") && jsonStr
                .endsWith("}"));
    }

    /**
     * 将一个json数组转换成对应的Object 集合
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> strToListJsonObject(String str, Class<T> clazz){
        List<T> jsonArray = JSON.parseArray(str,clazz);
        return jsonArray;
    }
}