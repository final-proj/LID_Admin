package com.kh.lida.memberManagement.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.lida.memberManagement.model.vo.Member;

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
	
}
