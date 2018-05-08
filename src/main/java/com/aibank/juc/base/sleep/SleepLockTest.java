package com.aibank.juc.base.sleep;

class SleepLockTest extends Thread {

    public SleepLockTest(String name) {
        super(name);
    }

    public void run() {
        synchronized (SleepLockTest.class) {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%s: %d\n", this.getName(), i);
                    // i能被4整除时，休眠100毫秒
                    if (i % 4 == 0)
                        Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        SleepLockTest t1 = new SleepLockTest("t1");
        SleepLockTest t2 = new SleepLockTest("t2");
        t1.start();
        t2.start();
    }
}