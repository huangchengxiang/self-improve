package com.aibank.juc.base.interrupt;

public class ThreadInterrupt2 extends Thread {

    public ThreadInterrupt2(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
            try {
                Thread.sleep(100); // 休眠时长越长，发生死循环的几率越大，>=150，一定发生死循环
                // 时间越短发生InterruptException的几率越小，发生死循环的可能性越小
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
            }
            i++;
            System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
        }
    }

    public static void main(String[] args) {
        try {
            Thread t1 = new ThreadInterrupt2("t1");  // 新建“线程t1”
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

            t1.start();                      // 启动“线程t1”
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

