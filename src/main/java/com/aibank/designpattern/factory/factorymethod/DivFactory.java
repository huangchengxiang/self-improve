package com.aibank.designpattern.factory.factorymethod;

import com.aibank.designpattern.factory.DivOperator;
import com.aibank.designpattern.factory.Operator;

public class DivFactory implements IFactory{

    @Override
    public Operator generateOperator() {
        return new DivOperator();
    }

}
