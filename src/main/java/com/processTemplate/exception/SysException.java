/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.exception;

import com.processTemplate.enums.ErrorCodeEnum;
import com.processTemplate.enums.EventCodeEnum;
import com.processTemplate.util.ErrorContext;
import com.processTemplate.util.ErrorContextUtil;

/**
 * 系统异常
 * @author wb-fyw404615
 * @version $Id: SysException.java, v 0.1 2019年03月22日 14:18 wb-fyw404615 Exp $
 */
public class SysException extends RuntimeException {

    /**
     * 事件码
     */
    private EventCodeEnum eventCode;

    /**
     * 错误码
     */
    private ErrorCodeEnum errorCode;

    /**
     * 最终错误上下文
     */
    private ErrorContext errorContext;

    /**
     * 是否可重试
     */
    private boolean canRetry;

    /**
     * 默认创建一个错误上下文
     *
     * @param eventCode
     * @param errorCode
     * @param errorMessage
     */
    public SysException(EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage, boolean canRetry) {
        super(errorMessage);
        this.eventCode = eventCode;
        this.errorCode = errorCode;
        this.errorContext = ErrorContextUtil.create(eventCode, errorCode, errorMessage);
        this.canRetry = canRetry;
    }

    /**
     * 默认创建一个错误上下文，并设置错误异常原因
     *
     * @param eventCode
     * @param errorCode
     * @param errorMessage
     * @param throwable
     */
    public SysException(EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage, Throwable throwable, boolean canRetry) {
        super(errorMessage, throwable);
        this.eventCode = eventCode;
        this.errorCode = errorCode;
        this.errorContext = ErrorContextUtil.create(eventCode, errorCode, errorMessage);
        this.canRetry = canRetry;
    }

    /**
     * 把当前错误上下文加到已有的错误上下文中
     *
     * @param eventCode
     * @param errorCode
     * @param errorMessage
     * @param errorContext
     */
    public SysException(EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMessage, ErrorContext errorContext,
                        boolean canRetry) {
        super(errorMessage);
        this.eventCode = eventCode;
        this.errorCode = errorCode;
        this.errorContext = ErrorContextUtil.fillErrorContext(eventCode, errorCode, errorMessage, errorContext);
        this.canRetry = canRetry;
    }

    public EventCodeEnum getEventCode() {
        return eventCode;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }

    public ErrorContext getErrorContext() {
        return errorContext;
    }

    public boolean isCanRetry() {
        return canRetry;
    }
}
