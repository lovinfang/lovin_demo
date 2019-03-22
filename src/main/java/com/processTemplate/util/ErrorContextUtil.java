/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.util;

import com.processTemplate.constant.ErrorCodeVersion;
import com.processTemplate.constant.SystemConstants;
import com.processTemplate.enums.EventCodeEnum;
import com.processTemplate.enums.ErrorCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author wb-fyw404615
 * @version $Id: ErrorContextUtil.java, v 0.1 2019年03月22日 9:38 wb-fyw404615 Exp $
 */
public class ErrorContextUtil {

    /**
     * 根据错误码和事件码生成标准的错误上下文
     *
     * @param errorCode 错误码
     * @param errorMsg  错误描述tring
     * @return
     */
    public static ErrorContext create(EventCodeEnum eventCode, ErrorCodeEnum errorCode, String errorMsg) {
        ErrorContext errorContext = new ErrorContext();
        CommonError error = createCommonError(eventCode, errorCode, errorMsg);
        ErrorUtil.addError(error);
        errorContext.addError(error);
        return errorContext;
    }

    /**
     * 填充错误异常到已有的错误队列中
     *
     * @param errorCode
     * @param errorMsg
     * @param context
     * @return
     */
    public static ErrorContext fillErrorContext(EventCodeEnum eventCode, ErrorCodeEnum errorCode,
                                                String errorMsg, ErrorContext context) {
        CommonError error = createCommonError(eventCode, errorCode, errorMsg);
        return ErrorUtil.addError(context, error);
    }

    /**
     * 获取错误码
     *
     * @param errorContext
     * @return
     */
    public static String fetchCurrentErrorCode(ErrorContext errorContext) {
        if (errorContext == null) {
            return null;
        }
        return errorContext.fetchCurrentErrorCode();

    }

    /**
     * 根据错误码和事件码生成标准的错误栈信息
     *
     * @param errorCode
     * @param eventCode
     * @param errorMsg
     * @return
     */
    private static CommonError createCommonError(EventCodeEnum eventCode, ErrorCodeEnum errorCode,
                                                 String errorMsg) {

        ErrorCode inErrorCode = new ErrorCode(ErrorCodeVersion.VERSION_ONE,
                errorCode.getLevels(), errorCode.getType(), eventCode.getCode(),
                errorCode.getCode(), ErrorCode.getPrefix());

        return ErrorUtil.makeError(inErrorCode, errorMsg, SystemConstants.SYSTEM);
    }

    /**
     * @param eventCode
     * @param errorCode
     * @return
     */
    public static ErrorCode makeErrorCode(EventCodeEnum eventCode, ErrorCodeEnum errorCode) {
        return new ErrorCode(ErrorCodeVersion.VERSION_ONE, errorCode.getLevels(),
                errorCode.getType(), eventCode.getCode(), errorCode.getCode(),
                ErrorCode.getPrefix());
    }

    /**
     * 校验RPC结果中errorContext是否包含预期错误码
     *
     * @param errorContext
     * @param errorCode
     * @return true:包含;false:不包含或者入参不正确
     */
    public static boolean containsErrorCode(final ErrorContext errorContext,
                                            final String errorCode) {
        if (null == errorContext || CollectionUtils.isEmpty(errorContext.getErrorStack())
                || StringUtils.isBlank(errorCode)) {
            return false;
        }

        for (final CommonError error : errorContext.getErrorStack()) {
            if (StringUtils.equals(errorCode, error.getErrorCode().toString())) {
                return true;
            }
        }

        return false;
    }
}