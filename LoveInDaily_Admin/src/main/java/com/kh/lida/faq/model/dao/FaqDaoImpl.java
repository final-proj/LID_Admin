package com.kh.lida.faq.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.lida.faq.model.vo.Faq;

@Repository
public class FaqDaoImpl implements FaqDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Map<String, String>> selectFnqList(int cPage, int limit) {
		RowBounds rows = new RowBounds((cPage -1) * limit, limit);
		return sqlSession.selectList("faq.selectFaqList", null, rows);
	}

	@Override
	public Faq selectOneFaq(int fno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("faq.selectOneFaq", fno);
	}

	@Override
	public int insertFaq(Faq f) {
		// TODO Auto-generated method stub
		return sqlSession.insert("faq.insertFaq", f);
	}

	@Override
	public int updateFaq(Faq f) {
		// TODO Auto-generated method stub
		return sqlSession.update("faq.updateFaq", f);
	}

	@Override
	public int deleteFaq(int fno) {
		// TODO Auto-generated method stub
		return sqlSession.delete("faq.deleteFaq", fno);
	}

	@Override
	public int selectFaqTotalContents() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("faq.selectFaqTotalContents");
	}

}
