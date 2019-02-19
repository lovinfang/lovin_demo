/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.annotation.demo4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Test.java, v 0.1 2019年02月14日 18:48 wb-fyw404615 Exp $
 */
public class Test {

    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("fyw");

        Filter f3 = new Filter();
        f3.setEmail("fang@qq.com,ya@qq.com,wen@qq.com");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println("sql:"+sql1);
        System.out.println("sq2:"+sql2);
        System.out.println("sq3:"+sql3);
    }

    private static String query(Filter f) {
        StringBuilder sb = new StringBuilder();
        Class c = f.getClass();
        boolean isExists = c.isAnnotationPresent(Table.class);
        if(!isExists){
            return null;
        }
        Table t = (Table)c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields){
            boolean fExists = field.isAnnotationPresent(Column.class);
            if (!fExists){
                continue;
            }

            Column column = field.getAnnotation(Column.class);
            String fieldName = field.getName();
            String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);
                fieldValue = getMethod.invoke(f);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(fieldValue == null || (fieldValue instanceof Integer&&(Integer)fieldValue==0)){
                continue;
            }
            sb.append(" and ").append(fieldName);
            if (fieldValue instanceof String){
                if (((String)fieldValue).contains(",")){
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" in (");
                    for(String v : values){
                        sb.append("'").append(v).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");
                }else{
                    sb.append(" = ").append("'").append(fieldValue).append("'");
                }
            }else if (fieldValue instanceof Integer){
                sb.append(" = ").append(fieldValue);
            }
        }

        return sb.toString();
    }
}