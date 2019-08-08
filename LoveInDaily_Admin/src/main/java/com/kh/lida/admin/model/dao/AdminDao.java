package com.kh.lida.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.lida.admin.model.vo.Admin;

@Repository
public class AdminDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	public int insertAdmin(Admin a) {

		return sqlSession.insert("admin.insertAdmin", a);
		
	}

	public int selectSeq() {

		return sqlSession.selectOne("admin.selectSeq");
		
	}

	public Admin selectAdmin(String id) {
		
		return sqlSession.selectOne("admin.selectAdmin", id);
		
	}
	
	
}
