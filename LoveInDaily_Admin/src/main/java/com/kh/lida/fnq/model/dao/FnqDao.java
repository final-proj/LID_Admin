package com.kh.lida.fnq.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.lida.fnq.model.vo.Fnq;

public interface FnqDao {
	List<Map<String, String>> selectFnqList(int cPage, int limit);

	Fnq selectOneFnq(int fno);

	int insertFnq(Fnq f);

	int updateFnq(Fnq f);

	int deleteFnq(int fno);
	
	int selectFnqTotalContents();
}
