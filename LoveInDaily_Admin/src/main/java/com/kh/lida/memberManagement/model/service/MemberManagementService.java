package com.kh.lida.memberManagement.model.service;

import java.util.List;
import java.util.Map;

import com.kh.lida.memberManagement.model.vo.Member;

public interface MemberManagementService {

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
	
	
	
	
	
	
}