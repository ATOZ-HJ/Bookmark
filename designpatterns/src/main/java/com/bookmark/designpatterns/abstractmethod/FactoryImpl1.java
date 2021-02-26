package com.bookmark.designpatterns.abstractmethod;

/**
 * @author: hj
 * @date: 2021-02-26 17:30
 * @description:
 **/
public class FactoryImpl1 extends AbstractFactory {
    @Override
    AbstractProductA createAbstractProductA() {
        return new AbstractProductA1();
    }

    @Override
    AbstractProductB createAbstractProductB() {
        return new AbstractProductB1();
    }
}
