package com.aibank.juc.comunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MethodThree {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private volatile Boolean flag = true;

    public Runnable newThreadOne() {
        final String[] numberArray = Helper.buildNumberArray(52);
        return () -> {
            for (int i = 0; i < numberArray.length; i = i + 2) {
                try {
                    lock.lock();
                    while (!flag) {
                        condition.await();
                    }
                    Helper.print(numberArray[i], numberArray[i + 1]);
                    flag = false;
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                     lock.unlock();
                }
            }
        };
    }

    public Runnable newThreadTwo() {
        final String[] charArray = Helper.buildCharArray(26);
        return () -> {
            for (int i = 0; i < charArray.length; i++) {
                try {
                    lock.lock();
                    while (flag) {
                        condition.await();
                    }
                    Helper.print(charArray[i]);
                    flag = true;
                    condition.signal();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
    }

    public static void main(String args[]) throws InterruptedException {
        long start = System.currentTimeMillis();
        MethodThree one = new MethodThree();
        Helper.instance.run(one.newThreadOne());
        Helper.instance.run(one.newThreadTwo());
        Helper.instance.shutdown();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("\ncost times : " + (end - start));
    }
}
