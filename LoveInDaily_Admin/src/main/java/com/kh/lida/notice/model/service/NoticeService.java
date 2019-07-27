package com.kh.lida.notice.model.service;

import java.util.List;
import java.util.Map;

import com.kh.lida.notice.model.vo.Notice;

public interface NoticeService {
	
	static final int BOARD_SRV_ERROR = 0;
	static final int BOARD_SRV_COMP = 1;
	
	/**
	 * 공지사항 목록 조회
	 * @param cPage
	 * @param limit
	 * @return
	 */
	List<Map<String, String>> selectNoticeList(int cPage, int limit);
	
	/**
	 * 페이징 처리를 위한 총 페이지 갯수
	 * @return
	 */
	int selectNoticeTotalContents();
	
	/**
	 * 공지사항 조회
	 * @param nno
	 * @return
	 */
	Notice selectOneNotice(int nno);
	
	/**
	 * 게시글 추가
	 * @param n
	 * @return
	 */
	int insertNotice(Notice n);
	
	/**
	 * 공지사항 수정
	 * @param nno
	 * @return
	 */
	int updateNotice(Notice n);
	
	/**
	 * 공지사항 삭제
	 * @param nno
	 * @return
	 */
	int deleteNotice(int nno);
	
}
