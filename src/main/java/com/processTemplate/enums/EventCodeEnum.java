/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.enums;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author lovin
 * @version $Id: EventCodeEnum.java, v 0.1 2019年03月22日 9:52 lovin Exp $
 */
public enum EventCodeEnum {

    GENERAL_ACTION("9999", "通用操作");

    /**
     * 事件码头四位
     */
    private final static String EVENT_CODE_PRE = "2335";

    /**
     * 错误编码
     */
    private final String code;

    /**
     * 描述说明
     */
    private final String description;

    /**
     * 构造函数
     *
     * @param code
     * @param description
     */
    private EventCodeEnum(String code, String description) {

        this.code = EVENT_CODE_PRE + code;
        this.description = description;
    }

    /**
     * 根据事件码获取对应的枚举对象
     *
     * @param eventCode
     * @return
     */
    public static EventCodeEnum translateByEventCode(String eventCode) {
        for (EventCodeEnum e : EventCodeEnum.values()) {
            if (StringUtils.equals(e.code, eventCode)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 所有枚举实现该方法，返回对应枚举实例的编号。
     *
     * @return enum.code
     */
    public String getCode() {
        return code;
    }

    /**
     * 所有枚举类实现该方法，返回对应枚举实例的英文名称。
     *
     * @return enum.englishName
     */
    public String getEnglishName() {
        return code;
    }

    /**
     * 所有枚举类实现该方法，返回对应枚举实例的中文名称。
     *
     * @return enum.chineseName
     */
    public String getChineseName() {
        return description;
    }

    /**
     * 所有枚举类实现该方法，返回对应枚举实例的描述。
     *
     * @return enum.description
     */
    public String getDescription() {
        return description;
    }
}