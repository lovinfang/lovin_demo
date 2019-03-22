/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.util.validator;

import com.processTemplate.enums.ErrorCodeEnum;
import com.processTemplate.enums.EventCodeEnum;
import com.processTemplate.exception.BsnException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * 通用的参数校验器，包装异常信息，统一返回{@link BsnException}异常
 *
 * @author wb-fyw404615
 * @version $Id: ParametorValidator.java, v 0.1 2019年03月22日 14:49 wb-fyw404615 Exp $
 */
public class ParametorValidator {

    private final static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private final static Validator validator = factory.getValidator();


    public static <T> void  validate(T object){
        if (object == null){
            throw new BsnException(EventCodeEnum.GENERAL_ACTION, ErrorCodeEnum.PARAMETER_ILLEGAL, "参数对象为空");
        }

        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (CollectionUtils.isEmpty(violations)){
            return;
        }

        StringBuilder sb = new StringBuilder();
        Iterator<ConstraintViolation<T>> it = violations.iterator();
        while(it.hasNext()){
            sb.append(it.next().getMessage()).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        throw new BsnException(EventCodeEnum.GENERAL_ACTION, ErrorCodeEnum.PARAMETER_ILLEGAL, sb.toString());
    }

    public static void checkArgument(boolean expression, String errorMessage) {
        checkArgument(expression, EventCodeEnum.GENERAL_ACTION, ErrorCodeEnum.PARAMETER_ILLEGAL, errorMessage);
    }

    public static void checkArgument(boolean expression, EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage) {
        if (!expression) {
            throw new BsnException(eventCode, errorCode, errorMessage);
        }
    }

    public static void checkArgument(boolean expression, EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage,
                                     Object... errorArgs) {
        if (!expression) {
            throw new BsnException(eventCode, errorCode, MessageFormatter.arrayFormat(errorMessage, errorArgs).getMessage());
        }
    }

    /**
     * 校验字符串是否为空
     * @param str
     * @param errorMessage
     */
    public static void checkStringNotBlank(String str, String errorMessage) {
        checkArgument(StringUtils.isNotBlank(str), EventCodeEnum.GENERAL_ACTION, ErrorCodeEnum.PARAMETER_ILLEGAL, errorMessage);
    }

    /**
     * 校验字符串是否为空
     * @param str
     * @param eventCode
     * @param errorCode
     * @param errorMessage
     */
    public static void checkStringNotBlank(String str, EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage) {
        checkArgument(StringUtils.isNotBlank(str), eventCode, errorCode, errorMessage);
    }

    /**
     *校验字符串是否为空
     * @param str
     * @param eventCode
     * @param errorCode
     * @param errorMessage
     * @param errorArgs
     */
    public static void checkStringNotBlank(String str, EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage,
                                           Object... errorArgs) {
        checkArgument(StringUtils.isNotBlank(str), eventCode, errorCode, errorMessage, errorArgs);
    }

    public static <T> T checkNotNull(T reference, String errorMessage) {
        if (reference == null) {
            throw new BsnException(EventCodeEnum.GENERAL_ACTION, ErrorCodeEnum.NULL_ERROR, errorMessage);
        }
        return reference;
    }

    public static <T> T checkNotNull(T reference, EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage) {
        if (reference == null) {
            throw new BsnException(eventCode, errorCode, errorMessage);
        }
        return reference;
    }

    public static <T> T checkNotNull(T reference, EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage,
                                     Object... errorArgs) {
        if (reference == null) {
            throw new BsnException(eventCode, errorCode, MessageFormatter.arrayFormat(errorMessage, errorArgs).getMessage());
        }
        return reference;
    }

    public static <T> T checkNull(T reference, EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage, Object... errorArgs) {
        if (reference != null) {
            throw new BsnException(eventCode, errorCode, MessageFormatter.arrayFormat(errorMessage, errorArgs).getMessage());
        }
        return reference;
    }

    public static void assertTrue(boolean expression, EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage,
                                  Object... errorArgs) {
        if (!expression) {
            throw new BsnException(eventCode, errorCode, MessageFormatter.arrayFormat(errorMessage, errorArgs).getMessage());
        }
    }

    /**
     * 判断是否相等，不相等抛出
     * @param o1
     * @param o2
     * @param eventCode
     * @param errorCode
     * @param errorMessage
     * @param errorArgs
     */
    public static void checkEquals(Object o1, Object o2, EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage,
                                   Object... errorArgs) {
        if (null == o1 && null == o2) {
            return;
        }
        if (null == o1 && null != o2) {
            throw new BsnException(eventCode, errorCode, MessageFormatter.arrayFormat(errorMessage, errorArgs).getMessage());
        }
        if (!o1.equals(o2)) {
            throw new BsnException(eventCode, errorCode, MessageFormatter.arrayFormat(errorMessage, errorArgs).getMessage());
        }
    }

}