package com.bookmark.designpatterns.factorymethod;

/**
 * @author: hj
 * @date: 2021-02-26 16:48
 * @description:
 * 1.定义一个顶层的抽象工厂，提供一个工厂方法返回一个product对象，
 * 2.由子类去实现该方法，返回不同的product实现类对象
 * 3.这里工厂实现不再由Factory自己实现，而是由Factory不同的子类去实现
 **/
public abstract class Factory {

    public abstract Product factoryMethod();

    public void doSomething() {
        Product product = factoryMethod();
        System.out.println("do......");
    }

}
