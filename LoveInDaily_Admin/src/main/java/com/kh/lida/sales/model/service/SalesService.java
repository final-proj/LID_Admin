package com.kh.lida.sales.model.service;

import java.util.List;

import com.kh.lida.sales.model.vo.Sales;

public interface SalesService {

	/**
	 * 티켓 정기권 비율
	 * @return
	 */
	List<Sales> regularTicketChart();
	
}
