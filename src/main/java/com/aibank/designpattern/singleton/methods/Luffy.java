package com.aibank.designpattern.singleton.methods;

/**
 * @Auther: huangchengxiang
 * @Date: 2018/8/23 17:03
 * @Description: 方式3： 饿汉式，双重锁检验 【可以防止暴力反射与反序列化】
 */
public class Luffy {

    private static Luffy instance;

    private Luffy(){
        //防暴力反射破坏单例
        if(instance != null) {
            throw new UnsupportedOperationException("can not init instance again");
        }
    }

    private static final Luffy getInstance(){
        if(null == instance) {
            synchronized (Luffy.class) {
                if(null == instance) {
                    return new Luffy();
                }
            }
        }

        return instance;
    }

    //防止反序列化破坏单例
    private Object readResolve(){
        return  instance;
    }
}