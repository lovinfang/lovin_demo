/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.util;

import com.alibaba.fastjson.JSON;
import com.genericAndAnnotation.annotation.ParamCondition;
import com.genericAndAnnotation.enums.YesNoEnum;
import com.genericAndAnnotation.model.ComparableParamModel;
import com.genericAndAnnotation.model.ParamModel;
import com.genericAndAnnotation.model.ParamQueryRequest;
import com.genericAndAnnotation.model.vo.ParmRowVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 *
 * @author wb-fyw404615
 * @version $Id: ParamConvertUtil.java, v 0.1 2019年03月27日 11:08 wb-fyw404615 Exp $
 */
public class ParamConvertUtil {

    public static <T extends ParamQueryRequest<?>> Map<String,String> convertRequest(T paramQueryRequest){
        Field[] allFields = paramQueryRequest.getClass().getDeclaredFields();
        Map<String,String> map =new HashMap<String,String>();
        for (Field field : allFields){
            ParamCondition  paramAliasName = field.getAnnotation(ParamCondition.class);
            if (paramAliasName == null){
                continue;
            }

            String aliasName = paramAliasName.value();
            ReflectionUtils.makeAccessible(field);
            Object object = ReflectionUtils.getField(field,paramQueryRequest);
            if (object != null){
                map.put(aliasName, object.toString());
            }
        }
        return map;
    }

    /**
     *
     *
     * @param parmRowVO
     * @param aliasName
     * @return
     */
    public static String getStringValue(ParmRowVO parmRowVO, String aliasName) {
        if (parmRowVO == null) {
            return null;
        }

        String condiVal = parmRowVO.fetchValue(aliasName);
        if (condiVal == null) {
            return null;
        }
        return StringUtils.trim(condiVal);
    }

    /**
     * string to list
     *
     * @param parmRowVO
     * @param aliasName
     * @return
     */
    public static List<String> getStringListValue(ParmRowVO parmRowVO, String aliasName) {
        String value = getStringValue(parmRowVO, aliasName);
        if (StringUtils.isBlank(value)) {
            return Collections.emptyList();
        }
        String[] strArr = StringUtils.split(value, ",");
        List<String> list = toList(strArr);
        return list;
    }

    /**
     * 生成list
     *
     * @param <T>
     * @param objs
     * @return
     */
    public static <T> List<T> toList(T... objs) {
        List<T> list = new ArrayList<T>();
        if (objs != null && objs.length > 0) {
            list.addAll(Arrays.asList(objs));
        }
        return list;
    }

    /**
     * string to boolean
     *
     * @param parmRowVO
     * @param aliasName
     * @return
     */
    public static Boolean getStringBooleanValue(ParmRowVO parmRowVO, String aliasName) {
        String value = getStringValue(parmRowVO, aliasName);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        YesNoEnum yon = YesNoEnum.translateByCode(value);
        return yon.getBoolValue();
    }

    /**
     * string to int
     *
     * @param parmRowVO
     * @param aliasName
     * @return
     */
    public static Integer getStringIntValue(ParmRowVO parmRowVO, String aliasName) {
        String value = getStringValue(parmRowVO, aliasName);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return Integer.parseInt(value);
    }

    /**
     * string json to Map
     *
     * @param parmRowVO
     * @param aliasName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> getStringMapValue(ParmRowVO parmRowVO, String aliasName) {
        String value = getStringValue(parmRowVO, aliasName);
        if (StringUtils.isBlank(value)) {
            return new HashMap<String,String>();
        }
        return JSON.parseObject(value,Map.class);
    }


    public static <T extends ParamModel> T convertResult(T resultInstance, ParmRowVO parmRowVO) throws Exception {
        if (resultInstance == null){
            throw new Exception("resultInstance is null");
        }
        Field[] allFields = resultInstance.getClass().getDeclaredFields();
        for (Field field : allFields){
            //条件
            ParamCondition paramCondition = field.getAnnotation(ParamCondition.class);
            if (paramCondition == null) {
                continue;
            }
            String aliasName = paramCondition.value();
            Class<?> clazz =field.getType();
            Object result = null;
            if (clazz.isAssignableFrom(String.class)){
                result = ParamConvertUtil.getStringValue(parmRowVO, aliasName);
            } else if (clazz.isAssignableFrom(List.class)) {
                result = ParamConvertUtil.getStringListValue(parmRowVO, aliasName);
            } else if (clazz.isAssignableFrom(Boolean.class)) {
                result = ParamConvertUtil.getStringBooleanValue(parmRowVO, aliasName);
            } else if (clazz.isAssignableFrom(Integer.class)) {
                result = ParamConvertUtil.getStringIntValue(parmRowVO, aliasName);
            } else if (clazz.isAssignableFrom(Map.class)) {
                result = ParamConvertUtil.getStringMapValue(parmRowVO, aliasName);
            } else {
                throw new IllegalAccessError();
            }
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, resultInstance, result);
        }

        if (resultInstance instanceof ComparableParamModel){
            Integer priority = ParamConvertUtil.getStringIntValue(parmRowVO, ComparableParamModel.PRIORITY);
            try{
                if (priority != null){
                    FieldUtils.writeField(resultInstance,ComparableParamModel.PRIORITY,priority,true);
                }

            }catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return resultInstance;
    }
}