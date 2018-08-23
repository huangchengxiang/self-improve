package com.aibank.designpattern.factory.factorymethod;

import com.aibank.designpattern.factory.Operator;
import com.aibank.designpattern.factory.SubOperator;

public class SubFactory implements IFactory {

    @Override
    public Operator generateOperator() {
        return new SubOperator();
    }

}
