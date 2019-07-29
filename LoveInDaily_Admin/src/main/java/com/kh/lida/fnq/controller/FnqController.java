package com.kh.lida.fnq.controller;

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
import com.kh.lida.fnq.model.service.FnqService;
import com.kh.lida.fnq.model.vo.Fnq;

@Controller
public class FnqController {

	@Autowired
	FnqService fnqServie;
	
	@RequestMapping("/fnq/fnqList.do")
	public String selectFnqList(@RequestParam(value = "cPage", required = false, defaultValue = "1") int cPage,Model model) {
		int limit = 4; // 한 페이지 당 게시글 수

		// 1. 현재 페이지 게시글 목록 가져오기
		ArrayList<Map<String, String>> list = new ArrayList<>(fnqServie.selectFnqList(cPage, limit));
		// 2. 전체 페이지 게시글 수 가져오기
		int totalContents = fnqServie.selectFnqTotalContents();

		String pageBar = Utils.getPageBar(totalContents, cPage, limit, "noticeList.do");

		model.addAttribute("list", list).addAttribute("totalContents", totalContents).addAttribute("numPerPage", limit)
				.addAttribute("pageBar", pageBar);

		return "fnq/fnqList";
	}
	
	@RequestMapping("/fnq/fnqInsert.do")
	public String insertFnq(Fnq f, Model model) {
		System.out.println(f.getfCategory());
		System.out.println(f);
		int result = fnqServie.insertFnq(f);
		
		String loc = "/fnq/fnqList.do";
		String msg = "";
		
		if(result > 0) msg = "등록 성공";
		else msg = "등록 실패";
		
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	@RequestMapping("/fnq/fnqUpdate.do")
	public String updateFnq(Fnq f, Model model) {
		int result = fnqServie.updateFnq(f);
		
		String loc = "/fnq/fnqList.do";
		String msg = "";
		
		if(result > 0) msg = "수정 성공";
		else msg = "수정 실패";
		
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	@RequestMapping(value = "/fnq/fnqView.do", method = RequestMethod.POST)
	@ResponseBody
	public Fnq selectOneFnq(@RequestParam int fno) {
		Fnq f = fnqServie.selectOneFnq(fno);
		
		return f;
	}
	
	@RequestMapping("/fnq/fnqDelete.do")
	public String deleteFnq(@RequestParam int fno, Model model) {
		int result = fnqServie.deleteFnq(fno);
		
		String loc = "/fnq/fnqList.do";
		String msg = "";
		
		if(result > 0) msg = "삭제 성공";
		else msg = "삭제 실패";
		
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/msg";
	}
	
}
