package com.aibank.jdk8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaBasic {

    interface  NumberTest {
        boolean test(int m, int n);
    }

    public static void main(String[] args) {
        String[] arr = {"Rafael Nadal", "Novak Djokovic",
                        "Stanislas Wawrinka",
                        "David Ferrer"};
        List<String> players = Arrays.asList(arr);
        // 以前的循环方式
        for (String player : players) {
            System.out.println(player);
        }
        System.out.println("==============================");

        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.println(player));
        System.out.println("==============================");

        Collections.sort(players, (a, b) -> a.compareTo(b));
        players.forEach(player -> System.out.println(player));
        System.out.println("==============================");

        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
        List<Integer> intList = Arrays.asList(intArr);
        intList.forEach(num -> System.out.println( (num % 2 == 0)));

        NumberTest numberTest = (m, n) -> (m % n) == 0;
        if(numberTest.test(10,2)) {
            System.out.println("2 is a factor of 10");
        }

        if(!numberTest.test(10, 3)) {
            System.out.println("3 is not a factor of 10");
        }
    }
}
