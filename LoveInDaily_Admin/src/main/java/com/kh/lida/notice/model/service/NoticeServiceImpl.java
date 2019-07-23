package com.kh.lida.notice.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lida.notice.model.dao.NoticeDao;
import com.kh.lida.notice.model.vo.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public List<Map<String, String>> selectNoticeList(int cPage, int limit) {
		return noticeDao.selectNoticeList(cPage, limit);
	}

	@Override
	public int selectNoticeTotalContents() {
		return noticeDao.selectNoticeTotalContents();
	}

	@Override
	public Notice selectOneNotice(int nno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertNotice(Notice n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateNotice(int nno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice(int nno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
