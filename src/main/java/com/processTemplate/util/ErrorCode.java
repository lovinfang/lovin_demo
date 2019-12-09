/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 支付宝标准错误码。
 *
 * <p>此错误码是全站推行的标准错误码。
 * <p>标准错误码的格式如下：
 *      <br><b>V0版本的规范：</b></br>
 *      <table border="1">
 *          <tr>
 *           <td><b>位置</b></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td><td>12</td>
 *          </tr>
 *          <tr>
 *           <td><b>示例</b></td><td>A</td><td>E</td><td>0</td><td>1</td><td>0</td><td>1</td><td>0</td><td>1</td><td>1</td><td>0</td><td>2</td><td>7</td>
 *          </tr>
 *          <tr>
 *           <td><b>说明</b></td><td colspan=2>固定<br>标识</td><td>规<br>范<br>版<br>本</td><td>错<br>误<br>级<br>别</td><td>错<br>误<br>类<br>型</td><td colspan=4>错误场景</td><td colspan=3>错误编<br>码</td>
 *          </tr>
 *      </table>
 *
 *      <br><b>V1版本的规范：</b></br>
 *      <table border="1">
 *           <tr>
 *           <td><b>位置</b></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td><td>12</td><td>13</td><td>14</td><td>15</td><td>16</td>
 *          </tr>
 *          <tr>
 *           <td><b>示例</b></td><td>*</td><td>*</td><td>1</td><td>1</td><td>0</td><td>1</td><td>0</td><td>1</td><td>1</td><td>0</td><td>2</td><td>7</td><td>7</td><td>7</td><td>7</td><td>7</td>
 *          </tr>
 *          <tr>
 *           <td><b>说明</b></td><td colspan=2>厂商<br>标识</td><td>规<br>范<br>版<br>本</td><td>错<br>误<br>级<br>别</td><td>错<br>误<br>类<br>型</td><td colspan=8>错误场景</td><td colspan=3>错误编<br>码</td>
 *          </tr>
 *      </table>
 * @author lovin
 * @version $Id: ErrorCode.java, v 0.1 2019年03月21日 16:09 lovin Exp $
 */
public class ErrorCode {
    /** 序列ID */
    private static final long   serialVersionUID = 1938367335153021427L;

    /** 固定标识[第 1-2位] */
    private static final String PREFIX           = "AE";

    /** 规范版本[第3位] */
    private String              version          = DEFAULT_VERSION;

    /** 错误级别[第4位],见<code>ErrorLevels</code>定义 */
    private String              errorLevel;

    /** 错误类型[第5位],见<code>ErrorTypes</code>定义 */
    private String              errorType;

    /** 错误场景：版本1[第6-9位]，版本2[第6-13位] */
    private String              errorScene;

    /** 具体错误码：版本1[第10-12位]，版本2[第14-16位] */
    private String              errorSpecific;

    /** 统一错误规范默认版本 */
    private static String       DEFAULT_VERSION  = "0";

    private String              errorPrefix;

    /**
     * 默认构造方法
     */
    public ErrorCode() {
    }

    public ErrorCode(String errorCode) {
        buildAliErrorCode(errorCode);
    }

    public ErrorCode(String errorCode, String version) {

        if (StringUtils.equals(version, DEFAULT_VERSION)) {
            buildAliErrorCode(errorCode);
        } else {

            buildFcErrorCode(errorCode);
        }

    }

    public ErrorCode(String version, String errorLevel, String errorType, String errorScene,
                     String errorSpecific, String errorPrefix) {
        super();
        this.version = version;
        this.errorLevel = errorLevel;
        this.errorType = errorType;
        this.errorScene = errorScene;
        this.errorSpecific = errorSpecific;
        this.errorPrefix = errorPrefix;
    }

    public void buildAliErrorCode(String errorCode) {
        try {

            checkString(errorCode, 12);

            spliteErrorCode(errorCode);
        } catch (Throwable e) {

            spliteErrorCode("AE0509998998");
        }
    }

    public void buildFcErrorCode(String errorCode) {
        try {

            checkString(errorCode, 16);

            splitFcErrorCode(errorCode);
        } catch (Throwable e) {

            splitFcErrorCode("AE15999999999999");
        }
    }

