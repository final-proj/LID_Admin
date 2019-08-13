package com.kh.lida.chart.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.lida.chart.model.vo.Chart;

@Repository
public class ChartDaoImpl implements ChartDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Chart> regularTicketChart() {
		return sqlSession.selectList("chart.salesTicketChart");
	}

	@Override
	public List<Chart> ageChart() {
		return sqlSession.selectList("chart.salesAgeChart");
	}

	@Override
	public List<Chart> totalChart() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("chart.salesTotalChart");
	}

	@Override
	public List<Chart> regularTicketMonthChart(int element) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("chart.salesTicketMonthChart", element);
	}

	@Override
	public List<Chart> ageMonthChart(int element) {
		System.out.println(sqlSession.selectList("Chart.ChartAgeMonthChart", element));
		return sqlSession.selectList("chart.salesAgeMonthChart", element);
	}

	@Override
	public List<Chart> genderMonthChart(int element) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("chart.salesGenderMonthChart", element);
	}

	@Override
	public List<Chart> genderLineChart() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("chart.chartGenderLineChart");
	}

}
