package com.kh.lida.sales.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Sales implements Serializable {

	private static final long serialVersionUID = 1442038071908173020L;
	
	private String item;
    private int amount;
    private int month;
	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sales(String item, int amount, int month) {
		super();
		this.item = item;
		this.amount = amount;
		this.month = month;
	}

	public String getItem() {
		return item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Sales [item=" + item + ", amount=" + amount + ", month=" + month + "]";
	}

}
