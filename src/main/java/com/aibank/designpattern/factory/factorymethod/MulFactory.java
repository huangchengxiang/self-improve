package com.aibank.designpattern.factory.factorymethod;

import com.aibank.designpattern.factory.MulOperator;
import com.aibank.designpattern.factory.Operator;

public class MulFactory implements  IFactory{

    @Override
    public Operator generateOperator() {
        return new MulOperator();
    }

}
