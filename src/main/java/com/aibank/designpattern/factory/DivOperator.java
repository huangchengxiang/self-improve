package com.aibank.designpattern.factory;

public class DivOperator extends  Operator {

    @Override
    public float calc(float firstVal, float secondVal) {
        return firstVal / secondVal;
    }

}
