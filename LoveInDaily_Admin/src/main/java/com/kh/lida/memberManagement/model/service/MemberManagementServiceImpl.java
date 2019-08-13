package com.kh.lida.memberManagement.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lida.chart.model.vo.Chart;
import com.kh.lida.memberManagement.model.dao.MemberManagementDao;
import com.kh.lida.memberManagement.model.vo.Member;
import com.kh.lida.memberManagement.model.vo.MemberProfile;
import com.kh.lida.memberManagement.model.vo.MemberProfileImg;
import com.kh.lida.memberManagement.model.vo.Payment;
import com.kh.lida.memberManagement.model.vo.Report;
import com.kh.lida.notice.model.vo.Notice;


@Service
public class MemberManagementServiceImpl implements MemberManagementService{

	@Autowired
	MemberManagementDao memberManagementDao;

	@Override
	public List<Member> selectList() {

		return memberManagementDao.selectList();
		
	}

	@Override
	public int mmDisable(int mNo, int date) {

		int result = 0;

		System.out.println("요긴가");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("mNo", mNo);
		map.put("date", date);
		
		Member m = memberManagementDao.selectOneMember(mNo);
		
		result = memberManagementDao.mmDisable(mNo);
		
		if(m.getmLevel().equals("유료회원"))
		{
			result *= memberManagementDao.mmPayment(map);
		}
		
		
		System.out.println("여기여?");
		
		
		
		System.out.println("여여?");
		
		return result;
		
	}

	@Override
	public int mmAble(int mNo) {

		return memberManagementDao.mmAble(mNo);
		
	}

	@Override
	public int mmDelete(int mNo) {

		return memberManagementDao.mmDelete(mNo);
		
	}

	@Override
	public MemberProfile mmSelectProfile(int mNo) {

		return memberManagementDao.mmSelectProfile(mNo);
		
	}

	@Override
	public MemberProfileImg mmSelectProfileImg(int mNo) {

		return memberManagementDao.mmSelectProfileImg(mNo);
		
	}

	@Override
	public List<Report> selectListReport() {
		
		return memberManagementDao.selectListReport();
		
	}

	@Override
	public List<Map<String, String>> selectReportList(int cPage, int limit, int mNo) {
		// TODO Auto-generated method stub
		return memberManagementDao.selectReportList(cPage, limit, mNo);
	}

	@Override
	public int selectReportTotalContents(int mNo) {

		return memberManagementDao.selectReportTotalContents(mNo);
		
	}

	@Override
	public Report selectOneReport(int rno) {
		
		return memberManagementDao.selectOneReport(rno);
		
	}

	@Override
	public List<Report> selectAllListReport() {
		
		return memberManagementDao.selectAllListReport();
		
	}

	@Override
	public Member selectOneMember(int mNo) {

		return memberManagementDao.selectOneMember(mNo);
		
	}
	
	@Override
	public List<Payment> selectPayment(int mNo) {

		return memberManagementDao.selectPayment(mNo);
		
	}

	@Override
	public List<Payment> selectPaymentList() {

		return memberManagementDao.selectPaymentList();
		
	}

	@Override
	public List<Chart> ageMonthChart(int element) {

		return memberManagementDao.ageMonthChart(element);
		
	}

	@Override
	public List<Chart> genderMonthChart() {

		return memberManagementDao.genderMonthChart();
		
	}

	@Override
	public List<Chart> ageChart() {

		return memberManagementDao.ageChart();
		
	}
	
	
	
	
}
