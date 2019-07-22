package com.kh.lida.salesManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.lida.salesManagement.model.service.SalesManagementService;

@Controller
public class SalesManagementController {
	
	@Autowired
	SalesManagementService salesManagementService;

	@RequestMapping("/salesManagement/totalSales.do")
	public String totalSales() {

		

	}

}
