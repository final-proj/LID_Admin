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
	public List<Sales> ageChart() {
		return sqlSession.selectList("sales.salesAgeChart");
	}

	@Override
	public List<Sales> totalChart() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("sales.salesTotalChart");
	}

	@Override
	public List<Sales> regularTicketMonthChart(int element) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("sales.salesTicketMonthChart", element);
	}

	@Override
	public List<Sales> ageMonthChart(int element) {
		System.out.println(sqlSession.selectList("sales.salesAgeMonthChart", element));
		return sqlSession.selectList("sales.salesAgeMonthChart", element);
	}

	@Override
	public List<Sales> genderMonthChart(int element) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("sales.salesGenderMonthChart", element);
	}

}
