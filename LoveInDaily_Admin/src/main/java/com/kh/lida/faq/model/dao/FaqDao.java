package com.kh.lida.faq.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.lida.faq.model.vo.Faq;

public interface FaqDao {
	List<Map<String, String>> selectFnqList(int cPage, int limit);

	Faq selectOneFaq(int fno);

	int insertFaq(Faq f);

	int updateFaq(Faq f);

	int deleteFaq(int fno);
	
	int selectFaqTotalContents();
}
