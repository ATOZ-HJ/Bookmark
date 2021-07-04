package com.bookmark.demo;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author: hj
 * @date: 2021-07-04 15:09
 * @description:
 **/
@Service
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name) {
        return null;
    }
}
