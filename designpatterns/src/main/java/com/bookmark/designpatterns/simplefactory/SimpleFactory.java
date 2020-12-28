package com.bookmark.designpatterns.simplefactory;

/**
 * @author: hj
 * @date: 2020-12-26 17:58
 * @description: 简单工厂
 *  1. 将客户类获取实例的对象与实现类之间解耦，客户类无需关注接口有哪些实现
 *  2.
 **/
public class SimpleFactory {
    public static Product getProduct(int type) {
        Product product = null;
        if (type == 1) {
             product = new ProductImpl1();
        }
        if (type == 2) {
            product = new ProductImpl2();
        }
        if (type == 3) {
            product = new ProductImpl3();
        }
        return product;
    }

    public static void main(String[] args) {
        Product product = SimpleFactory.getProduct(1);
    }
}
