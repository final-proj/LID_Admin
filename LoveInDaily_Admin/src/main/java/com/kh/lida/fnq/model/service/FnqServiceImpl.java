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
	public List<Map<String, String>> selectFnqList() {
		return fnqDao.selectFnqList();
	}

	@Override
	public Fnq selectOneFnq(int fno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fnq insertFnq(Fnq f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateFnq(Fnq f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFnq(int fno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
