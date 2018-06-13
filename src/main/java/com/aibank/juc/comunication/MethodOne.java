package com.aibank.juc.comunication;

public class MethodOne {

    private final ThreadToGo threadToGo = new ThreadToGo();

    public Runnable newThreadOne() {
        final String[] numberArray = Helper.buildNumberArray(52);
        return () -> {
            try {
                for (int i = 0; i < numberArray.length; i = i + 2) {
                    synchronized (threadToGo) {
                        while (threadToGo.value == 2) {
                            threadToGo.wait();
                        }
                        Helper.print(numberArray[i], numberArray[i + 1]);
                        threadToGo.value = 2;
                        threadToGo.notify();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Oops...");
            }
        };
    }

    public Runnable newThreadTwo() {
        final String[] charArray = Helper.buildCharArray(26);
        return () -> {
            try {
                for (int i = 0; i < charArray.length; i++) {
                    synchronized (threadToGo) {
                        while (threadToGo.value == 1) {
                            threadToGo.wait();
                        }
                        Helper.print(charArray[i]);
                        threadToGo.value = 1;
                        threadToGo.notify();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Oops...");
            }
        };
    }

    class ThreadToGo {
        int value = 1;
    }

    public static void main(String args[]) throws InterruptedException {
        long start = System.currentTimeMillis();
        MethodOne one = new MethodOne();
        Helper.instance.run(one.newThreadOne());
        Helper.instance.run(one.newThreadTwo());
        Helper.instance.shutdown();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("\ncost times : " + (end - start));
    }
}
