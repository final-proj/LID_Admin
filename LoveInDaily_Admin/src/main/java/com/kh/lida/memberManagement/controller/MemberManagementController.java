package com.kh.lida.memberManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.lida.common.util.Utils;
import com.kh.lida.memberManagement.model.service.MemberManagementService;
import com.kh.lida.memberManagement.model.vo.Member;
import com.kh.lida.memberManagement.model.vo.Report;

@Controller
public class MemberManagementController {

	@Autowired
	MemberManagementService memberManagementService;

	@RequestMapping("/memberManagement/mmChart.do")
	  public String mmChart() {

		 return "memberManagement/mmChart";
		 
	}
	
	
	  @RequestMapping("/memberManagement/mmForm.do")
	  public String mmForm(Model model) {
	  
	  List<Member> memList = memberManagementService.selectList();
	  
	  List<Report> reportList = memberManagementService.selectAllListReport();
	  
	  model.addAttribute("memList", memList);
	  
	  model.addAttribute("reportList", reportList);
	  
	  return "memberManagement/memberManagement";
	  
	  }
	  
	  @RequestMapping("/memberManagement/memberReport.do")
	  public String memberReport(@RequestParam(value = "cPage", required = false, defaultValue = "1") int cPage,
				Model model, @RequestParam int mNo) {
		  
		  int limit = 4;
		  
		  ArrayList<Map<String, String>> list = new ArrayList<>(memberManagementService.selectReportList(cPage, limit, mNo));
		  
		  int totalContents = memberManagementService.selectReportTotalContents();

		  Member m = memberManagementService.selectOneMember(mNo);
		  
		  String pageBar = Utils.getPageBar(totalContents, cPage, limit, "memberReport.do");

		  model.addAttribute("list", list).addAttribute("totalContents", totalContents).addAttribute("numPerPage", limit)
					.addAttribute("pageBar", pageBar).addAttribute("member", m);
		  
		  return "memberManagement/memberReport";
		  
	  }
	  
		@RequestMapping(value="/memberManagement/reportView.do", method = RequestMethod.POST)
		@ResponseBody
		public Report selectOneReport(@RequestParam int rno) {
			
			
			
			return memberManagementService.selectOneReport(rno);

			
		}
	  
	
	  @RequestMapping("/memberManagement/mmDisable.do")
	  public String
	  mmDisable(@RequestParam int mNo, Model model, @RequestParam int date) {
	  
	  int result = memberManagementService.mmDisable(mNo, date);
	  
	  String loc = "/memberManagement/mmForm.do";
	  String msg = "";
	  
	  if (result > 0) { msg = "정지 성공"; } else { msg = "정지 실패"; }
	  
	  
	  model.addAttribute("loc", loc).addAttribute("msg", msg);
	  
	  
	  
	  return "common/msg";
	  
	  }
	  
	  @RequestMapping("/memberManagement/mmAble.do") public String
	  mmAble(@RequestParam int mNo, Model model) {
	  
	  int result = memberManagementService.mmAble(mNo);
	  
	  String loc = "/memberManagement/mmForm.do"; String msg = "";
	  
	  if (result > 0) { msg = "해제 성공"; } else { msg = "해제 실패"; }
	  
	  model.addAttribute("loc", loc).addAttribute("msg", msg);
	  
	  return "common/msg";
	  
	  }
	 
	  
	  

}
