package com.kh.lida.notice.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.lida.common.util.Utils;
import com.kh.lida.notice.model.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/notice/noticeList.do")
	public String selectNoticeList(@RequestParam(value = "cPage", required = false, defaultValue = "1") int cPage,
			Model model) {
		int limit = 10; // 한 페이지 당 게시글 수

		// 1. 현재 페이지 게시글 목록 가져오기
		ArrayList<Map<String, String>> list = new ArrayList<>(noticeService.selectNoticeList(cPage, limit));

		// 2. 전체 페이지 게시글 수 가져오기
		int totalContents = noticeService.selectNoticeTotalContents();

		String pageBar = Utils.getPageBar(totalContents, cPage, limit, "noticeList.do");

		model.addAttribute("list", list).addAttribute("totalContents", totalContents).addAttribute("numPerPage", limit)
				.addAttribute("pageBar", pageBar);

		return "notice/noticeList";
	}
	
}
