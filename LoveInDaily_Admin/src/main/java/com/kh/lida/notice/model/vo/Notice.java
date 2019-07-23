package com.kh.lida.notice.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Notice implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1220L;
	private String nno;
	private String adminId;
	private String nName;
	private String nContent;
	private String nDate;
	private String nCount;
	
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Notice(String nno, String adminId, String nName, String nContent, String nDate, String nCount) {
		super();
		this.nno = nno;
		this.adminId = adminId;
		this.nName = nName;
		this.nContent = nContent;
		this.nDate = nDate;
		this.nCount = nCount;
	}

	public String getNno() {
		return nno;
	}

	public void setNno(String nno) {
		this.nno = nno;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getnName() {
		return nName;
	}

	public void setnName(String nName) {
		this.nName = nName;
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
		return "Notice [nno=" + nno + ", adminId=" + adminId + ", nName=" + nName + ", nContent=" + nContent
				+ ", nDate=" + nDate + ", nCount=" + nCount + "]";
	}
	
}
