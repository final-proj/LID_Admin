package com.kh.lida.chart.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lida.chart.model.vo.Chart;
import com.kh.lida.chart.model.dao.ChartDao;

@Service
public class ChartServiceImpl implements ChartService {
	
	@Autowired
	private ChartDao chartDao;

	@Override
	public List<Chart> regularTicketChart() {
		
		return chartDao.regularTicketChart();
	}

	@Override
	public List<Chart> ageChart() {
		return chartDao.ageChart();
	}

	@Override
	public List<Chart> totalChart() {
		// TODO Auto-generated method stub
		return chartDao.totalChart();
	}

	@Override
	public List<Chart> regularTicketMonthChart(int element) {
		// TODO Auto-generated method stub
		return chartDao.regularTicketMonthChart(element);
	}

	@Override
	public List<Chart> ageMonthChart(int element) {
		return chartDao.ageMonthChart(element);
	}

	@Override
	public List<Chart> genderMonthChart(int element) {
		// TODO Auto-generated method stub
		return chartDao.genderMonthChart(element);
	}

	@Override
	public List<Chart> genderLineChart() {
		// TODO Auto-generated method stub
		return chartDao.genderLineChart();
	}

}
