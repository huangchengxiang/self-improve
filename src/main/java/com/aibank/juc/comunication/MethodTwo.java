package com.aibank.juc.comunication;

public class MethodTwo {

    private volatile Boolean flag = true;

    public Runnable newThreadOne() {
        final String[] numberArray = Helper.buildNumberArray(52);
        return () -> {
            for (int i = 0; i < numberArray.length; i = i + 2) {
                while (!flag) {

                }
                Helper.print(numberArray[i], numberArray[i + 1]);
                flag = false;
            }
        };
    }

    public Runnable newThreadTwo() {
        final String[] charArray = Helper.buildCharArray(26);
        return () -> {
            for (int i = 0; i < charArray.length; i++) {
                while (flag) {

                }
                Helper.print(charArray[i]);
                flag = true;
            }
        };
    }

    public static void main(String args[]) throws InterruptedException {
        long start = System.currentTimeMillis();
        MethodTwo one = new MethodTwo();
        Helper.instance.run(one.newThreadOne());
        Helper.instance.run(one.newThreadTwo());
        Helper.instance.shutdown();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("\ncost times : " + (end - start));
    }
}
