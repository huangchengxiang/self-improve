package com.aibank.designpattern.factory;

import java.util.Scanner;

public class Computer {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        float firstNum  = in.nextFloat();
        System.out.println("请输入第二个数字：");
        float secondNum  = in.nextFloat();
        System.out.println("请输入运算符号：");
        String countQuato = in.next();
        if("+".equals(countQuato)){
            System.out.println("result : "+(firstNum + secondNum));
        }else if("-".equals(countQuato)){
            System.out.println("result : "+(firstNum - secondNum));
        }else if("*".equals(countQuato)){
            System.out.println("result : "+(firstNum * secondNum));
        }else if("/".equals(countQuato)){
            System.out.println("result : "+(firstNum / secondNum));
        }
    }

}
