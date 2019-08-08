package com.kh.lida.sales.model.service;

import java.util.List;

import com.kh.lida.sales.model.vo.Sales;

public interface SalesService {

	/**
	 * 정기권 구매 비율
	 * @return
	 */
	List<Sales> regularTicketChart();
	
	/**
	 * 연령별 결제 비율
	 * @return
	 */
	List<Sales> ageChart();
	
	/**
	 * 총 매출
	 * @return
	 */
	List<Sales> totalChart();
	
	/**
	 * 월 선택 정기권 구매 비율
	 * @param element
	 * @return
	 */
	List<Sales> regularTicketMonthChart(int element);
}
