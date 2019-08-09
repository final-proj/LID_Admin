package com.kh.lida.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Sales> salesData(){
		List<Sales> list = salesService.regularTicketChart();
		return list;
	}
	
	  @RequestMapping(value = "/sales/salesScdData.do", method =RequestMethod.POST)
	  @ResponseBody public List<Sales> salesScdData(){ 
		List<Sales> list2 = salesService.ageChart();
	  	System.out.println(list2);
	  	return list2; 
	  }
	 
	
	@RequestMapping(value = "/sales/salesThdData.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Sales> salesThdData(){
		List<Sales> list3 = salesService.totalChart();
		return list3;
	}
	
	@RequestMapping(value = "/sales/salesMonthData.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Sales> salesMonthData(@RequestParam int element){
		List<Sales> list = salesService.regularTicketMonthChart(element);
		return list;
	}
	@RequestMapping(value = "/sales/salesMonthCaData.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Sales> salesMonthCaData(@RequestParam(value = "category") String category, @RequestParam(value = "element") int element){
		List<Sales> list2 = null;
		if(category.equals("age")) list2 = salesService.ageMonthChart(element);
		else list2 = salesService.genderMonthChart(element);
		
		return list2;
	}
}
