package com.kh.lida.fnq.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.lida.fnq.model.service.FnqService;

@Controller
public class FnqController {

	@Autowired
	FnqService fnqServie;
	
	@RequestMapping("/fnq/fnqList.do")
	public String selectFnqList(Model model) {
		
		List<Map<String, String>> map = fnqServie.selectFnqList();
		model.addAttribute("list", map);
		
		return "fnq/fnqList";
	}
	
}
