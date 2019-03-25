/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.chainofresponse;

/**
 *
 *  https://www.jianshu.com/p/198a29556f30 可以了解责任链模式的好处和坏处
 *  好处：不用考虑其他处理者的实现，基于上帝视角，不管你们是哪个处理的，我只要处理好
 *  坏处：有延迟，要寻找是哪个处理者进行处理，所以低延迟的处理请求不要使用责任链模式
 *
 * @author wb-fyw404615
 * @version $Id: Main.java, v 0.1 2019年03月25日 10:44 wb-fyw404615 Exp $
 */
public class Main {

    public static void main(String[] args) {
        Support alice   = new NoSupport("Alice");
        Support bob     = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana   = new LimitSupport("Diana", 200);
        Support elmo    = new OddSupport("Elmo");
        Support fred    = new LimitSupport("Fred", 300);

        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for (int i=0; i<500; i++){
            alice.support(new Trouble(i));
        }
    }
}