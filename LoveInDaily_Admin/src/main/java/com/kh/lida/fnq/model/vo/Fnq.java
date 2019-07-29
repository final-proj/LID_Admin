package com.kh.lida.fnq.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Fnq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5014834214896807018L;
	
	private int fno;
	private String fTitle;
	private String fWriter;
	private String fContent;
	private String fCategory;
	
	public Fnq() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fnq(int fno, String fTitle, String fWriter, String fContent, String fCategory) {
		super();
		this.fno = fno;
		this.fTitle = fTitle;
		this.fWriter = fWriter;
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

	public String getfWriter() {
		return fWriter;
	}

	public void setfWriter(String fWriter) {
		this.fWriter = fWriter;
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
		return "Fnq [fno=" + fno + ", fTitle=" + fTitle + ", fWriter=" + fWriter + ", fContent=" + fContent
				+ ", fCategory=" + fCategory + "]";
	}
	
}
