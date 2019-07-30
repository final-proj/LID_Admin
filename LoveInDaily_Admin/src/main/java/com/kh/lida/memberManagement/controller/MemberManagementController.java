package com.kh.lida.memberManagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.lida.memberManagement.model.service.MemberManagementService;
import com.kh.lida.memberManagement.model.vo.Member;

@Controller
public class MemberManagementController {

	@Autowired
	MemberManagementService memberManagementService;

	
	  @RequestMapping("/memberManagement/mmForm.do")
	  public String mmForm(Model model) {
	  
	  List<Member> memList = memberManagementService.selectList();
	  
	  
	  System.out.println(model);
	  
	  model.addAttribute("memList", memList);
	  
	  return "memberManagement/memberManagement";
	  
	  }
	  
	  @RequestMapping("/memberManagement/mmDisable.do")
	  public String mmDisable(@RequestParam int mNo, Model model) {
		  
		 int result = memberManagementService.mmDisable(mNo);

		 String loc = "/memberManagement/mmForm.do";
		 String msg = "";

			if (result > 0) {
				msg = "정지 성공";
			} else {
				msg = "정지 실패";
			}

			model.addAttribute("loc", loc).addAttribute("msg", msg);

			return "common/msg";
		 
	  }
	  
	  @RequestMapping("/memberManagement/mmAble.do")
	  public String mmAble(@RequestParam int mNo, Model model) {
		  
		 int result = memberManagementService.mmAble(mNo);

		 String loc = "/memberManagement/mmForm.do";
		 String msg = "";

			if (result > 0) {
				msg = "해제 성공";
			} else {
				msg = "해제 실패";
			}

			model.addAttribute("loc", loc).addAttribute("msg", msg);

			return "common/msg";
		 
	  }
	  
	  @RequestMapping("/memberManagement/mmSelectProfile.do")
	  public String mmSelectProfile(@RequestParam int mNo) {
		  
		  MemberProfile mp = memberManagementService.mmSelectProfile(mNo);
		  
		  
		  return "";
		  
		  
	  }

}
