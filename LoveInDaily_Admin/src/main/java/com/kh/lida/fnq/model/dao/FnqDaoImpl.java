package com.kh.lida.fnq.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.lida.fnq.model.vo.Fnq;

@Repository
public class FnqDaoImpl implements FnqDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Map<String, String>> selectFnqList() {
		return sqlSession.selectList("fnq.selectFnqList");
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
