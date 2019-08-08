package com.kh.lida.faq.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lida.faq.model.dao.FaqDao;
import com.kh.lida.faq.model.vo.Faq;

@Service
public class FaqServiceImpl implements FaqService {
	
	@Autowired
	private FaqDao faqDao;

	@Override
	public List<Map<String, String>> selectFaqList(int cPage, int limit, String fCategory) {
		// TODO Auto-generated method stub
		return faqDao.selectFnqList(cPage, limit, fCategory);
	}

	@Override
	public Faq selectOneFaq(int fno) {
		// TODO Auto-generated method stub
		return faqDao.selectOneFaq(fno);
	}

	@Override
	public int insertFaq(Faq f) {
		// TODO Auto-generated method stub
		return faqDao.insertFaq(f);
	}

	@Override
	public int updateFaq(Faq f) {
		// TODO Auto-generated method stub
		return faqDao.updateFaq(f);
	}

	@Override
	public int deleteFaq(int fno) {
		// TODO Auto-generated method stub
		return faqDao.deleteFaq(fno);
	}

	@Override
	public int selectFaqTotalContents(String fCategory) {
		// TODO Auto-generated method stub
		return faqDao.selectFaqTotalContents(fCategory);
	}
	
	
	
	
		
}
