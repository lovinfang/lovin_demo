/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 参数序列化支持抽象基类
 * @author lovin
 * @version $Id: ToString.java, v 0.1 2019年03月27日 12:33 lovin Exp $
 */
public class ToString implements Serializable, Cloneable{

    private static final long serialVersionUID = -7799012533830839261L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}