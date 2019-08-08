package com.kh.lida.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.lida.admin.model.service.AdminService;
import com.kh.lida.admin.model.vo.Admin;

@Controller
public class AdminController {

	  @Autowired
	  AdminService adminService;
	  
	  @Autowired
	  private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	  @RequestMapping("/admin/insertAdmin.do")
	  public String insertAdmin(Model model) {
	  
	  int seq = adminService.selectSeq();
		  
	  String id = "admin" + seq;
	  
	  String pw = "";
	  
	  String bcrPw = "";
	  for(int i = 0; i<6; i++)
	  {
		  pw += (int)(Math.random() * 10);
		  
		  bcrPw = bcryptPasswordEncoder.encode(pw);
		  
	  }
	  
	  Admin a = new Admin(id, bcrPw);
	  
	  int result = adminService.insertAdmin(a);
	  
	  
	  
	  String loc = "/"; String msg = "";
	  
	  if (result > 0) { msg = "아이디 : admin" + seq + " 패스워드 : " + pw + "입니다."; } else { msg = "회원 가입 실패"; }
	  
	  model.addAttribute("loc", loc).addAttribute("msg", msg);
	  
	  return "common/msg";
	  
	  }
	
}
