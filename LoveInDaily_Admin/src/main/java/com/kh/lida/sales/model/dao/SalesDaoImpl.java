package com.kh.lida.sales.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.lida.sales.model.vo.Sales;

@Repository
public class SalesDaoImpl implements SalesDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Sales> regularTicketChart() {
		return sqlSession.selectList("sales.salesTicketChart");
	}

	@Override
	public List<Sales> agetChart() {
		// TODO Auto-generated method stub
		return null;
		//		return sqlSession.selectList("sales.salesAgeChart");
	}

	@Override
	public List<Sales> totalChart() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("sales.salesTotalChart");
	}

}
