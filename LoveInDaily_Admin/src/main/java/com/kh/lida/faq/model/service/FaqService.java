package com.kh.lida.faq.model.service;

import java.util.List;
import java.util.Map;

import com.kh.lida.faq.model.vo.Faq;

public interface FaqService {
	
	/**
	 * FAQ 목록 조회
	 * @param limit 
	 * @param cPage 
	 * @return
	 */
	List<Map<String, String>> selectFaqList(int cPage, int limit, String fCategory);
	
	/**
	 * FAQ 조회
	 * @param fno
	 * @return
	 */
	Faq selectOneFaq(int fno);
	
	/**
	 * FAQ 추가
	 * @param f
	 * @return
	 */
	int insertFaq(Faq f);
	
	/**
	 * FNQ 수정
	 * @param f
	 * @return
	 */
	int updateFaq(Faq f);
	
	/**
	 * FNQ 삭제
	 * @param fno
	 * @return
	 */
	int deleteFaq(int fno);

	/**
	 * FNQ 전체 페이지 조회
	 * @return
	 */
	int selectFaqTotalContents(String fCategory);
	
}
