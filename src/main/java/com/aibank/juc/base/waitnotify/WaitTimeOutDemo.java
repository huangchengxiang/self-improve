package com.aibank.juc.base.waitnotify;


public class WaitTimeOutDemo extends  Thread {

    public WaitTimeOutDemo(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " run ");
        // 死循环，不断运行。
        while(true){
            System.out.println(Thread.currentThread().getName() + " running ....");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("interrupt Exception!");
            }
        }
    }

    public static void main(String[] args) {
        WaitTimeOutDemo t1 = new WaitTimeOutDemo("t1");
        synchronized(t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();

                // 主线程等待t1通过notify()唤醒 或 notifyAll()唤醒，或超过3000ms延时；然后才被唤醒。
                System.out.println(Thread.currentThread().getName() + " call wait ");
                long start = System.currentTimeMillis();
                t1.wait(3000);
                long end = System.currentTimeMillis();
                System.out.println("actual cost times : " + (end - start));
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
