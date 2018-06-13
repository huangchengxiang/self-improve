package com.aibank.jdk8.lambda;

public class LambdaBlock {

    @FunctionalInterface
    interface  NumFactorial {
        int factorial(int n);
    }

    public static void main(String[] args) {

        NumFactorial nFactorial = (n) -> {
            int ret = 1;
            for(int i = 1; i <= n; i++) {
                ret = i * ret;
            }
            return ret;
        };

        System.out.println("6 factorial is : " + nFactorial.factorial(6));
        System.out.println("5 factorial is : " + nFactorial.factorial(5));
        System.out.println("4 factorial is : " + nFactorial.factorial(4));
        System.out.println("3 factorial is : " + nFactorial.factorial(3));
    }
}
