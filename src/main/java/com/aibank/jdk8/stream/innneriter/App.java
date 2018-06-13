package com.aibank.jdk8.stream.innneriter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        List<Aritist> aritistList = new ArrayList<>();
        Aritist aritist1 = new Aritist("Tom", 23, "BeiJing");
        Aritist aritist2 = new Aritist("Jack", 34, "HuBei");
        Aritist aritist3 = new Aritist("Michael", 18, "WuHan");
        Aritist aritist4 = new Aritist("Jetty", 23, "TianJing");
        Aritist aritist5 = new Aritist("Jackson", 43, "ChongQi");
        Aritist aritist6 = new Aritist("Vetor", 26, "BeiJing");
        Aritist aritist7 = new Aritist("John", 29, "BeiJing");
        Aritist aritist8 = new Aritist("Mick", 45, "ChongQi");
        aritistList.add(aritist1);
        aritistList.add(aritist2);
        aritistList.add(aritist3);
        aritistList.add(aritist4);
        aritistList.add(aritist5);
        aritistList.add(aritist6);
        aritistList.add(aritist7);
        aritistList.add(aritist8);

        int bjCount = 0;
        Iterator iterator = aritistList.iterator();
        while (iterator.hasNext()) {
            Aritist aritist = (Aritist) iterator.next();
            if (aritist.isFrom("BeiJing")) {
                bjCount++;
            }
        }
        System.out.println(bjCount);

        //内部迭代
        long bjCnt = aritistList.stream()
                .filter(aritist -> aritist.isFrom("BeiJing"))
                .count();
        System.out.println(bjCnt);

        // 惰性求值方法
        aritistList.stream().filter(aritist -> {
            System.out.println(">>> " + aritist);
            return aritist.isFrom("BeiJing");
        });

        // 及早求值方法
        aritistList.stream().filter(aritist -> {
            System.out.println("<<<<" + aritist);
            return aritist.isFrom("BeiJing");
        }).count();

        //使用map方法，所有艺术家年龄+10
        aritistList.stream()
                .map(aritist -> {
                    int newAge = aritist.getAge() + 10;
                    aritist.setAge(newAge);
                    return aritist;
                })
                .forEach(aritist -> System.out.println(aritist));

        aritistList.stream()
                .mapToLong(aritist -> aritist.getAge() * 100L)
                .forEach(newAge -> System.out.println(newAge));

        //flatMap的使用

        Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5), Arrays.asList(6, 7, 8, 9))
              .forEach(intList -> System.out.println(intList));

        System.out.println("===============================");

        Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5), Arrays.asList(6, 7, 8, 9))
              .map(intList -> {
                  return intList.stream().map(ele -> ele * ele).collect(Collectors.toList());
              }).forEach(intList -> System.out.println(intList));

        System.out.println("===============================");

        Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5), Arrays.asList(6, 7, 8, 9))
                .flatMap(childList -> childList.stream())
                .map(ele -> ele * ele)
                .forEach(ele -> System.out.print(ele + " "));

        System.out.println("\n===============================");

        List<Integer> intList = Stream.of(1, 2, 3, 4, 5)
                .peek(ele -> System.out.println(ele))
                .map(ele -> ele * ele)
                .peek(ele -> System.out.println(ele))
                .collect(Collectors.toList());
        intList.forEach(ele -> System.out.println(ele));

        //reduce 操作
        System.out.println("================================");
        String contact = Stream.of("A", "B", "C", "D", "E").reduce("", (a, b) -> a.concat(b));
        System.out.println(contact);

        Double minVal = Stream.of(-1.5D, 1.0, -3.0D, 8.3D, 0.9D).reduce(Double.MAX_VALUE, (a, b) -> Double.min(a, b));
        System.out.println(minVal);

        Stream.of(1, 2, 3, 4, 5, 55, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
                .limit(10)
                .skip(3)
                .forEach(ele -> System.out.println(ele));

        boolean ret = Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 111, 222, 333, 444, 55)
                .anyMatch(ele -> ele > 10);
        System.out.println(ret);
        boolean result = Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 111, 222, 333, 444, 55)
                .anyMatch(ele -> ele > 1);
        System.out.println(result);

        boolean ret1 = Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 111, 222, 333, 444, 55)
                .allMatch(ele -> ele > 10);
        System.out.println(ret1);
        boolean result1 = Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 111, 222, 333, 444, 55)
                .allMatch(ele -> ele > 0);
        System.out.println(result1);

        boolean ret2 = Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 111, 222, 333, 444, 55)
                .noneMatch(ele -> ele > 10);
        System.out.println(ret2);
        boolean result2 = Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 111, 222, 333, 444, 55)
                .noneMatch(ele -> ele < 0);
        System.out.println(result2);

        //parallel stream
        Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
                .parallel()
                .forEach(ele -> System.out.print(ele + " "));

        System.out.println("\n================================");

        Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
                .forEach(ele -> System.out.print(ele + " "));


    }
}

