package com.aibank.juc.base.waitnotify;


public class ThreadDemo5 extends  Thread {

    public static void main(String[] args){
        synchronized (Thread.currentThread()) {
            for(int i = 0 ; i < 5; i++) {
                System.out.println("Hello");
            }
            Thread.currentThread().notify();
            for(int j = 0; j < 5; j++) {
                System.out.println("world");
            }
        }

    }
}
