package com.kh.lida.admin.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Admin implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1281343725431503828L;
	
	private int aNo;
	private String aId;
	private String aPwd;
	private Date aDate;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int aNo, String aId, String aPwd, Date aDate) {
		super();
		this.aNo = aNo;
		this.aId = aId;
		this.aPwd = aPwd;
		this.aDate = aDate;
	}
	
	

	public Admin(String aId, String aPwd) {
		super();
		this.aId = aId;
		this.aPwd = aPwd;
	}

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getaPwd() {
		return aPwd;
	}

	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}

	public Date getaDate() {
		return aDate;
	}

	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}

	
	
	
}
