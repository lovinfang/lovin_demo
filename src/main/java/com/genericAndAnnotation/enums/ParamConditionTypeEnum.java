/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @version $Id: ParamConditionTypeEnum.java, v 0.1 2019年03月27日 11:19 lovin Exp $
 */
public enum ParamConditionTypeEnum {

    TEXT("TEXT","字符型"),
    UNKNOWN("", "未知"),
    ;

    private ParamConditionTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ParamConditionTypeEnum translateByCode(String code) {
        for (ParamConditionTypeEnum state : values()) {
            if (StringUtils.equals(state.getCode(), code)) {
                return state;
            }
        }
        return UNKNOWN;
    }

    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public String getEnglishName() {
        return code;
    }

    public String getChineseName() {
        return desc;
    }

    public String getDesc() {
        return desc;
    }

}