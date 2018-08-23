package com.aibank.designpattern.factory.simplefactory;

import com.aibank.designpattern.factory.Operator;

import java.util.Scanner;

public class Computer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        float firstNum  = in.nextFloat();
        System.out.println("请输入第二个数字：");
        float secondNum  = in.nextFloat();
        System.out.println("请输入运算符号：");
        String quota = in.next();
        Operator operator = OperatorFactory.getOperator(quota);
        if(null != operator) {
            System.out.println("result : " + operator.calc(firstNum, secondNum));
        }

    }
}
