/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.model;

import com.processTemplate.util.ErrorContext;

import java.io.Serializable;

/**
 * 泛型Result结果类
 *
 * @author lovin
 * @version $Id: Result.java, v 0.1 2019年03月21日 15:26 lovin Exp $
 */
public class Result<T> implements Serializable {

    /**
     * 程序是否执行成功
     */
    private boolean success;

    /**
     * 程序是否需要重试
     */
    private boolean retry;

    /**
     * 错误上下文
     */
    private ErrorContext errorContext;

    /**
     * 对象实例
     */
    private T resultObj;

    /**
     * 构造函数。
     */
    public Result() {
    }

    /**
     * 构造函数。
     * @param success 是否成功。
     * @param errorContext 错误上下文。
     * @param resultObj 对象实例。
     */
    public Result(boolean success, ErrorContext errorContext, T resultObj) {
        this.success = success;
        this.errorContext = errorContext;
        this.resultObj = resultObj;
    }

    /**
     * 构造函数-重试
     * @param success
     * @param retry
     * @param errorContext
     * @param resultObj
     */
    public Result(boolean success, boolean retry,ErrorContext errorContext, T resultObj) {
        this.success = success;
        this.retry = retry;
        this.errorContext = errorContext;
        this.resultObj = resultObj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isRetry() {
        return retry;
    }

    public void setRetry(boolean retry) {
        this.retry = retry;
    }

    public ErrorContext getErrorContext() {
        return errorContext;
    }

    public void setErrorContext(ErrorContext errorContext) {
        this.errorContext = errorContext;
    }

    public T getResultObj() {
        return resultObj;
    }

    public void setResultObj(T resultObj) {
        this.resultObj = resultObj;
    }
}