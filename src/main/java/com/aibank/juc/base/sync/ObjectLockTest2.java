package com.aibank.juc.base.sync;

public class ObjectLockTest2 {

    public synchronized void isSyncA(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncA");
            }
        }catch (InterruptedException ie) {
        }
    }

    public static void main(String[] args) {

        final ObjectLockTest2 x = new ObjectLockTest2();

        final ObjectLockTest2 y = new ObjectLockTest2();

        Thread t11 = new Thread(new Runnable() {
            public void run() {
                x.isSyncA();;
            }
        }, "t11");

        Thread t22 = new Thread(new Runnable() {
            public void run() {
                y.isSyncA();;
            }
        }, "t22");

        t11.start();
        t22.start();
    }
}
