package com.aibank.juc.base.sync;

public class ClassLockTest {

    public static synchronized void isSyncA(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncA");
            }
        }catch (InterruptedException ie) {
        }
    }

    public static synchronized void isSyncB(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncA");
            }
        }catch (InterruptedException ie) {
        }
    }

    public static void main(String[] args) {

        final ClassLockTest x = new ClassLockTest();

        final ClassLockTest y = new ClassLockTest();

        Thread t11 = new Thread(new Runnable() {
            public void run() {
                x.isSyncA();;
            }
        }, "t11");

        Thread t22 = new Thread(new Runnable() {
            public void run() {
                y.isSyncB();;
            }
        }, "t22");

        t11.start();
        t22.start();
    }
}