    private void splitFcErrorCode(String errorCode) {

        char[] chars = errorCode.toCharArray();

        this.errorPrefix = "" + chars[0] + chars[1];
        this.version = "" + chars[2];
        this.errorLevel = "" + chars[3];
        this.errorType = "" + chars[4];
        this.errorScene = "" + chars[5] + chars[6] + chars[7] + chars[8] + chars[9] + chars[10]
                + chars[11] + chars[12];
        this.errorSpecific = "" + chars[13] + chars[14] + chars[15];
    }

    /**
     * 构造方法
     *
     * @param version
     * @param errorLevel
     * @param errorType
     * @param errorScene
     * @param errorSpecific
     */
    public ErrorCode(String version, String errorLevel, String errorType, String errorScene,
                     String errorSpecific) {
        this.version = version;
        this.errorLevel = errorLevel;
        this.errorType = errorType;
        this.errorScene = errorScene;
        this.errorSpecific = errorSpecific;
    }

    /**
     * 构造方法
     *
     * @param errorLevel
     * @param errorType
     * @param errorScene
     * @param errorSpecific
     */
    public ErrorCode(String errorLevel, String errorType, String errorScene, String errorSpecific) {
        this.errorLevel = errorLevel;
        this.errorType = errorType;
        this.errorScene = errorScene;
        this.errorSpecific = errorSpecific;
    }


    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        try {

            checkString(this.version, 1);
            checkString(this.errorLevel, 1);
            checkString(this.errorScene, getErrorSceneLenByVersion(version));
            checkString(this.errorSpecific, 3);
            checkString(this.errorType, 1);

        } catch (IllegalArgumentException e) {

            return "AE15999999999999";
        }

        StringBuffer sb = new StringBuffer();
        sb.append(getPrefixByVersion(version));
        sb.append(version);
        sb.append(errorLevel);
        sb.append(errorType);
        sb.append(errorScene);
        sb.append(errorSpecific);

        return sb.toString();
    }

    private String getPrefixByVersion(String version) {
        if (StringUtils.equals(DEFAULT_VERSION, version)) {
            return PREFIX;
        } else {
            return errorPrefix;
        }
    }

    private int getErrorSceneLenByVersion(String version) {
        if (StringUtils.isBlank(version)) {
            throw new IllegalArgumentException();
        }

        if (StringUtils.equals(DEFAULT_VERSION, version)) {
            return 4;
        } else {
            return 8;
        }

    }


    /**
     * 解析和拆分错误码
     *
     * @param errorCode
     */
    private void spliteErrorCode(String errorCode) {

        if (!errorCode.startsWith(PREFIX)) {

            throw new IllegalArgumentException();
        }

        char[] chars = errorCode.toCharArray();

        this.version = "" + chars[2];
        this.errorLevel = "" + chars[3];
        this.errorType = "" + chars[4];
        this.errorScene = "" + chars[5] + chars[6] + chars[7] + chars[8];
        this.errorSpecific = "" + chars[9] + chars[10] + chars[11];
    }

    /**
     * 字符串长度检查
     *
     * @param str
     * @param length
     */
    private void checkString(String str, int length) {

        if (str == null || str.length() != length) {

            throw new IllegalArgumentException();
        }
    }

    public static String getPrefix() {
        return PREFIX;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(String errorLevel) {
        this.errorLevel = errorLevel;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorScene() {
        return errorScene;
    }

    public void setErrorScene(String errorScene) {
        this.errorScene = errorScene;
    }

    public String getErrorSpecific() {
        return errorSpecific;
    }

    public void setErrorSpecific(String errorSpecific) {
        this.errorSpecific = errorSpecific;
    }

    public static String getDefaultVersion() {
        return DEFAULT_VERSION;
    }

    public static void setDefaultVersion(String defaultVersion) {
        DEFAULT_VERSION = defaultVersion;
    }

    public String getErrorPrefix() {
        return errorPrefix;
    }

    public void setErrorPrefix(String errorPrefix) {
        this.errorPrefix = errorPrefix;
    }


}