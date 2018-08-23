package com.aibank.designpattern.singleton.methods;

/**
 * @Auther: huangchengxiang
 * @Date: 2018/8/23 09:42
 * @Description: 方式2：懒汉式，线程安全
 */
public class Robin {

    private static Robin instance;

    private Robin(){

    }

    public synchronized static Robin getInstance(){
        if(instance != null) {
            return new Robin();
        }
        return instance;
    }
}