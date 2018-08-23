package com.aibank.designpattern.factory;

public class AddOperator extends Operator {

    @Override
    public float calc(float firstVal, float secondVal) {
        return firstVal + secondVal;
    }

}
