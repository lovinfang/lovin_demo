/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.exception;

import com.processTemplate.enums.ErrorCodeEnum;
import com.processTemplate.enums.EventCodeEnum;
import com.processTemplate.util.ErrorContext;

/**
 * 业务处理异常，抛出此异常都不可重试，如果需要告知上游可重试，请用{@link SysException}异常
 *
 * @author wb-fyw404615
 * @version $Id: BsnException.java, v 0.1 2019年03月22日 14:19 wb-fyw404615 Exp $
 */
public class BsnException extends SysException{

    /**
     * 默认创建一个错误上下文
     *
     * @param eventCode
     * @param errorCode
     * @param errorMessage
     */
    public BsnException(EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage) {
        super(eventCode, errorCode, errorMessage, false);
    }

    /**
     * @param eventCode
     * @param errorCode
     * @param errorMessage
     * @param throwable
     */
    public BsnException(EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage, Throwable throwable) {
        super(eventCode, errorCode, errorMessage, throwable, false);
    }

    /**
     * 把当前错误上下文加到已有的错误上下文中
     *
     * @param eventCode
     * @param errorCode
     * @param errorMessage
     * @param errorContext
     */
    public BsnException(EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage, ErrorContext errorContext) {
        super(eventCode, errorCode, errorMessage, errorContext, false);
    }
}