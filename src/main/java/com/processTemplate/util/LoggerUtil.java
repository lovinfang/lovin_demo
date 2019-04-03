/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.helpers.MessageFormatter;

/**
 *
 * @author lovin
 * @version $Id: LoggerUtil.java, v 0.1 2019年03月21日 16:28 lovin Exp $
 */
public class LoggerUtil {
    /**
     * 日志参数前缀
     */
    private static final String LOG_PARAM_PREFIX = "(";

    /**
     * 日志参数后缀
     */
    private static final String LOG_PARAM_SUFFIX = ")";

    /**
     * 输出info level的log信息.
     *
     * @param logger   日志记录器
     * @param template log信息,如:<code>xxx{},xxx{}...</code>
     * @param args     log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
     */
    public static void info(Logger logger, String template, Object... args) {
        if (logger.isInfoEnabled()) {
            logger.info(format(template, args) + appendTraceId());
        }
    }

    /**
     * 输出info level的log信息.
     *
     * @param logger   日志记录器
     * @param t        异常
     * @param template log信息,如:<code>xxx{},xxx{}...</code>
     * @param args     log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
     */
    public static void info(Logger logger, Throwable t, String template, Object... args) {
        if (logger.isInfoEnabled()) {
            logger.info(format(template, args) + appendTraceId(), t);
        }
    }

    /**
     * 输出warn level的log信息.
     *
     * @param logger   日志记录器
     * @param template log信息,如:<code>xxx{},xxx{}...</code>
     * @param args     log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
     */
    public static void warn(Logger logger, String template, Object... args) {
        logger.warn(format(template, args) + appendTraceId());
    }

    /**
     * 输出warn level的log信息.
     *
     * @param logger   日志记录器
     * @param t        异常
     * @param template log信息,如:<code>xxx{},xxx{}...</code>
     * @param args     log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
     */
    public static void warn(Logger logger, Throwable t, String template, Object... args) {
        logger.warn(format(template, args) + appendTraceId(), t);
    }

    /**
     * 输出error level的log信息.
     *
     * @param logger   日志记录器
     * @param template log信息,如:<code>xxx{},xxx{}...</code>
     * @param args     log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
     */
    public static void error(Logger logger, String template, Object... args) {
        logger.error(format(template, args) + appendTraceId());
    }

    /**
     * 输出error level的log信息.
     *
     * @param logger   日志记录器
     * @param t        异常
     * @param template log信息,如:<code>xxx{},xxx{}...</code>
     * @param args     log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
     */
    public static void error(Logger logger, Throwable t, String template, Object... args) {
        logger.error(format(template, args) + appendTraceId(), t);
    }

    /**
     * 日志信息参数化格式化
     *
     * @param message log信息,如:<code>xxx{},xxx{}...</code>
     * @param params  log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
     * @return 格式化后的日志信息
     */
    private static String format(String message, Object... params) {
        return MessageFormatter.arrayFormat(message, params).getMessage();
    }

    /**
     * 增加traceid
     *
     * @return
     */
    public static String appendTraceId() {
        String traceId = StringUtils.defaultString("traceId", "-");
        return LOG_PARAM_PREFIX + "tracerId:" + traceId + LOG_PARAM_SUFFIX;

    }
}