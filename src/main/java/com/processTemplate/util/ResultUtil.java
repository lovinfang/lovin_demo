/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.util;

import com.processTemplate.enums.ErrorCodeEnum;
import com.processTemplate.enums.EventCodeEnum;
import com.processTemplate.model.Result;

/**
 *
 * @author lovin
 * @version $Id: ResultUtil.java, v 0.1 2019年03月22日 15:15 lovin Exp $
 */
public class ResultUtil {
    /**
     * 构造一个成功的RPC返回对象
     *
     * @param resultObject 值对象
     * @param <T>          值对象类型
     * @return Result
     */
    public static <T> Result<T> buildSuccessfulResult(final T resultObject) {
        return new Result<T>(true, null, resultObject);
    }

    /**
     * 构建失败的Result
     *
     * @param errorCode
     * @param errorMsg
     * @return 失败的Result
     */
    public static <T> Result<T> buildFailedResult(EventCodeEnum eventCodeEnum, ErrorCodeEnum errorCode, String errorMsg, boolean canRetry) {
        ErrorContext errorContext = ErrorContextUtil.create(eventCodeEnum, errorCode, errorMsg);
        return new Result<T>(false, canRetry, errorContext, null);
    }

    /**
     * 判断返回结果是否成功
     *
     * @param result
     * @return
     */
    public static boolean isSuccess(Result result) {
        return result != null && result.isSuccess();
    }

    /**
     * 获取RPC返回结果的错误码
     *
     * @param result
     * @return
     */
    public static String fetchCurrentErrorCode(Result result) {
        return result != null && result.getErrorContext() != null ? result.getErrorContext().fetchCurrentErrorCode() : null;

    }

    /**
     * 获取RPC返回结果的错误信息
     *
     * @param result
     * @return
     */
    public static String fetchCurrentErrorMessage(Result result) {
        return result != null && result.getErrorContext() != null && result.getErrorContext().fetchCurrentError() != null ? result
                .getErrorContext().fetchCurrentError().getErrorMsg() : "";
    }
}