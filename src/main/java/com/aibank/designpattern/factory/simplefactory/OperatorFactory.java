package com.aibank.designpattern.factory.simplefactory;

import com.aibank.designpattern.factory.*;

public class OperatorFactory {

    public static Operator getOperator(String quota) {
        switch (quota) {
            case "+" :
                return new AddOperator();

            case "-" :
                return new SubOperator();

            case "*" :
                return new MulOperator();

            case "/" :
                return new DivOperator();

            default:
                return null;
        }
    }
}
