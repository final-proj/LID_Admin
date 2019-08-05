package com.kh.lida.sales.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Sales implements Serializable {

	private static final long serialVersionUID = 1442038071908173020L;
	
	private String item;
    private int ticket;
    private int month;
    
	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sales(String item, int ticket, int month) {
		super();
		this.item = item;
		this.ticket = ticket;
		this.month = month;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Sales [item=" + item + ", ticket=" + ticket + ", month=" + month + "]";
	}

}
