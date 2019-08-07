package com.kh.lida.sales.model.dao;

import java.util.List;

import com.kh.lida.sales.model.vo.Sales;

public interface SalesDao {
	List<Sales> regularTicketChart();
	
	List<Sales> ageChart();
	
	List<Sales> totalChart();
	
	List<Sales> regularTicketMonthChart(int element);
}
