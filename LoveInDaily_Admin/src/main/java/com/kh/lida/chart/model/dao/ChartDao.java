package com.kh.lida.chart.model.dao;

import java.util.List;

import com.kh.lida.chart.model.vo.Chart;

public interface ChartDao {
	List<Chart> regularTicketChart();
	
	List<Chart> ageChart();
	
	List<Chart> totalChart();
	
	List<Chart> regularTicketMonthChart(int element);
	
	List<Chart> ageMonthChart(int element);
	
	List<Chart> genderMonthChart(int element);
	
	List<Chart> genderLineChart();
}
