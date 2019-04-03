/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.model.vo;

import com.genericAndAnnotation.model.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 参数记录
 *
 * @author lovin
 * @version $Id: ParmRowVO.java, v 0.1 2019年03月27日 12:34 lovin Exp $
 */
public class ParmRowVO extends ToString implements Cloneable {

    private static final long   serialVersionUID = -4973706030857189303L;

    /**
     * 主键
     */
    private String              key;

    /** 数据 <条件别名，条件值> */
    private Map<String, String> data;

    /**
     * 工厂方法
     * @return
     */
    public static ParmRowVO newInstance() {
        ParmRowVO row = new ParmRowVO();
        row.setData(new HashMap<String, String>());
        return row;
    }

    /**
     * 工厂方法
     * @return
     */
    public static ParmRowVO newInstance(String key) {

        ParmRowVO row = ParmRowVO.newInstance();
        row.setKey(key);
        return row;
    }

    /**
     * 填入条件值
     * @param key
     * @param value
     */
    public void putValue(String key, String value) {

        if (data == null) {
            data = new HashMap<String, String>();
        }

        data.put(key, value);
    }

    /**
     * 填入条件值
     * @param values
     */
    public void putAllValue(Map<String, String> values) {

        if (data == null) {
            data = new HashMap<String, String>();
        }

        data.putAll(values);
    }

    /**
     * 获取条件值
     * @param key
     * @return
     */
    public String fetchValue(String key) {

        if (data == null) {
            return null;
        }
        return data.get(key);
    }

    /**
     * 获取条件值
     * @param key
     * @return
     */
    public String removeValue(String key) {

        if (data == null) {
            return null;
        }
        return data.remove(key);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ParmRowVO rowCopy = (ParmRowVO) super.clone();

        if (data != null) {
            rowCopy.data = new HashMap<String, String>();
            rowCopy.data.putAll(data);
        }

        return rowCopy;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}