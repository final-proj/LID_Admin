package com.kh.lida.notice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.lida.common.util.Utils;
import com.kh.lida.notice.model.service.NoticeService;
import com.kh.lida.notice.model.vo.Notice;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/notice/noticeList.do")
	public String selectNoticeList(@RequestParam(value = "cPage", required = false, defaultValue = "1") int cPage,
			Model model) {
		int limit = 4; // 한 페이지 당 게시글 수

		// 1. 현재 페이지 게시글 목록 가져오기
		ArrayList<Map<String, String>> list = new ArrayList<>(noticeService.selectNoticeList(cPage, limit));
		// 2. 전체 페이지 게시글 수 가져오기
		int totalContents = noticeService.selectNoticeTotalContents();

		String pageBar = Utils.getPageBar(totalContents, cPage, limit, "noticeList.do");

		model.addAttribute("list", list).addAttribute("totalContents", totalContents).addAttribute("numPerPage", limit)
				.addAttribute("pageBar", pageBar);

		return "notice/noticeList";
	}
	
	
	@RequestMapping("/notice/noticeInsert.do")
	public String noticeInsert(Notice n, Model model) {
		
		System.out.println(n);
		int result = noticeService.insertNotice(n);
		
		String loc = "/notice/noticeList.do";
		String msg = "";
		
		if(result > 0) msg = "등록 성공";
		else msg = "등록 실패";
		
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	@RequestMapping(value="/notice/noticeView.do", method = RequestMethod.POST)
	@ResponseBody
	public Notice selectOneNotice(@RequestParam int nno) {
		System.out.println(nno);
		Notice n = noticeService.selectOneNotice(nno);
		return n;
	}

	@RequestMapping("/notice/noticeUpdate")
	public String noticeUpdate(Notice n, Model model) {
		
		int result = noticeService.updateNotice(n);
		String msg ="";
		String loc = "/notice/noticeList.do";
		if(result > 0) msg = "게시글 수정 성공";
		else msg = "게시글 수정 실패";
		
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		return "common/msg";
	}
	
	@RequestMapping("/notice/noticeDelete.do")
	public String noticeDelete(@RequestParam int nno, Model model) {
		System.out.println(nno);
		int result = noticeService.deleteNotice(nno);
		
		String loc = "/notice/noticeList.do";
		String msg = "";
		
		if(result > 0) msg = "게시글 삭제 성공";
		else msg = "게시글 삭제 실패";
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "/common/msg";
	}
	
}
