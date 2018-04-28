package com.aibank.juc.base.waitnotify;


public class ThreadDemo8 extends  Thread {

    public static void main(String[] args) throws InterruptedException{
        synchronized (Thread.currentThread()) {
            for(int i = 0 ; i < 5; i++) {
                System.out.println("Hello");
            }
            /**
             * current thread wait until another thread invoke notify() or notifyAll() method
             */
            Thread.currentThread().wait();

            /**
             * 缓存阻塞在当前对象"Thread.currentThread()"上的【其他线程】，不能自己唤醒自己
             */
            Thread.currentThread().notify();
            /**
             * 不会被执行，因为当前线程一直没有被其他线程唤醒
             */
            for(int j = 0; j < 5; j++) {
                System.out.println("world");
            }
        }

    }
}
