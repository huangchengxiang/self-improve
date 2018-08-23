package com.aibank.designpattern.factory.factorymethod;

import com.aibank.designpattern.factory.AddOperator;
import com.aibank.designpattern.factory.Operator;

public class AddFactory implements  IFactory {

    @Override
    public Operator generateOperator() {
        return new AddOperator();
    }

}
