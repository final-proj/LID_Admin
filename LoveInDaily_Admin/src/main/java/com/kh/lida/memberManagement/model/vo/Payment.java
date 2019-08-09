package com.kh.lida.memberManagement.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2694436251419257839L;

	private int pNo;
	private String pDate;
	private String pODate;
	private int pTicket;
	private int pMno;
	// 가상변수
	private String pName;
	
	public Payment() {

	}
	
	

	public Payment(int pNo, String pDate, String pODate, int pTicket, String pName) {
		super();
		this.pNo = pNo;
		this.pDate = pDate;
		this.pODate = pODate;
		this.pTicket = pTicket;
		this.pName = pName;
	}



	public Payment(String pDate, String pODate, int pTicket, int pMno) {
		super();
		this.pDate = pDate;
		this.pODate = pODate;
		this.pTicket = pTicket;
		this.pMno = pMno;
	}

	public Payment(int pNo, String pDate, String pODate, int pTicket, int pMno) {
		super();
		this.pNo = pNo;
		this.pDate = pDate;
		this.pODate = pODate;
		this.pTicket = pTicket;
		this.pMno = pMno;
	}

	@Override
	public String toString() {
		return "Payment [pNo=" + pNo + ", pDate=" + pDate + ", pODate=" + pODate + ", pTicket=" + pTicket + ", pMno="
				+ pMno + "]";
	}
	
	

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public String getpODate() {
		return pODate;
	}

	public void setpODate(String pODate) {
		this.pODate = pODate;
	}

	public int getpTicket() {
		return pTicket;
	}

	public void setpTicket(int pTicket) {
		this.pTicket = pTicket;
	}

	public int getpMno() {
		return pMno;
	}

	public void setpMno(int pMno) {
		this.pMno = pMno;
	}

}