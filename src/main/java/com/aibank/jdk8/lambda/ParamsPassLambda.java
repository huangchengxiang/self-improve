package com.aibank.jdk8.lambda;

public class ParamsPassLambda {

    interface StrFunc{
        String func(String n);
    }

    public static String stringOperate(StrFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {

        String input = "ABCDE";
        System.out.println("input string is : " + input);

        String output = stringOperate((str) -> {
            String ret = "";

            for(int i = str.length() - 1; i >= 0; i--) {
                ret += str.charAt(i);
            }

            return ret;
        }, input);

        System.out.println("output string is :" + output);

        String uppercase = stringOperate((str) -> str.toUpperCase(), "abcde");
        System.out.println("uppercase string is : " + uppercase);

    }
}
