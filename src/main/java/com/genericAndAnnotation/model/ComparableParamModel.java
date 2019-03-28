/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.model;

import com.genericAndAnnotation.annotation.ParamCondition;

/**
 *
 * @author wb-fyw404615
 * @version $Id: ComparableParamModel.java, v 0.1 2019年03月27日 16:22 wb-fyw404615 Exp $
 */
public class ComparableParamModel extends ParamModel implements Comparable<ComparableParamModel> {

    private static final long  serialVersionUID = 1L;

    public static final String PRIORITY         = "priority";

    /**
     * 优先级
     */
    @ParamCondition("priority")
    private Integer            priority;

    @Override
    public int compareTo(ComparableParamModel o) {
        if (o == null || o.getPriority() == null) {
            return 1;
        }

        if (priority == null) {
            return -1;
        }

        return o.priority - priority;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}