package com.aibank.jdk8.lambda;

public class GenericTypeLambda {

    interface Generic<T> {
        T func(T t);
    }

    public static void main(String[] args) {
        Generic<Integer> factorial = (n) -> {
            int ret = 1;

            for(int i = 1; i <= n; i++) {
                ret = i * ret;
            }

            return ret;
        };

        System.out.println("6 factorial is : " + factorial.func(6));

        Generic<String> reverse = (str) -> {
            String result = "";

            for(int i = str.length() -1; i >= 0; i--) {
                result += str.charAt(i);
            }

            return result;
        };

        System.out.println("ABCDE reverse is : " + reverse.func("ABCDE"));
    }
}
