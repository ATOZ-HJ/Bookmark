package com.bookmark.designpatterns.factorymethod;

/**
 * @author: hj
 * @date: 2021-02-26 16:51
 * @description:
 **/
public class Factory2 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ProductImpl2();
    }
}
