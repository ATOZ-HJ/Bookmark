package com.bookmark.designpatterns.factorymethod;

/**
 * @author: hj
 * @date: 2021-02-26 16:46
 * @description:
 **/
public class ProductImpl1 implements Product {
    @Override
    public void sell() {
        System.out.println("product1");
    }
}
