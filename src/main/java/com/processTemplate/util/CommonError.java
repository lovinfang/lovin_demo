/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.util;

/**
 * @author wb-fyw404615
 * @version $Id: CommonError.java, v 0.1 2019年03月21日 16:07 wb-fyw404615 Exp $
 */
public class CommonError {

    /** 错误编码 */
    private ErrorCode errorCode;

    /** 错误描述 */
    private String errorMsg;

    /** 错误发生系统 */
    private String location;

    public CommonError() {
    }

    public CommonError(ErrorCode errorCode, String errorMsg, String location) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.location = location;
    }

    /**
     * 转化为简单字符串表示。
     *
     * @return
     */
    public String toDigest() {

        return errorCode + "@" + location;
    }

    @Override
    public String toString() {

        return errorCode + "@" + location + "::" + errorMsg;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}