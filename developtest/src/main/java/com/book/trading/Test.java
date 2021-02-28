package com.book.trading;

/**
 * @author: hj
 * @date: 2021-02-26 14:31
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        Citizen citizen = new Citizen(10);
        Trader trader = new Trader();
        Trade trade = trader.getTrades().get(0);
        System.out.println("-------------------");
        trade.execute(trader, citizen);
        trade.execute(trader, citizen);
        trade.execute(trader, citizen);
        System.out.println("trade = " + trade);
    }
}
