package com.kh.lida.chart.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Chart implements Serializable {

	private static final long serialVersionUID = 1442038071908173020L;
	
	private String item;
    private int amount;
    private int month;
    private int total;
    private int element;
	public Chart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Chart(String item, int amount, int month, int total, int element) {
		super();
		this.item = item;
		this.amount = amount;
		this.month = month;
		this.total = total;
		this.element = element;
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
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "Sales [item=" + item + ", amount=" + amount + ", month=" + month + ", total=" + total + ", element="
				+ element + "]";
	}

}
