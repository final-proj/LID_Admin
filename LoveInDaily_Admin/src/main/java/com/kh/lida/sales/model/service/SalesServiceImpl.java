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

}