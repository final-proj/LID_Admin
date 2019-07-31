package com.kh.lida.faq.controller;

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
import com.kh.lida.faq.model.service.FaqService;
import com.kh.lida.faq.model.vo.Faq;

@Controller
public class FaqController {

	@Autowired
	FaqService faqServie;
	
	@RequestMapping("/faq/faqList.do")
	public String selectFaqList(@RequestParam(value = "cPage", required = false, defaultValue = "1") int cPage,Model model) {
		int limit = 6; // 한 페이지 당 게시글 수

		// 1. 현재 페이지 게시글 목록 가져오기
		ArrayList<Map<String, String>> list = new ArrayList<>(faqServie.selectFaqList(cPage, limit));
		// 2. 전체 페이지 게시글 수 가져오기
		int totalContents = faqServie.selectFaqTotalContents();

		String pageBar = Utils.getPageBar(totalContents, cPage, limit, "fnqList.do");

		model.addAttribute("list", list).addAttribute("totalContents", totalContents).addAttribute("numPerPage", limit)
				.addAttribute("pageBar", pageBar);

		return "faq/faqList";
	}
	
	@RequestMapping("/faq/faqInsert.do")
	public String insertFaq(Faq f, Model model) {
		System.out.println(f.getfCategory());
		System.out.println(f);
		int result = faqServie.insertFaq(f);
		
		String loc = "/faq/faqList.do";
		String msg = "";
		
		if(result > 0) msg = "등록 성공";
		else msg = "등록 실패";
		
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	@RequestMapping("/faq/faqUpdate.do")
	public String updateFaq(Faq f, Model model) {
		int result = faqServie.updateFaq(f);
		
		String loc = "/faq/faqList.do";
		String msg = "";
		
		if(result > 0) msg = "수정 성공";
		else msg = "수정 실패";
		
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	@RequestMapping(value = "/faq/faqView.do", method = RequestMethod.POST)
	@ResponseBody
	public Faq selectOneFaq(@RequestParam int fno) {
		Faq f = faqServie.selectOneFaq(fno);
		
		return f;
	}
	
	@RequestMapping("/faq/faqDelete.do")
	public String deleteFaq(@RequestParam int fno, Model model) {
		int result = faqServie.deleteFaq(fno);
		
		String loc = "/faq/faqList.do";
		String msg = "";
		
		if(result > 0) msg = "삭제 성공";
		else msg = "삭제 실패";
		
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/msg";
	}
	
}
