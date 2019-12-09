/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.enums;

import com.processTemplate.constant.ErrorLevels;
import com.processTemplate.constant.ErrorTypes;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author lovin
 * @version $Id: ErrorCodeEnum.java, v 0.1 2019年03月22日 9:55 lovin Exp $
 */
public enum ErrorCodeEnum {

    /**
     * 参数异常
     */
    PARAMETER_ILLEGAL("100", ErrorLevels.ERROR, ErrorTypes.BIZ, "参数非法"),

    /**
     * 空指针异常
     */
    NULL_ERROR("003", ErrorLevels.ERROR, ErrorTypes.BIZ, "空指针异常"),

    /**
     * 未知异常
     */
    UN_KNOWN_EXCEPTION("000", ErrorLevels.ERROR, ErrorTypes.SYSTEM, "未知错误");

    /**
     * 错误编码
     */
    private final String code;

    /**
     * 错误级别
     */
    private final String levels;

    /**
     * 错误类型
     */
    private final String type;

    /**
     * 描述说明
     */
    private final String description;

    /**
     * 构造函数
     *
     * @param code
     * @param levels
     * @param type
     * @param description
     */
    private ErrorCodeEnum(String code, String levels, String type, String description) {

        this.code = code;
        this.levels = levels;
        this.type = type;
        this.description = description;
    }

    /**
     * @param enumName
     * @return
     */
    public static ErrorCodeEnum translateByName(String enumName) {

        for (ErrorCodeEnum e : values()) {
            if (StringUtils.equals(enumName, e.name())) {
                return e;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getEnglishName() {
        return code;
    }

    public String getChineseName() {
        return description;
    }

    public String getLevels() {
        return levels;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}