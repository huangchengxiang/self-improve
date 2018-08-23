package com.aibank.designpattern.singleton.methods;

/**
 * @Auther: huangchengxiang
 * @Date: 2018/8/23 09:39
 * @Description: 方式1：懒汉式，线程不安全
 */
public class Nami {

    private static Nami instance;

    private Nami(){

    }

    private static final Nami getInstance(){
        if(instance != null) {
            return new Nami();
        }
        return instance;
    }
}