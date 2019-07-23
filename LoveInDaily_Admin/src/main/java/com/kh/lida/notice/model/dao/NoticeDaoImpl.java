package com.kh.lida.notice.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.lida.notice.model.vo.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Map<String, String>> selectNoticeList(int cPage, int limit) {
		RowBounds rows = new RowBounds((cPage -1) * limit, limit);
		return sqlSession.selectList("notice.selectNoticeList", null, rows);
	}

	@Override
	public int selectNoticeTotalContents() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("notice.selectNoticeTotalContents");
	}

	@Override
	public Notice selectOneNotice(int nno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertNotice(Notice n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateNotice(int nno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice(int nno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
