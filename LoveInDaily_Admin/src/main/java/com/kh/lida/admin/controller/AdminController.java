package com.kh.lida.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.lida.admin.model.exception.AdminException;
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
	  
	  
	  
	  String loc = "/main.do"; String msg = "";
	  
	  if (result > 0) { msg = "아이디 : admin" + seq + " 패스워드 : " + pw + "입니다."; } else { msg = "회원 가입 실패"; }
	  
	  model.addAttribute("loc", loc).addAttribute("msg", msg);
	  
	  return "common/msg";
	  
	  }
	  
	  @RequestMapping("main.do")
	  public String main() {
		  
		  return "index";
		  
	  }
	  
	  @RequestMapping(value = "/admin/adminLogin.do", method = RequestMethod.POST)
		public ModelAndView adminLogin(@RequestParam String id, @RequestParam String pwd) {

			ModelAndView mv = new ModelAndView();

			try {
				
				Admin a = adminService.selectAdmin(id);

				String loc = "/main.do";
				String msg = "";

				if (a == null) {
					msg = "존재하지 않는 아이디입니다.";
					loc = "/";
				} else {
					if (bcryptPasswordEncoder.matches(pwd, a.getaPwd())) {
						
							msg = "로그인 성공!";
							mv.addObject("admin", a);
						
					} else {
						msg = "비밀번호가 일치하지 않습니다!!";
					}
				}

				mv.addObject("loc", loc).addObject("msg", msg);

				mv.setViewName("common/msg");
			} catch (Exception e) {
				throw new AdminException("로그인 에러 : " + e.getMessage());
			}

			return mv;
		}
	  
	  @RequestMapping("/admin/logout")
		public String memberLogout(SessionStatus sessionStatus) {

			if (!sessionStatus.isComplete()) {
				sessionStatus.setComplete();
			}

			return "redirect:/";
		}
	
}
