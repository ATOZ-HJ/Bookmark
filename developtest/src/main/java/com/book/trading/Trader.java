package com.book.trading;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Trader {

    /**
     * 交易集合，用你说的hashSet也可以，但是题目好像要求用这个
     */
    List<Trade> trades;

    /**
     * trades 的 get方法
     * @return
     */
    public List<Trade> getTrades() {
        return trades;
    }

    /**
     * 构造方法，创建Trader对象的时候会默认向 trades 中加入一条交易记录
     */
    public Trader() {
        this.trades = new ArrayList<>();
        addRandomTrade();
    }

    /**
     * 新增一个随机的trade
     */
    public void addRandomTrade() {
        // [0,5) 随机数
        Random random = new Random();
        int gems = random.nextInt(5) + 1;
        int amount = random.nextInt(5) + 1;
        //获取所有的商品枚举
        Goods[] goodsArr = Goods.values();
        int length = goodsArr.length;
        //随机获取一个商品
        Goods goods =  goodsArr[random.nextInt(length)];
        Trade trade = new Trade(gems, amount, goods);
        this.trades.add(trade);
    }
}
