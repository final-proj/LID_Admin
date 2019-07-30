package com.kh.lida.fnq.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.lida.fnq.model.vo.Fnq;

@Repository
public class FnqDaoImpl implements FnqDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Map<String, String>> selectFnqList(int cPage, int limit) {
		RowBounds rows = new RowBounds((cPage -1) * limit, limit);
		return sqlSession.selectList("fnq.selectFnqList", null, rows);
	}

	@Override
	public Fnq selectOneFnq(int fno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("fnq.selectOneFnq", fno);
	}

	@Override
	public int insertFnq(Fnq f) {
		// TODO Auto-generated method stub
		return sqlSession.insert("fnq.insertFnq", f);
	}

	@Override
	public int updateFnq(Fnq f) {
		// TODO Auto-generated method stub
		return sqlSession.update("fnq.updateFnq", f);
	}

	@Override
	public int deleteFnq(int fno) {
		// TODO Auto-generated method stub
		return sqlSession.delete("fnq.deleteFnq", fno);
	}

	@Override
	public int selectFnqTotalContents() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("fnq.selectFnqTotalContents");
	}

}
