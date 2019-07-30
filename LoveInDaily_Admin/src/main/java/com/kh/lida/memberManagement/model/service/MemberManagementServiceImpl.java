package com.kh.lida.memberManagement.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lida.memberManagement.model.dao.MemberManagementDao;
import com.kh.lida.memberManagement.model.vo.Member;
import com.kh.lida.memberManagement.model.vo.MemberProfile;
import com.kh.lida.memberManagement.model.vo.MemberProfileImg;


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
		// TODO Auto-generated method stub
		
		return memberManagementDao.mmSelectProfile(mNo);
	}

	@Override
	public MemberProfileImg mmSelectProfileImg(int mNo) {
		// TODO Auto-generated method stub
		return memberManagementDao.mmSelectProfileImg(mNo);
	}
	
	
	
}
