/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.enums;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author wb-fyw404615
 * @version $Id: YesNoEnum.java, v 0.1 2019年03月27日 16:18 wb-fyw404615 Exp $
 */
public enum YesNoEnum {
    /**
     * 是/否枚举
     */
    YES("Y", "1", "是", "true"),

    /**
     * 否
     */
    NO("N", "0", "否", "false"),

    ;

    private YesNoEnum(String code, String intCode, String desc, String bool) {
        this.code = code;
        this.intCode = intCode;
        this.desc = desc;
        this.bool = bool;
    }

    private String code;

    private String intCode;

    private String desc;

    private String bool;

    public static YesNoEnum translateByCode(String code) {
        for (YesNoEnum state : values()) {
            if (StringUtils.equals(state.getCode(), code)) {
                return state;
            }
        }
        return null;
    }

    public static YesNoEnum translateByBool(Boolean bool) {
        if (bool == null) {
            throw new IllegalArgumentException("input value must not be null");
        }

        if (bool) {
            return YES;
        }
        return NO;
    }

    public Boolean getBoolValue() {
        YesNoEnum yesNo = translateByCode(code);
        if (yesNo == null) {
            throw new IllegalArgumentException("code " + code + " is not YesNoEnum.code type");
        }
        if (YesNoEnum.YES == yesNo) {
            return true;
        }
        if (YesNoEnum.NO == yesNo) {
            return false;
        }

        throw new IllegalArgumentException("code " + code + " is not YesNoEnum.code type");
    }


    public String getCode() {
        return code;
    }

    public String getEnglishName() {
        return code;
    }

    public String getChineseName() {
        return desc;
    }

    public String getDescription() {
        return desc;
    }

    public String getIntCode() {
        return intCode;
    }

    public String getBool() {
        return bool;
    }
}