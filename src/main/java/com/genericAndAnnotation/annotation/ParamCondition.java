/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.annotation;

import com.genericAndAnnotation.enums.ParamConditionTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author wb-fyw404615
 * @version $Id: ParamCondition.java, v 0.1 2019年03月27日 11:17 wb-fyw404615 Exp $
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamCondition {

    /**
     * 参数别名
     * @return
     */
    String value();

    /**
     * 参数类型
     * @return
     */
    ParamConditionTypeEnum conditionType() default ParamConditionTypeEnum.TEXT;
}