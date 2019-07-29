package com.kh.lida.memberManagement.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10000L;
	/**
	 * 
	 */
	
	private int mNo;
	private String mEmail; // 이메일
	private String mPwd;   // 패스워드
	private String mName;  // 이름
	private String mPhone; // 연락처
	private Date mDate;    // 가입일
	private String mLevel; // 회원상태
	
	
	public Member() {
	}


	public Member(int mNo, String mEmail, String mPwd, String mName, String mPhone, Date mDate, String mLevel) {
		this.mNo = mNo;
		this.mEmail = mEmail;
		this.mPwd = mPwd;
		this.mName = mName;
		this.mPhone = mPhone;
		this.mDate = mDate;
		this.mLevel = mLevel;
	}


	public int getmNo() {
		return mNo;
	}


	public void setmNo(int mNo) {
		this.mNo = mNo;
	}


	public String getmEmail() {
		return mEmail;
	}


	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}


	public String getmPwd() {
		return mPwd;
	}


	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getmPhone() {
		return mPhone;
	}


	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}


	public Date getmDate() {
		return mDate;
	}


	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}


	public String getmLevel() {
		return mLevel;
	}


	public void setmLevel(String mLevel) {
		this.mLevel = mLevel;
	}


	@Override
	public String toString() {
		return "Member [mNo=" + mNo + ", mEmail=" + mEmail + ", mPwd=" + mPwd + ", mName=" + mName + ", mPhone="
				+ mPhone + ", mDate=" + mDate + ", mLevel=" + mLevel + "]";
	}
	
	
	
	

}