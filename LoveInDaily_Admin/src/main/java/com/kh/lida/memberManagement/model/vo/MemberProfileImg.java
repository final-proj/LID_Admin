package com.kh.lida.memberManagement.model.vo;

import java.io.Serializable;
import java.sql.Date;
import org.springframework.stereotype.Component;

@Component
public class MemberProfileImg implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 653176590518813516L;
	
	private int mpiNo;
	private int mpiMno;
	private String mpiOriginfilename;
	private String mpiChangefilename;
	private String mpiMainimg;
	private Date mpiDate;
	
	public MemberProfileImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberProfileImg(int mpiNo, int mpiMno, String mpiOriginfilename, String mpiChangefilename,
			String mpiMainimg, Date mpiDate) {
		super();
		this.mpiNo = mpiNo;
		this.mpiMno = mpiMno;
		this.mpiOriginfilename = mpiOriginfilename;
		this.mpiChangefilename = mpiChangefilename;
		this.mpiMainimg = mpiMainimg;
		this.mpiDate = mpiDate;
	}
	
	@Override
	public String toString() {
		return "MemberProfileImg [mpiNo=" + mpiNo + ", mpiMno=" + mpiMno + ", mpiOriginfilename=" + mpiOriginfilename
				+ ", mpiChangefilename=" + mpiChangefilename + ", mpiMainimg=" + mpiMainimg + ", mpiDate=" + mpiDate
				+ "]";
	}
	
	public int getMpiNo() {
		return mpiNo;
	}

	public void setMpiNo(int mpiNo) {
		this.mpiNo = mpiNo;
	}

	public int getMpiMno() {
		return mpiMno;
	}

	public void setMpiMno(int mpiMno) {
		this.mpiMno = mpiMno;
	}

	public String getMpiOriginfilename() {
		return mpiOriginfilename;
	}

	public void setMpiOriginfilename(String mpiOriginfilename) {
		this.mpiOriginfilename = mpiOriginfilename;
	}

	public String getMpiChangefilename() {
		return mpiChangefilename;
	}

	public void setMpiChangefilename(String mpiChangefilename) {
		this.mpiChangefilename = mpiChangefilename;
	}

	public String getMpiMainimg() {
		return mpiMainimg;
	}

	public void setMpiMainimg(String mpiMainimg) {
		this.mpiMainimg = mpiMainimg;
	}

	public Date getMpiDate() {
		return mpiDate;
	}

	public void setMpiDate(Date mpiDate) {
		this.mpiDate = mpiDate;
	}

}