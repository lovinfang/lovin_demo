/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jihe.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @version $Id: MapDemo.java, v 0.1 2019年04月03日 11:18 lovin Exp $
 */
public class MapDemo {

    public static void main(String[] args) {
        MapDemo mapDemo = new MapDemo();
        mapDemo.test();
    }

    /**
     * Map遍历方法
     */
    public void test(){
        Map<Integer , String> hs = new HashMap<Integer , String>();
        int i = 0;
        hs.put(199, "序号:"+201);
        while(i<50){
            hs.put(i, "序号:"+i);
            i++;
        }
        hs.put(-1, "序号:"+200);
        hs.put(200, "序号:"+200);

        //遍历方式一:for each遍历HashMap的entryset，注意这种方式在定义的时候就必须写成Map<Integer , String> hs，不能写成Map hs;
        System.out.println("-----------遍历方式一-----------");
        for (Map.Entry<Integer,String> entry: hs.entrySet()){
            System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
        }
        //遍历方式二：使用EntrySet的Iterator
        System.out.println("-----------遍历方式二-----------");
        Iterator<Map.Entry<Integer,String>> iterator = hs.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer , String> entry =  iterator.next();
            System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
        }
        //遍历方式三：for each直接使用HashMap的keyset
        System.out.println("-----------遍历方式三-----------");
        for (Integer key : hs.keySet()){
            System.out.println("key:"+key+"  value:"+hs.get(key));
        }
        //遍历方式四：使用keyset的Iterator
        System.out.println("-----------遍历方式四-----------");
        Iterator keyIterator = hs.keySet().iterator();
        while(keyIterator.hasNext()){
            Integer key = (Integer)keyIterator.next();
            System.out.println("key:"+key+"  value:"+hs.get(key));
        }
    }
}