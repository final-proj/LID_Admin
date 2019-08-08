package com.kh.lida.sales.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lida.sales.model.dao.SalesDao;
import com.kh.lida.sales.model.vo.Sales;

@Service
public class SalesServiceImpl implements SalesService {
	
	@Autowired
	private SalesDao salesDao;

	@Override
	public List<Sales> regularTicketChart() {
		
		return salesDao.regularTicketChart();
	}

	@Override
	public List<Sales> ageChart() {
		return salesDao.ageChart();
	}

	@Override
	public List<Sales> totalChart() {
		// TODO Auto-generated method stub
		return salesDao.totalChart();
	}

	@Override
	public List<Sales> regularTicketMonthChart(int element) {
		// TODO Auto-generated method stub
		return salesDao.regularTicketMonthChart(element);
	}

	@Override
	public List<Sales> ageMonthChart(int element) {
		System.out.println(salesDao.ageMonthChart(element));
		return salesDao.ageMonthChart(element);
	}

	@Override
	public List<Sales> genderMonthChart(int element) {
		// TODO Auto-generated method stub
		return salesDao.genderMonthChart(element);
	}

}
