package com.kh.lida.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.lida.sales.model.service.SalesService;
import com.kh.lida.sales.model.vo.Sales;

@Controller
public class SalesController {
	
	@Autowired
	SalesService salesService;
	
	@RequestMapping("/sales/salesChart.do")
	public void salesChart() {
	}
	
	@RequestMapping(value = "/sales/salesData.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Sales> salesData(Model model){
		List<Sales> list = salesService.regularTicketChart();
		System.out.println(list);
		
		
		return list;
	}
	
}
