package com.book.trading;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trade {
	/**
	 * trade中要求的宝石数
	 */
	int gems;
	/**
	 * trade中商品的数量
	 */
	int amount;
	/**
	 * trade的目标商品
	 */
	Goods good;

	/**
	 * 构造方法
	 * @param gems
	 * @param amount
	 * @param good
	 */
	public Trade(int gems, int amount, Goods good) {
		this.gems = gems;
		this.amount = amount;
		this.good = good;
	}

	/**
	 * gems的get 方法
	 * @return
	 */
	public int getGems() {
		return gems;
	}

	/**
	 * amount 的get方法
	 * @return
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * goods的get方法
	 * @return
	 */
	public Goods getGood() {
		return good;
	}

	/**
	 * equals方法，我用的工具自动生成的
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Trade)) {
			return false;
		}
		Trade trade = (Trade) o;
		return gems == trade.gems &&
				amount == trade.amount &&
				good == trade.good;
	}

	/**
	 * hashcode方法，我用的工具自动生成的
	 * @return
	 */
	@Override
	public int hashCode() {
		return Objects.hash(gems, amount, good);
	}

	/**
	 * toString方法，题目要求的格式输出
	 * @return
	 */
	@Override
	public String toString() {
		return gems + " gem for " + amount + " " + good.name();
	}


	/**
	 * 交易执行的方法
	 * @param trader
	 * @param citizen
	 */
	public void execute(Trader trader, Citizen citizen) {
		//获取交易员的交易列表
		List<Trade> trades = trader.getTrades();
		//如果交易员的交易列表已经包含本次交易，则抛出异常，该异常是题目中的一句话，我随便cp过来的
		if (!trades.contains(this)) {
			throw new IllegalArgumentException("the current Trade is not included in the list of trades supported by trader");
		} else {
			//如果交易列表中不包含本次交易，则调用citizen执行交易的方法
			boolean res = citizen.executeTrade(this);
			if (res) {
				//交易成功后，在交易员的交易列表中加入一条交易记录
				trader.addRandomTrade();
			}
		}
	}
}
