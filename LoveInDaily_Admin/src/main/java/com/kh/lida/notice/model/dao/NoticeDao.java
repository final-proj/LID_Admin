package com.kh.lida.notice.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.lida.notice.model.vo.Notice;


public interface NoticeDao {
	List<Map<String, String>> selectNoticeList(int cPage, int limit);
	
	int selectNoticeTotalContents();
	
	Notice selectOneNotice(int nno);
	
	int insertNotice(Notice n);
	
	int updateNotice(int nno);
	
	int deleteNotice(int nno);
}
