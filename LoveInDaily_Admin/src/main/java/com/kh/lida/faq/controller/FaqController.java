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
import com.kh.lida.notice.model.service.NoticeService;
import com.kh.lida.notice.model.vo.Notice;

@Controller
public class FaqController {

	@Autowired
	FaqService faqServie;
	@Autowired
	NoticeService noticeServie;
	
	@RequestMapping("/faq/faqList.do")
	public String selectFaqList(@RequestParam(value = "cPage", required = false, defaultValue = "1") int cPage,Model model) {
		int limit =8; // 한 페이지 당 게시글 수
		// 1. 현재 페이지 게시글 목록 가져오기
		ArrayList<Map<String, String>> list = new ArrayList<>(faqServie.selectFaqList(cPage, limit));
		System.out.println(list);
		// 2. 전체 페이지 게시글 수 가져오기
		int totalContents = faqServie.selectFaqTotalContents();

		String pageBar = Utils.getPageBar(totalContents, cPage, limit, "faqList.do");

		model.addAttribute("list", list).addAttribute("totalContents", totalContents).addAttribute("numPerPage", limit)
				.addAttribute("pageBar", pageBar);

		return "faq/faqList";
	}
	
	@RequestMapping("/faq/insert.do")
	public String insertFaq(@RequestParam(value = "writer") String writer, @RequestParam(value = "title") String title, @RequestParam(value = "content") String content, @RequestParam(value = "selectBoard") int selectBoard, @RequestParam(value = "fCategory", required = false) String fCategory ,Model model) {
		String loc = "";
		String msg = "";
		int result = 0;
		if(selectBoard == 2) {
			Faq f = new Faq(title, content, fCategory);
			result = faqServie.insertFaq(f);
			
			loc = "/faq/faqList.do";
			System.out.println("Asdfa");
			if(result > 0) msg = "등록 성공";
			else msg = "등록 실패";
		} else {
			Notice n = new Notice(writer, title, content);
			System.out.println(n);
			result = noticeServie.insertNotice(n);
			loc="/notice/noticeList.do";
			if(result > 0) msg = "등록 성공";
			else msg = "등록 실패";
			System.out.println("Asdfa");
		}
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
