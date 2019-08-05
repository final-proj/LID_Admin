package com.kh.lida.memberManagement.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lida.memberManagement.model.dao.MemberManagementDao;
import com.kh.lida.memberManagement.model.vo.Member;
import com.kh.lida.memberManagement.model.vo.MemberProfile;
import com.kh.lida.memberManagement.model.vo.MemberProfileImg;
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
	public int mmDisable(int mNo) {

		return memberManagementDao.mmDisable(mNo);
		
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
	public List<Map<String, String>> selectReportList(int cPage, int limit) {
		// TODO Auto-generated method stub
		return memberManagementDao.selectReportList(cPage, limit);
	}

	@Override
	public int selectReportTotalContents() {

		return memberManagementDao.selectReportTotalContents();
		
	}

	@Override
	public Report selectOneReport(int rno) {
		
		return memberManagementDao.selectOneReport(rno);
		
	}
	
	
	
}
