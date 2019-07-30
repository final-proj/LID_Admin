package com.kh.lida.memberManagement.model.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemberProfile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7345544216347138474L;
	
	private int mpNo;
	private int mpMno;
	private String mpNickname;
	private String mpGender;
	private int mpAge;
	private String mpIntroduce;
	private String mpAddress;
	private String[] mpHobby;
	private String mpImg;
	
	// 이미지 파일 개수 체크용 가상 컬럼 변수
	private int imgCount;
	
	// 이미지 파일 리스트
	private List<MemberProfileImg> imgList;
	
	public MemberProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberProfile(int mpNo, int mpMno, String mpNickname, String mpGender, int mpAge, String mpIntroduce,
			String mpAddress, String[] mpHobby, String mpImg) {
		super();
		this.mpNo = mpNo;
		this.mpMno = mpMno;
		this.mpNickname = mpNickname;
		this.mpGender = mpGender;
		this.mpAge = mpAge;
		this.mpIntroduce = mpIntroduce;
		this.mpAddress = mpAddress;
		this.mpHobby = mpHobby;
		this.mpImg = mpImg;
	}
	
	

	public MemberProfile(int mpNo, int mpMno, String mpNickname, String mpGender, int mpAge, String mpIntroduce,
			String mpAddress, String[] mpHobby, String mpImg, int imgCount, List<MemberProfileImg> imgList) {
		super();
		this.mpNo = mpNo;
		this.mpMno = mpMno;
		this.mpNickname = mpNickname;
		this.mpGender = mpGender;
		this.mpAge = mpAge;
		this.mpIntroduce = mpIntroduce;
		this.mpAddress = mpAddress;
		this.mpHobby = mpHobby;
		this.mpImg = mpImg;
		this.imgCount = imgCount;
		this.imgList = imgList;
	}
	
	@Override
	public String toString() {
		return "MemberProfile [mpNo=" + mpNo + ", mpMno=" + mpMno + ", mpNickname=" + mpNickname + ", mpGender="
				+ mpGender + ", mpAge=" + mpAge + ", mpIntroduce=" + mpIntroduce + ", mpAddress=" + mpAddress
				+ ", mpHobby=" + Arrays.toString(mpHobby) + ", mpImg=" + mpImg + ", imgCount=" + imgCount + ", imgList="
				+ imgList + "]";
	}

	public int getMpNo() {
		return mpNo;
	}

	public void setMpNo(int mpNo) {
		this.mpNo = mpNo;
	}

	public int getMpMno() {
		return mpMno;
	}

	public void setMpMno(int mpMno) {
		this.mpMno = mpMno;
	}

	public String getMpNickname() {
		return mpNickname;
	}

	public void setMpNickname(String mpNickname) {
		this.mpNickname = mpNickname;
	}

	public String getMpGender() {
		return mpGender;
	}

	public void setMpGender(String mpGender) {
		this.mpGender = mpGender;
	}

	public int getMpAge() {
		return mpAge;
	}

	public void setMpAge(int mpAge) {
		this.mpAge = mpAge;
	}

	public String getMpIntroduce() {
		return mpIntroduce;
	}

	public void setMpIntroduce(String mpIntroduce) {
		this.mpIntroduce = mpIntroduce;
	}

	public String getMpAddress() {
		return mpAddress;
	}

	public void setMpAddress(String mpAddress) {
		this.mpAddress = mpAddress;
	}

	public String[] getMpHobby() {
		return mpHobby;
	}

	public void setMpHobby(String[] mpHobby) {
		this.mpHobby = mpHobby;
	}

	public String getMpImg() {
		return mpImg;
	}

	public void setMpImg(String mpImg) {
		this.mpImg = mpImg;
	}

	public int getImgCount() {
		return imgCount;
	}

	public void setImgCount(int imgCount) {
		this.imgCount = imgCount;
	}

	public List<MemberProfileImg> getImgList() {
		return imgList;
	}

	public void setImgList(List<MemberProfileImg> imgList) {
		this.imgList = imgList;
	}
	
}