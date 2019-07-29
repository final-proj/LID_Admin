package com.kh.lida.fnq.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.lida.fnq.model.vo.Fnq;

public interface FnqDao {
	List<Map<String, String>> selectFnqList();

	Fnq selectOneFnq(int fno);

	Fnq insertFnq(Fnq f);

	int updateFnq(Fnq f);

	int deleteFnq(int fno);
}
