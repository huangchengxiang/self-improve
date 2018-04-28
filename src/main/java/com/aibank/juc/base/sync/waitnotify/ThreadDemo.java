package com.aibank.juc.base.sync.waitnotify;


public class ThreadDemo extends  Thread {

    public ThreadDemo(String name) {
        super(name);
    }

    public void run() {
        synchronized (this) {
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " working........");
            }
            System.out.println(Thread.currentThread().getName()+" call notify()");
            // 唤醒当前的wait线程
            notify();
            System.out.println(Thread.currentThread().getName() + " game over");
        }
    }

    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("t1");
        synchronized(t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName()+" start t1");
                t1.start();

                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName()+" wait()");

                t1.wait();

                System.out.println(Thread.currentThread().getName()+" continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
