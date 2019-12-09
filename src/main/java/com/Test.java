/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com;

import com.google.common.collect.Lists;

import java.util.List;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Test.java, v 0.1 2019年04月19日 16:00 wb-fyw404615 Exp $
 */
public class Test {

    public static void main(String[] args) {
//        String id = "2019041910233500801030000003500";
//
//        Long test = Long.valueOf(id);
//        System.out.println(test);

        //try{
        //    Thread thread = new Thread(new Task());
        //    thread.start();
        //}catch (Exception e ){
        //    System.out.println("exception:" + e.getMessage());
        //}

        String name = "fang";
        boolean b = false;
        List<String> names = Lists.newArrayList();
        names.add("fanc");
        names.add("fanb");
        names.add("fang");
        names.add("fand");
        names.add("fane");
        names.add("fanf");

        int i = 0;
        for (String s : names){
            i++;
            if (s.equals(name)){
                System.out.println(s);
                break;
            }
        }
        System.out.println("循环了"+i + "次");

    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(3 / 2);
            System.out.println(3 / 0);
            System.out.println(3 / 1);
        }
    }
}