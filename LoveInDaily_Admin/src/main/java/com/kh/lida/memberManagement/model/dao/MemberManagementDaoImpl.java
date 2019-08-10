package com.kh.lida.memberManagement.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.lida.memberManagement.model.vo.Member;
import com.kh.lida.memberManagement.model.vo.MemberProfile;
import com.kh.lida.memberManagement.model.vo.MemberProfileImg;
import com.kh.lida.memberManagement.model.vo.Payment;
import com.kh.lida.memberManagement.model.vo.Report;
import com.kh.lida.notice.model.vo.Notice;
import com.kh.lida.sales.model.vo.Sales;

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
	public int mmPayment(Map map) {

		return sqlSession.update("member.mmPayment", map);
		
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
	public List<Map<String, String>> selectReportList(int cPage, int limit, int mNo) {
		RowBounds rows = new RowBounds((cPage -1) * limit, limit);
		return sqlSession.selectList("member.selectListReport", mNo , rows);
		
	}

	@Override
	public int selectReportTotalContents(int mNo) {
		
		return sqlSession.selectOne("member.selectReportTotalContents", mNo);
		
	}

	@Override
	public Report selectOneReport(int rno) {

		return sqlSession.selectOne("member.selectOneReport", rno); 
		
	}

	@Override
	public List<Report> selectAllListReport() {

		return sqlSession.selectList("member.selectAllListReport");
		
	}

	@Override
	public Member selectOneMember(int mNo) {
		
		return sqlSession.selectOne("member.selectOneMember",mNo);
		
	}

	@Override
	public List<Payment> selectPayment(int mNo) {

		return sqlSession.selectList("member.selectPayment", mNo);
		
	}

	@Override
	public List<Payment> selectPaymentList() {

		return sqlSession.selectList("member.selectPaymentList");
		
	}

	@Override
	public List<Sales> ageMonthChart(int element) {

		return sqlSession.selectList("member.memberAgeMonthChart", element);
		
	}

	@Override
	public List<Sales> genderMonthChart() {

		return sqlSession.selectList("member.memberGenderMonthChart");
		
	}

	@Override
	public List<Sales> ageChart() {
		
		return sqlSession.selectList("member.memberAgeChart");
		
	}

	
	
	
	
}
