package com.bookmark.designpatterns.factorymethod;

/**
 * @author: hj
 * @date: 2021-02-26 16:46
 * @description:
 **/
public class ProductImpl2 implements Product {
    @Override
    public void sell() {
        System.out.println("product2");
    }
}
