package com.kh.lida.faq.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Faq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5014834214896807018L;
	
	private int fno;
	private String fTitle;
	private String fContent;
	private String fCategory;
	
	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Faq(int fno, String fTitle, String fWriter, String fContent, String fCategory) {
		super();
		this.fno = fno;
		this.fTitle = fTitle;
		this.fContent = fContent;
		this.fCategory = fCategory;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public String getfTitle() {
		return fTitle;
	}

	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}

	public String getfContent() {
		return fContent;
	}

	public void setfContent(String fContent) {
		this.fContent = fContent;
	}

	public String getfCategory() {
		return fCategory;
	}

	public void setfCategory(String fCategory) {
		this.fCategory = fCategory;
	}

	@Override
	public String toString() {
		return "Fnq [fno=" + fno + ", fTitle=" + fTitle + ", fContent=" + fContent
				+ ", fCategory=" + fCategory + "]";
	}
	
}
