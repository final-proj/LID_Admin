package com.kh.lida.chart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.lida.chart.model.service.ChartService;
import com.kh.lida.chart.model.vo.Chart;

@Controller
public class ChartController {
	
	@Autowired
	ChartService chartService;
	
	@RequestMapping(value = "/chart/salesData.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Chart> salesData(){
		List<Chart> list = chartService.regularTicketChart();
		return list;
	}
	
	  @RequestMapping(value = "/chart/salesScdData.do", method =RequestMethod.POST)
	  @ResponseBody public List<Chart> salesScdData(){ 
		List<Chart> list2 = chartService.ageChart();
	  	System.out.println(list2);
	  	return list2; 
	  }
	 
	
	@RequestMapping(value = "/chart/salesThdData.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Chart> salesThdData(){
		List<Chart> list3 = chartService.totalChart();
		return list3;
	}
	
	@RequestMapping(value = "/chart/salesMonthData.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Chart> salesMonthData(@RequestParam int element){
		List<Chart> list = chartService.regularTicketMonthChart(element);
		return list;
	}
	@RequestMapping(value = "/chart/salesMonthCaData.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Chart> salesMonthCaData(@RequestParam(value = "category") String category, @RequestParam(value = "element") int element){
		List<Chart> list2 = null;
		if(category.equals("age")) list2 = chartService.ageMonthChart(element);
		else list2 = chartService.genderMonthChart(element);
		
		return list2;
	}
	@RequestMapping(value = "/chart/genderChart.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Chart> genderChart(){
		List<Chart> list2 = chartService.genderLineChart();
		return list2;
	}
}
