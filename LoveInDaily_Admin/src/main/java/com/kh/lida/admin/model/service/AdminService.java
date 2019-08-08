package com.kh.lida.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lida.admin.model.dao.AdminDao;
import com.kh.lida.admin.model.vo.Admin;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
	public int selectSeq() {
		
		return adminDao.selectSeq();
		
	}
	
	public int insertAdmin(Admin a) {

		return adminDao.insertAdmin(a);
		
	}

	public Admin selectAdmin(String id) {

		return adminDao.selectAdmin(id);
		
	}
	
	
}
