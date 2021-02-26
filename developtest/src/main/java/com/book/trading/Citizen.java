package com.book.trading;

import java.util.*;

/**
 * @author: cjz
 * @description: Citizen
 **/
public class Citizen {
    int gems;
    /**
     * 这里使用了Map集合来保存citizen购买的商品
     * Map<key,value> --->  key:商品，value:商品数量
     */
    Map<Goods, Integer> goodsMap = new HashMap<>();

    /**
     * 我不了解你这个方法的含义是什么 所以删除了
     * @param gems
     */
//	public Set<Goods> pack(int amount, List<Integer> good){
//		Set<Goods> goods = new HashSet<>();
//	}


    /**
     * 构造方法
     *
     * @param gems
     */
    public Citizen(int gems) {
        this.gems = gems;
    }

    /**
     * 获取gems的get方法
     *
     * @return
     */
    public int getGems() {
        return gems;
    }


    /**
     * 获取对应商品的数量
     *
     * @param goods
     * @return
     */
    public int getAmount(Goods goods) {
        //如果citizen没有该商品则返回0，否则返回对应数量
        return goodsMap.get(goods) == null ? 0 : goodsMap.get(goods);
    }

    /**
     * 执行交易的过程
     *
     * @param trade
     * @return
     */
    public boolean executeTrade(Trade trade) {
        //trade要求的宝石数量
        int gems = trade.getGems();
        //trade中交易的商品
        Goods goods = trade.getGood();
        //trade中交易的商品数量
        int amount = trade.getAmount();
        //如果citizen拥有的宝石数 <  trade要求的宝石数量 ，返回false
        if (this.gems < gems) {
            return false;
        } else {
            //否则 ，citizen的宝石数减少
            this.gems = this.gems - gems;
            //citizen拥有的商品数量增加
            Integer inventory = this.goodsMap.get(goods) == null ? 0 : this.goodsMap.get(goods);
            this.goodsMap.put(goods, inventory + amount);
        }
        return true;
    }
}
