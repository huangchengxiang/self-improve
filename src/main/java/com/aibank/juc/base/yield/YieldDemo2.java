package com.aibank.juc.base.yield;

public class YieldDemo2 extends  Thread {

    public YieldDemo2(String name){
        super(name);
    }

    public synchronized void run(){
        for(int i = 0; i < 20; i++){
            System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
            // i整除4时，调用yield
            if (i % 4 == 0) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args){
        YieldDemo2 t1 = new YieldDemo2("t1");
        YieldDemo2 t2 = new YieldDemo2("t2");
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}
