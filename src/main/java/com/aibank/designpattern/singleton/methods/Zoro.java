package com.aibank.designpattern.singleton.methods;

/**
 * @Auther: huangchengxiang
 * @Date: 2018/8/23 09:45
 * @Description: 方式3： 饿汉式，双重锁检验
 */
public class Zoro {

    private static Zoro instance;

    private Zoro(){

    }

    public static final Zoro getInstance(){
        if(instance == null) {
            synchronized (Zoro.class) {
                if(instance == null) {
                    return new Zoro();
                }
            }
        }

        return instance;
    }
}