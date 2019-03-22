/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.template;

import com.processTemplate.enums.ErrorCodeEnum;
import com.processTemplate.enums.EventCodeEnum;
import com.processTemplate.exception.BsnException;
import com.processTemplate.exception.SysException;
import com.processTemplate.model.Result;
import com.processTemplate.util.ErrorContext;
import com.processTemplate.util.ErrorContextUtil;
import com.processTemplate.util.LoggerUtil;
import org.slf4j.Logger;

/**
 * 通用业务处理模板类
 *
 * @author wb-fyw404615
 * @version $Id: ProcessTemplate.java, v 0.1 2019年03月21日 15:25 wb-fyw404615 Exp $
 */
public final class ProcessTemplate {

    public static <T> Result<T> execute(ProcessCallback<T> processCallback, Logger logger) {
        long start = System.currentTimeMillis();
        Result<T> result = new Result();

        try {
            processCallback.checkParams();
            result.setResultObj(processCallback.process());
            result.setSuccess(true);
        } catch (IllegalArgumentException iaExp) {
            LoggerUtil.error(logger, iaExp, "参数异常:{}", iaExp.getMessage());
            result.setSuccess(false);
            ErrorContext errorContext = ErrorContextUtil.create(EventCodeEnum.GENERAL_ACTION, ErrorCodeEnum.PARAMETER_ILLEGAL,
                    iaExp.getMessage());
            result.setErrorContext(errorContext);
        } catch (NullPointerException nullExp) {
            LoggerUtil.error(logger, nullExp, "业务空指针异常:{}", nullExp.getMessage());
            result.setSuccess(false);
            ErrorContext errorContext = ErrorContextUtil.create(EventCodeEnum.GENERAL_ACTION, ErrorCodeEnum.NULL_ERROR,
                    nullExp.getMessage());
            result.setErrorContext(errorContext);
        } catch (BsnException bsnExp) {
            LoggerUtil.error(logger, bsnExp, "业务异常:{}", bsnExp.getMessage());
            result.setSuccess(false);
            result.setErrorContext(bsnExp.getErrorContext());
        } catch (SysException sysExp) {
            LoggerUtil.error(logger, sysExp, "系统异常:{}", sysExp.getMessage());
            result.setSuccess(false);
            result.setErrorContext(sysExp.getErrorContext());
            result.setRetry(sysExp.isCanRetry());
        } catch (Throwable exp) {
            LoggerUtil.error(logger, exp, "未知系统异常:{}", exp.getMessage());
            result.setSuccess(false);
            ErrorContext errorContext = ErrorContextUtil.create(EventCodeEnum.GENERAL_ACTION, ErrorCodeEnum.UN_KNOWN_EXCEPTION,
                    exp.getMessage());
            result.setErrorContext(errorContext);
        } finally {
            long duration = System.currentTimeMillis() - start;
            LoggerUtil.info(logger, "服务处理结果:{}, 耗时:{}", result, duration);
        }

        return result;
    }
}