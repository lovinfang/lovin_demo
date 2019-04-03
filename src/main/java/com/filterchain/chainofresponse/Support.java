/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.chainofresponse;

/**
 *
 * @author lovin
 * @version $Id: Support.java, v 0.1 2019年03月25日 10:25 lovin Exp $
 */
public abstract class Support {

    private String name;

    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble){
        if (resolve(trouble)){
            done(trouble);
        }else if(next != null){
            next.support(trouble);
        }else {
            fail(trouble);
        }
    }

    //显示字符串
    @Override
    public String toString(){
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble){
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    //未解决
    protected void fail (Trouble trouble){
        System.out.println(trouble + " can not be resolve");
    }

}