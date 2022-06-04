package com.ez.teen.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.notice.mapper.NoticeMapper;
import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeMapper noticeMapper;
	
	@Override
	public int getNoticeCount(NoticeParam noticeParam) {
		return noticeMapper.getNoticeCount(noticeParam);
	}

	@Override
	public List<NoticeModel> noticeList(NoticeParam noticeParam) {
		return noticeMapper.noticeList(noticeParam);
	}

}
