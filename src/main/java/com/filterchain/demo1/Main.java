/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Main.java, v 0.1 2019年03月25日 11:36 wb-fyw404615 Exp $
 */
public class Main {

/*  实际应用场景
    <bean id="requestValidateFilter" class="com.filterchain.demo1.RequestValidateFilter" />
    <bean id="permissionValidateFilter" class="com.filterchain.demo1.PermissionValidateFilter"/>
    <bean id="processFilter" class="com.filterchain.demo1.ProcessFilter"/>

    <bean id="filterChainFactory" class="com.filterchain.demo1.DefaultFilterChainFactory">
        <constructor-arg name="filterList">
            <list>
                <ref bean="requestValidateFilter"/>
                <ref bean="permissionValidateFilter"/>
                <ref bean="consultProcessFilter"/>
            </list>
        </constructor-arg>
    </bean>*/

    public static void main(String[] args) {
        List<Filter> filterList = new ArrayList<>();
        filterList.add(new PermissionValidateFilter());
        filterList.add(new RequestValidateFilter());
        filterList.add(new ProcessFilter());
        DefaultFilterChainFactory defaultFilterChainFactory = new DefaultFilterChainFactory(filterList);
        FilterChain filterChain = defaultFilterChainFactory.create();
        filterChain.doChain(new ParamRequest(),new ParamResponse(),filterChain);
    }
}