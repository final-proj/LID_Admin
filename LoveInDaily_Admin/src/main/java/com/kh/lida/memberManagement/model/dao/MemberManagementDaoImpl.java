package com.kh.lida.memberManagement.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.lida.memberManagement.model.vo.Member;
import com.kh.lida.memberManagement.model.vo.MemberProfile;
import com.kh.lida.memberManagement.model.vo.MemberProfileImg;
import com.kh.lida.memberManagement.model.vo.Report;
import com.kh.lida.notice.model.vo.Notice;

@Repository
public class MemberManagementDaoImpl implements MemberManagementDao{

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Member> selectList() {
		
		return sqlSession.selectList("member.selectList");
		
	}

	@Override
	public int mmDisable(int mNo) {

		return sqlSession.update("member.mmDisable", mNo);
		
	}

	@Override
	public int mmAble(int mNo) {

		return sqlSession.update("member.mmAble", mNo);
		
	}

	@Override
	public int mmDelete(int mNo) {

		return sqlSession.delete("member.mmDelete", mNo);
		
	}

	@Override
	public MemberProfile mmSelectProfile(int mNo) {

		return sqlSession.selectOne("member.mmSelectProfile", mNo);
		
	}

	@Override
	public MemberProfileImg mmSelectProfileImg(int mNo) {
		
		return sqlSession.selectOne("member.mmSelectProfileImg", mNo);
		
	}

	@Override
	public List<Report> selectListReport() {

		return sqlSession.selectList("member.selectListReport");
		
	}

	@Override
	public List<Map<String, String>> selectReportList(int cPage, int limit) {
		RowBounds rows = new RowBounds((cPage -1) * limit, limit);
		return sqlSession.selectList("member.selectListReport", null, rows);
		
	}

	@Override
	public int selectReportTotalContents() {
		
		return sqlSession.selectOne("member.selectReportTotalContents");
		
	}

	@Override
	public Report selectOneReport(int rno) {

		return sqlSession.selectOne("member.selectOneReport", rno); 
		
	}
	
	
	
}
