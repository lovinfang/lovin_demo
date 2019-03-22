/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.util;

import com.processTemplate.util.CommonError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wb-fyw404615
 * @version $Id: ErrorContext.java, v 0.1 2019年03月21日 15:54 wb-fyw404615 Exp $
 */
public class ErrorContext implements Serializable {

    /**
     * 错误堆栈集合
     */
    private List<CommonError> errorStack = new ArrayList<>();

    /**
     * 第三方错误原始信息
     */
    private String thirdPartyError;

    /**
     * 错误变量映射
     */
    private Map<String, String> errorVariableMap = new HashMap<String, String>();

    /**
     * 默认分隔符
     */
    private static final String SPLIT = "|";

    public ErrorContext() {
    }

    /**
     * 获取错误变量映射Map
     *
     * @return 错误变量映射Map
     */
    public Map<String, String> fetchErrorVarMap() {
        return errorVariableMap;
    }

    public void setErrorVariable(String variableName, String variableValue) {
        errorVariableMap.put(variableName, variableValue);
    }

    /**
     * 获取当前错误对象
     *
     * @return
     */
    public CommonError fetchCurrentError() {

        if (errorStack != null && errorStack.size() > 0) {

            return errorStack.get(errorStack.size() - 1);
        }
        return null;
    }

    /**
     * 获取当前错误码
     *
     * @return
     */
    public String fetchCurrentErrorCode() {

        if (errorStack != null && errorStack.size() > 0) {

            return errorStack.get(errorStack.size() - 1).getErrorCode().toString();
        }
        return null;
    }

    /**
     * 获取原始错误对象
     *
     * @return
     */
    public CommonError fetchRootError() {

        if (errorStack != null && errorStack.size() > 0) {
            return errorStack.get(0);
        }
        return null;
    }

    /**
     * 向堆栈中添加错误对象。
     *
     * @param error
     */
    public void addError(CommonError error) {

        if (errorStack == null) {

            errorStack = new ArrayList<CommonError>();
        }
        errorStack.add(error);
    }

    /**
     * 转化为简单字符串表示。
     *
     * @return
     */
    public String toDigest() {

        StringBuffer sb = new StringBuffer();

        for (int i = errorStack.size(); i > 0; i--) {

            if (i == errorStack.size()) {

                sb.append(digest(errorStack.get(i - 1)));
            } else {

                sb.append(SPLIT).append(digest(errorStack.get(i - 1)));
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();

        for (int i = errorStack.size(); i > 0; i--) {

            if (i == errorStack.size()) {

                sb.append(errorStack.get(i - 1));
            } else {

                sb.append(SPLIT).append(errorStack.get(i - 1));
            }
        }
        return sb.toString();
    }

    /**
     * 获取错误对象简单表示
     *
     * @param commonError
     * @return
     */
    private String digest(CommonError commonError) {

        if (null == commonError) {

            return null;
        }

        return commonError.toDigest();
    }

    public List<CommonError> getErrorStack() {
        return errorStack;
    }

    public void setErrorStack(List<CommonError> errorStack) {
        this.errorStack = errorStack;
    }

    public String getThirdPartyError() {
        return thirdPartyError;
    }

    public void setThirdPartyError(String thirdPartyError) {
        this.thirdPartyError = thirdPartyError;
    }

    public Map<String, String> getErrorVariableMap() {
        return errorVariableMap;
    }

    public void setErrorVariableMap(Map<String, String> errorVariableMap) {
        this.errorVariableMap = errorVariableMap;
    }
}