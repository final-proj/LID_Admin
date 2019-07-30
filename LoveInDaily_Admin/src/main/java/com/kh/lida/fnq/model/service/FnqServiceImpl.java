package com.kh.lida.fnq.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lida.fnq.model.dao.FnqDao;
import com.kh.lida.fnq.model.vo.Fnq;

@Service
public class FnqServiceImpl implements FnqService {

	@Autowired
	private FnqDao fnqDao;
	
	@Override
	public List<Map<String, String>> selectFnqList(int cPage, int limit) {
		// TODO Auto-generated method stub
		return fnqDao.selectFnqList(cPage, limit);
	}

	@Override
	public Fnq selectOneFnq(int fno) {
		// TODO Auto-generated method stub
		return fnqDao.selectOneFnq(fno);
	}

	@Override
	public int insertFnq(Fnq f) {
		// TODO Auto-generated method stub
		return fnqDao.insertFnq(f);
	}

	@Override
	public int updateFnq(Fnq f) {
		// TODO Auto-generated method stub
		return fnqDao.updateFnq(f);
	}

	@Override
	public int deleteFnq(int fno) {
		// TODO Auto-generated method stub
		return fnqDao.deleteFnq(fno);
	}

	@Override
	public int selectFnqTotalContents() {
		// TODO Auto-generated method stub
		return fnqDao.selectFnqTotalContents();
	}

}
