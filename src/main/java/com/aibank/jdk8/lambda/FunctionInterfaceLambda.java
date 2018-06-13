package com.aibank.jdk8.lambda;

import java.util.function.Predicate;

public class FunctionInterfaceLambda {

    public static void main (String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("foo"));
        System.out.println(predicate.negate().test("foo"));

    }
}
