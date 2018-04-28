package com.aibank.juc.base.waitnotify;


public class ThreadDemo6 extends  Thread {

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0 ; i < 5; i++) {
            System.out.println("Hello");
        }
        /**
         * Causes the currently executing thread to sleep (temporarily cease
         * execution) for the specified number of milliseconds. The thread
         * does not lose ownership of any monitors.
         */
        Thread.sleep(3000);
        for(int j = 0; j < 5; j++) {
            System.out.println("world");
        }

    }
}
