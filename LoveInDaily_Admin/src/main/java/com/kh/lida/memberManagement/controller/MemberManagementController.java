package com.kh.lida.memberManagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.lida.common.util.Utils;
import com.kh.lida.memberManagement.model.service.MemberManagementService;
import com.kh.lida.memberManagement.model.vo.Member;
import com.kh.lida.memberManagement.model.vo.MemberProfile;
import com.kh.lida.memberManagement.model.vo.Payment;
import com.kh.lida.memberManagement.model.vo.Report;

@SessionAttributes(value = { "member","totalContents", "limit","pageBar","mp","list","payment"})
@Controller
public class MemberManagementController {

	@Autowired
	MemberManagementService memberManagementService;

	  @RequestMapping("/memberManagement/mmForm.do")
	  public String mmForm(Model model) {
	  
	  List<Member> memList = memberManagementService.selectList();
	  
	  List<Report> reportList = memberManagementService.selectAllListReport();
	  
	  model.addAttribute("memList", memList);
	  
	  model.addAttribute("reportList", reportList);
	  
	  return "memberManagement/memberManagement";
	  
	  }
	  
	/*
	 * @RequestMapping("/memberManagement/memberReport.do") public String
	 * memberReport(@RequestParam(value = "cPage", required = false, defaultValue =
	 * "1") int cPage, Model model, @RequestParam int mNo) {
	 * 
	 * int limit = 4;
	 * 
	 * ArrayList<Map<String, String>> list = new
	 * ArrayList<>(memberManagementService.selectReportList(cPage, limit, mNo));
	 * 
	 * int totalContents = memberManagementService.selectReportTotalContents(mNo);
	 * 
	 * Member m = memberManagementService.selectOneMember(mNo);
	 * 
	 * MemberProfile mp = memberManagementService.mmSelectProfile(mNo);
	 * 
	 * String pageBar = Utils.getPageBar(totalContents, cPage, limit,
	 * "memberReport.do");
	 * 
	 * model.addAttribute("list", list).addAttribute("totalContents",
	 * totalContents).addAttribute("numPerPage", limit) .addAttribute("pageBar",
	 * pageBar).addAttribute("member", m).addAttribute("mp",mp);
	 * 
	 * return "memberManagement/memberReport";
	 * 
	 * }
	 */
	  
	  @RequestMapping("/memberManagement/memberReport.do")
	  @ResponseBody
	  public Map memberReport(@RequestParam(value = "cPage", required = false, defaultValue = "1") int cPage,
				@RequestParam int mNo, Model model) {
		  
		  Map<String, Object> map = new HashMap<String, Object>();
		  
		  int limit = 4;
		  
		  ArrayList<Map<String, String>> list = new ArrayList<>(memberManagementService.selectReportList(cPage, limit, mNo));
		  
		  int totalContents = memberManagementService.selectReportTotalContents(mNo);
		  
		  String pageBar = Utils.getPageBar(totalContents, cPage, limit, "mmForm.do");

		  Member m = memberManagementService.selectOneMember(mNo);
		  
		  MemberProfile mp = memberManagementService.mmSelectProfile(mNo);
		  
		  List<Payment> p = memberManagementService.selectPayment(mNo);
		  
		  System.out.println(p);
		  
		  

		  
		  map.put("member", m);
		  map.put("mp",mp);

		  model.addAttribute("list", list);
		  model.addAttribute("totalContents", totalContents);
		  model.addAttribute("numPerPage", limit);
		  model.addAttribute("pageBar", pageBar);
		  model.addAttribute("member", m);
		  model.addAttribute("mp",mp);
		  model.addAttribute("payment",p);
		  
		  
		  return map;
		  
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
