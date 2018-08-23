package com.aibank.designpattern.singleton.methods;

/**
 * @Auther: huangchengxiang
 * @Date: 2018/8/23 09:25
 * @Description: 方式5: 饿汉式
 */
public class Usoppu {

    public static final Usoppu instance = new Usoppu();

    private Usoppu(){
        System.out.println("Constructor called.");
        if(instance != null) {
            System.out.println("instance exists.");
            throw new UnsupportedOperationException("instance exists, can not init again.");
        }
    }

}