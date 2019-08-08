package com.kh.lida.memberManagement.model.service;

import java.util.List;
import java.util.Map;

import com.kh.lida.memberManagement.model.vo.Member;
import com.kh.lida.memberManagement.model.vo.MemberProfile;
import com.kh.lida.memberManagement.model.vo.MemberProfileImg;
import com.kh.lida.memberManagement.model.vo.Payment;
import com.kh.lida.memberManagement.model.vo.Report;
import com.kh.lida.notice.model.vo.Notice;

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
	int mmDisable(int mNo, int date);
	
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
	 * 회원 프로필 불러오기 위한 메소드 
	 * @return
	 */
	MemberProfile mmSelectProfile(int mNo);
	
	/**
	 * 회원 프로필  이미지를 불러오기 위한 메소드 
	 * @return
	 */
	MemberProfileImg mmSelectProfileImg(int mNo);

	/**
	 * 전체 신고 리스트을 불러오기 위한 메소드
	 * @return
	 */
	List<Report> selectListReport();
	
	List<Report> selectAllListReport();
	
	/**
	 * 개별 신고 리스트 조회
	 * @param cPage
	 * @param limit
	 * @return
	 */
	List<Map<String, String>> selectReportList(int cPage, int limit, int mNo);
	
	/**
	 * 페이징 처리를 위한 총 페이지 갯수
	 * @return
	 */
	int selectReportTotalContents(int mNo);
	
	/**
	 * 신고내역 조회
	 * @param rno
	 * @return
	 */
	Report selectOneReport(int rno);
	
	Member selectOneMember(int mNo);
	
	List<Payment> selectPayment(int mNo);
	
}
