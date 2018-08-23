package com.aibank.designpattern.singleton.destroy;

import java.io.Serializable;

/**
 * @Auther: huangchengxiang
 * @Date: 2018/8/23 09:16
 * @Description:
 */
public class Elvis implements Serializable {

    public static final Elvis instance = new Elvis();

    private Elvis(){
        System.out.println("Constructor called.");
    }
}