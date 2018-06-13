package com.aibank.juc.comunication;

import java.util.concurrent.atomic.AtomicBoolean;

public class MethodFour {

    private AtomicBoolean onoff = new AtomicBoolean(true);

    public Runnable newThreadOne() {
        final String[] numberArray = Helper.buildNumberArray(52);
        return () -> {
            for (int i = 0; i < numberArray.length; i = i + 2) {
                while (!onoff.get()) {
                }
                Helper.print(numberArray[i], numberArray[i + 1]);
                onoff.set(false);
            }
        };
    }

    public Runnable newThreadTwo() {
        final String[] charArray = Helper.buildCharArray(26);
        return () -> {
            for (int i = 0; i < charArray.length; i++) {
                while (onoff.get()) {
                }
                Helper.print(charArray[i]);
                onoff.set(true);
            }
        };
    }

    public static void main(String args[]) throws InterruptedException {
        long start = System.currentTimeMillis();
        MethodFour one = new MethodFour();
        Helper.instance.run(one.newThreadOne());
        Helper.instance.run(one.newThreadTwo());
        Helper.instance.shutdown();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("\ncost times : " + (end - start));
    }
}
