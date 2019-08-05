package com.kh.lida.memberManagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import com.kh.lida.memberManagement.model.vo.MemberProfile;
import com.kh.lida.memberManagement.model.vo.MemberProfileImg;
import com.kh.lida.memberManagement.model.vo.Report;
import com.kh.lida.notice.model.vo.Notice;

@Controller
public class MemberManagementController {

	@Autowired
	MemberManagementService memberManagementService;


	  

	
	
	  @RequestMapping("/memberManagement/mmForm.do")
	  public String mmForm(Model model) {
	  
	  List<Member> memList = memberManagementService.selectList();
	  
	  List<Report> reportList = memberManagementService.selectListReport();
	  
	  model.addAttribute("memList", memList);
	  
	  model.addAttribute("reportList", reportList);
	  
	  return "memberManagement/memberManagement";
	  
	  }
	  
	  @RequestMapping("/memberManagement/memberReport.do")
	  public String memberReport(@RequestParam(value = "cPage", required = false, defaultValue = "1") int cPage,
				Model model) {
		  
		  int limit = 4;
		  
		  ArrayList<Map<String, String>> list = new ArrayList<>(memberManagementService.selectReportList(cPage, limit));
		  
		  int totalContents = memberManagementService.selectReportTotalContents();

		  
		  String pageBar = Utils.getPageBar(totalContents, cPage, limit, "memberReport.do");

		  model.addAttribute("list", list).addAttribute("totalContents", totalContents).addAttribute("numPerPage", limit)
					.addAttribute("pageBar", pageBar);
		  
		  return "memberManagement/memberReport";
		  
	  }
	  
		@RequestMapping(value="/memberManagement/reportView.do", method = RequestMethod.POST)
		@ResponseBody
		public Report selectOneReport(@RequestParam int rno) {
			
			
			
			return memberManagementService.selectOneReport(rno);

			
		}
	  
	/*
	 * @RequestMapping("/memberManagement/mmDisable.do") public String
	 * mmDisable(@RequestParam int mNo, Model model) {
	 * 
	 * int result = memberManagementService.mmDisable(mNo);
	 * 
	 * String loc = "/memberManagement/mmForm.do"; String msg = "";
	 * 
	 * if (result > 0) { msg = "정지 성공"; } else { msg = "정지 실패"; }
	 * 
	 * model.addAttribute("loc", loc).addAttribute("msg", msg);
	 * 
	 * return "common/msg";
	 * 
	 * }
	 * 
	 * @RequestMapping("/memberManagement/mmAble.do") public String
	 * mmAble(@RequestParam int mNo, Model model) {
	 * 
	 * int result = memberManagementService.mmAble(mNo);
	 * 
	 * String loc = "/memberManagement/mmForm.do"; String msg = "";
	 * 
	 * if (result > 0) { msg = "해제 성공"; } else { msg = "해제 실패"; }
	 * 
	 * model.addAttribute("loc", loc).addAttribute("msg", msg);
	 * 
	 * return "common/msg";
	 * 
	 * }
	 */
	  
	  

}
