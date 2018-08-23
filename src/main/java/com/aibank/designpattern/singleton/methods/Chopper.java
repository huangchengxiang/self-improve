package com.aibank.designpattern.singleton.methods;

/**
 * @Auther: huangchengxiang
 * @Date: 2018/8/23 09:32
 * @Description: 方式4：饿汉式，线程安全
 */
public class Chopper {

    private static final Chopper instance = new Chopper();

    private Chopper(){

    }

    public static final Chopper getInstance(){
        return instance;
    }
}