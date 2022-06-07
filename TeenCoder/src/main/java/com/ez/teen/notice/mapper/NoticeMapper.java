package com.ez.teen.notice.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;

@Mapper
public interface NoticeMapper {

	public int getNoticeCount(NoticeParam noticeParam);

	public List<NoticeModel> noticeList(NoticeParam noticeParam);
	
	//공지사항 작성
	public void insertNotice(NoticeModel noticeModel)throws Exception;

	//공지사항 첨부파일 조회
	public List<Map<String, Object>> selectNotiFile(int noti_no);

	public void insertNotiFile(Map<String, Object> map);
	
	public void NotifileCk(NoticeModel noticeModel);
	
	
}
