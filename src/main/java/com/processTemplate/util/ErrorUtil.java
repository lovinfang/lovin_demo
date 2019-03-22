/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.util;

import com.processTemplate.constant.ErrorCodeVersion;
import org.apache.log4j.Logger;

/**
 * 标准错误码工具类。
 *
 * <p>使用标准错误码时，必须配置ErrorUtil的bean。否则获取不到错误位置信息。
 * @author wb-fyw404615
 * @version $Id: ErrorUtil.java, v 0.1 2019年03月22日 11:23 wb-fyw404615 Exp $
 */
public class ErrorUtil {
    /** 普通日志 */
    private static final Logger logger = Logger.getLogger(ErrorUtil.class);

    /** 系统名称 */
    private static String       appName;

    private ErrorUtil() {
    }

    /**
     * V1版本错误码构造函数。
     *
     * @param version 版本信息。（外围应用传入）
     * @param errorLevel 错误级别。（1：信息、3：警告、5：错误、7：严重错误）
     * @param errorType 错误类型。（0：系统错误、1：业务错误、2：第三方错误、9：未分类）
     * @param errorScene 错误场景。（业务事件码）
     * @param errorSpecific 错误编码。（错误明细编码，错误场景内唯一）
     * @param errorPrefix 错误码前缀。（按厂商分配，AE代表支付宝使用的前缀）
     * @return 错误码实例。
     */
    public static ErrorCode makeFcErrorCode(String version, String errorLevel, String errorType,
                                            String errorScene, String errorSpecific,
                                            String errorPrefix) {
        return new ErrorCode(version, errorLevel, errorType, errorScene, errorSpecific, errorPrefix);
    }

    /**
     * V1版本错误码构造函数。<font color=red>支付宝 主站不要使用</font>
     *
     * @param errorCode 错误码信息。
     * @return 错误码实例。
     */
    public static ErrorCode makeFcErrorCode(String errorCode) {
        return new ErrorCode(errorCode, ErrorCodeVersion.VERSION_ONE);
    }

    /**
     * 创建ErrorCode
     *
     * @param errorLevel
     * @param errorType
     * @param errorScene
     * @param errorSpecific
     * @return
     */
    public static ErrorCode makeErrorCode(String errorLevel, String errorType, String errorScene,
                                          String errorSpecific) {
        return new ErrorCode(errorLevel, errorType, errorScene, errorSpecific);
    }

    /**
     * 创建一个CommonError
     * @param errorCode
     * @param message
     * @return
     */
    public static CommonError makeError(ErrorCode errorCode, String message) {

        CommonError error = new CommonError();
        error.setErrorCode(errorCode);
        error.setErrorMsg(message);
        error.setLocation(getAppName());
        return error;
    }

    /**
     * 创建一个CommonError
     * @param errorCode
     * @param message
     * @param location
     * @return
     */
    public static CommonError makeError(ErrorCode errorCode, String message, String location) {

        CommonError error = new CommonError();
        error.setErrorCode(errorCode);
        error.setErrorMsg(message);
        error.setLocation(location);
        return error;
    }

    /**
     * 增加一个error到errorContext中
     *
     * @param error
     * @return
     */
    public static ErrorContext addError(CommonError error) {
        return addError(null, error);
    }

    /**
     * 增加一个error到errorContext中
     *
     * @param context
     * @param error
     * @return
     */
    public static ErrorContext addError(ErrorContext context, CommonError error) {

        if (context == null) {
            context = new ErrorContext();
        }

        if (error == null) {

            logger.error("增加到ErrorContext中的CommonError不能为空");
            return context;
        }

        context.addError(error);

        return context;
    }

    /**
     * 创建并且增加一个Error到errorContext中
     *
     * @param context
     * @param errorCode
     * @param message
     * @return
     */
    public static ErrorContext makeAndAddError(ErrorContext context, ErrorCode errorCode,
                                               String message) {

        CommonError error = makeError(errorCode, message);
        context = addError(context, error);

        return context;
    }

    /**
     * 创建并且增加一个Error到新的errorContext中
     *
     * @param errorCode
     * @param message
     * @return
     */
    public static ErrorContext makeAndAddError(ErrorCode errorCode, String message) {

        CommonError error = makeError(errorCode, message);
        ErrorContext context = addError(error);

        return context;
    }

    /**
     * 获取系统名称
     *
     * @return
     */
    public static String getAppName() {

        if (null == appName || "".equals(appName)) {
            return "unknown";
        }

        return appName;
    }

    /**
     * Setter method for property <tt>appName</tt>.
     *
     * @param appName value to be assigned to property appName
     */
    public void setAppName(String appName) {
        ErrorUtil.appName = appName;
    }
}