package com.kh.lida.chart.model.service;

import java.util.List;

import com.kh.lida.chart.model.vo.Chart;

public interface ChartService {

	/**
	 * 정기권 구매 비율
	 * @return
	 */
	List<Chart> regularTicketChart();
	
	/**
	 * 연령별 결제 비율
	 * @return
	 */
	List<Chart> ageChart();
	
	/**
	 * 총 매출
	 * @return
	 */
	List<Chart> totalChart();
	
	/**
	 * 월 선택 정기권 결제 비율
	 * @param element
	 * @return
	 */
	List<Chart> regularTicketMonthChart(int element);
	
	/**
	 * 월 선택 연령별 정기권 결제 비율
	 * @param element
	 * @return
	 */
	List<Chart> ageMonthChart(int element);
	
	/**
	 * 월 선택 성별 정기권 결제 비율
	 * @param element
	 * @return
	 */
	List<Chart> genderMonthChart(int element);
	
	/**
	 * 회원 성별 비율
	 * @return
	 */
	List<Chart> genderLineChart();
	
}
