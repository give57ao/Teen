package com.ez.teen.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;

@Mapper
public interface NoticeMapper {

	public int getNoticeCount(NoticeParam noticeParam);

	public List<NoticeModel> noticeList(NoticeParam noticeParam);
}
