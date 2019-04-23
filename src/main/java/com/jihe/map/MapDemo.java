/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jihe.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version $Id: MapDemo.java, v 0.1 2019年04月03日 11:18 lovin Exp $
 *
 * HashMap value去重 方法一：将HashMap的key-value对调，然后赋值给一个新的HashMap，由于key的不可重复性，此时就将重复值去掉了。最后将新得到的HashMap的key-value再对调一次即可
 * https://blog.csdn.net/HHcoco/article/details/53117525
 */
public class MapDemo {

    public static void main(String[] args) {
        MapDemo mapDemo = new MapDemo();
        //mapDemo.test();
        //mapDemo.sortByValueHashMap();
        mapDemo.sortByKeyHashMap();

        //创建线程同步的HashMap的两种方式
        Map<Integer,String> hashmap = new HashMap<Integer,String>();
        hashmap = Collections.synchronizedMap(hashmap);

        ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<Integer,String>();
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

        /**
         * keyset会遍历两次，效率没有使用entrySet高
         */

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

    /**
     * HashMap 按值排序
     */
    public void sortByValueHashMap(){
        Map<Integer,String> hashmap = new HashMap<Integer,String>();
        int i = 0;
        hashmap.put(199, "序号:"+201);
        while(i<50){
            hashmap.put(i, "序号:"+i);
            i++;
        }
        hashmap.put(-1, "序号:"+200);
        hashmap.put(200, "序号:"+200);
        System.out.println("排序后");

        //第一步，用HashMap构造一个LinkedList
        Set<Map.Entry<Integer , String>> sets = hashmap.entrySet();
        LinkedList<Map.Entry<Integer , String>> linkedList = new LinkedList<Map.Entry<Integer , String>>(sets);

        //第二步，用Collections的sort方法排序
        Collections.sort(linkedList, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //第三步，将排序后的list赋值给LinkedHashMap
        Map<Integer , String> map = new LinkedHashMap();
        for(Map.Entry<Integer , String> entry : linkedList){
            map.put(entry.getKey(), entry.getValue());
        }
        for(Map.Entry<Integer , String> entry : map.entrySet()){
            System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
        }
    }

    /**
     * HashMap按键排序
     * 第一种方法：还是熟悉的配方还是熟悉的味道，用Collections的sort方法，只是更改一下比较规则。
     * 第二种：TreeMap是按键排序的，默认升序，所以可以通过TreeMap来实现。 这里的方法实现第二种方式
     * 第三种：可以通过keyset取出所有的key，然后将key排序，再有序的将key-value键值对存到LinkedHashMap中
     */
    public void sortByKeyHashMap(){
        Map<Integer,String> hashmap = new HashMap<Integer,String>();
        int i = 0;
        hashmap.put(199, "序号:"+201);
        while(i<50){
            hashmap.put(i, "序号:"+i);
            i++;
        }
        hashmap.put(-1, "序号:"+200);
        hashmap.put(200, "序号:"+200);
        System.out.println("按键排序后");
        //第一步：先创建一个TreeMap实例，构造函数传入一个Comparator对象。
        TreeMap<Integer,String> treemap = new TreeMap<Integer,String>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });
        //第二步：将要排序的HashMap添加到我们构造的TreeMap中。
        treemap.putAll(hashmap);
        for(Map.Entry<Integer , String> entry : treemap.entrySet()){
            System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
        }
    }
}