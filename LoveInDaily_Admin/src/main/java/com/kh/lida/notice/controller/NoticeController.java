package com.kh.lida.notice.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.kh.lida.common.util.Utils;
import com.kh.lida.notice.model.service.NoticeService;

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
	public void noticeInsert() {
		
	}
	
//	@RequestMapping("/notice/noticeListEnd")
//	public String insertNoticeEnd() {
//		
//	}
	
	@PostMapping("Image.do")
	@ResponseBody
	public void imageUpload(@RequestParam MultipartFile file ,@RequestParam HttpServletRequest request, @RequestParam HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			String folder = request.getSession().getServletContext().getRealPath("/resources");
			UUID uuid = UUID.randomUUID();
			
			String org_fileName = file.getOriginalFilename();
			String str_fileName = uuid.toString() + org_fileName;
			
			String filePath = folder + "/image/" + str_fileName;
			
			File f = new File(filePath);
			if(!f.exists()) f.mkdirs();
			
			out.print("http://localhost:8088/DMG/resources/recipeUpload/" + str_fileName);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
