package com.ez.teen.notice.service;

import java.util.List;

import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;

public interface NoticeService {

	public int getNoticeCount(NoticeParam noticeParam);

	public List<NoticeModel> noticeList(NoticeParam noticeParam);

}
