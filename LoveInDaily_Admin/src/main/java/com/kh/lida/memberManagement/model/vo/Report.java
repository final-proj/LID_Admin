package com.kh.lida.memberManagement.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Report implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4133928495511878668L;
	
	private int rNo;
	private int rReporter;
	private int rMember;
	private String rContent;
	private Date rDate;
	private String rReporterName;
	private String rMemberName;
	
	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Report(int rNo, int rReporter, int rMember, String rContent, Date rDate) {
		super();
		this.rNo = rNo;
		this.rReporter = rReporter;
		this.rMember = rMember;
		this.rContent = rContent;
		this.rDate = rDate;
	}
	
	

	public Report(int rNo, String rContent, Date rDate, String rReporterName, String rMemberName) {
		super();
		this.rNo = rNo;
		this.rContent = rContent;
		this.rDate = rDate;
		this.rReporterName = rReporterName;
		this.rMemberName = rMemberName;
	}

	@Override
	public String toString() {
		return "Report [rNo=" + rNo + ", rReporter=" + rReporter + ", rMember=" + rMember + ", rContent=" + rContent
				+ ", rDate=" + rDate + "]";
	}
	
	

	public String getrReporterName() {
		return rReporterName;
	}

	public void setrReporterName(String rReporterName) {
		this.rReporterName = rReporterName;
	}

	public String getrMemberName() {
		return rMemberName;
	}

	public void setrMemberName(String rMemberName) {
		this.rMemberName = rMemberName;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getrReporter() {
		return rReporter;
	}

	public void setrReporter(int rReporter) {
		this.rReporter = rReporter;
	}

	public int getrMember() {
		return rMember;
	}

	public void setrMember(int rMember) {
		this.rMember = rMember;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	
	
	
	
	

}
