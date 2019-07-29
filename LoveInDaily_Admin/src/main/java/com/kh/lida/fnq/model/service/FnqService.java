package com.kh.lida.fnq.model.service;

import java.util.List;
import java.util.Map;

import com.kh.lida.fnq.model.vo.Fnq;

public interface FnqService {
	
	/**
	 * FNQ 목록 조회
	 * @return
	 */
	List<Map<String, String>> selectFnqList();
	
	/**
	 * FNQ 조회
	 * @param fno
	 * @return
	 */
	Fnq selectOneFnq(int fno);
	
	/**
	 * FNQ 추가
	 * @param f
	 * @return
	 */
	Fnq insertFnq(Fnq f);
	
	/**
	 * FNQ 수정
	 * @param f
	 * @return
	 */
	int updateFnq(Fnq f);
	
	/**
	 * FNQ 삭제
	 * @param fno
	 * @return
	 */
	int deleteFnq(int fno);
	
}
