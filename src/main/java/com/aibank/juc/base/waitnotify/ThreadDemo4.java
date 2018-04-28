package com.aibank.juc.base.waitnotify;


public class ThreadDemo4 extends  Thread {

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0 ; i < 5; i++) {
            System.out.println("Hello");
        }
        /**
         * throws IllegalMonitorStateException
         * 原因：当前线程不含有当前对象的锁资源的时候，调用obj.wait()方法
         *
         * 问题：当前线程拥有的锁资源是什么？
         * 线程运行一定需要锁吗？不是，只有在多个线程出现静态条件时，我们才需要锁进行对临界资源进行同步
         */
        Thread.currentThread().wait();
        for(int j = 0; j < 5; j++) {
            System.out.println("world");
        }

    }
}
