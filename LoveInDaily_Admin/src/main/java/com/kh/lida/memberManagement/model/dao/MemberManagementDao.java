package com.kh.lida.memberManagement.model.dao;

import java.util.List;

import com.kh.lida.memberManagement.model.vo.Member;
import com.kh.lida.memberManagement.model.vo.MemberProfile;
import com.kh.lida.memberManagement.model.vo.MemberProfileImg;

public interface MemberManagementDao {

	/**
	 * 회원 정보를 모두 조회하는 메소드
	 * @return
	 */
	List<Member> selectList();
	
	/**
	 * 회원 정지를 위한 메소드 
	 * @return
	 */
	int mmDisable(int mNo);
	
	/**
	 * 회원 정지 해제를 위한 메소드
	 * @return
	 */
	int mmAble(int mNo);
	
	/**
	 * 회원 삭제를 위한 메소드 
	 * @return
	 */
	int mmDelete(int mNo);
	
	/**
	 * 회원 프로필을 불러오기 위한 메소드 
	 * @return
	 */
	MemberProfile mmSelectProfile(int mNo);
	
	
	/**
	 * 회원 프로필 이미지을 불러오기 위한 메소드 
	 * @return
	 */
	MemberProfileImg mmSelectProfileImg(int mNo);
	
}
