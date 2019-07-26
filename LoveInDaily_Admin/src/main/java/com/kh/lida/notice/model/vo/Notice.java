package com.kh.lida.notice.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Notice implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1220L;
	private int nno;
	private String adminId;
	private String nTitle;
	private String nContent;
	private String nDate;
	private String nCount;
	
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(int nno, String adminId, String nTitle, String nContent, String nDate, String nCount) {
		super();
		this.nno = nno;
		this.adminId = adminId;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nDate = nDate;
		this.nCount = nCount;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnDate() {
		return nDate;
	}

	public void setnDate(String nDate) {
		this.nDate = nDate;
	}

	public String getnCount() {
		return nCount;
	}

	public void setnCount(String nCount) {
		this.nCount = nCount;
	}

	@Override
	public String toString() {
		return "Notice [nno=" + nno + ", adminId=" + adminId + ", nTitle=" + nTitle + ", nContent=" + nContent
				+ ", nDate=" + nDate + ", nCount=" + nCount + "]";
	}
	
	
}
