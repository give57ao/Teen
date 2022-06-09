package com.ez.teen.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.board.model.CommentModel;
import com.ez.teen.board.model.CommentParam;
import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;

public interface NoticeService {

	public int getNoticeCount(NoticeParam noticeParam);

	public List<NoticeModel> noticeList(NoticeParam noticeParam);
	
	//공지사항 작성 커밋위한 추가
	public void insertNotice(NoticeModel noticeModel, MultipartHttpServletRequest mpRequest) throws Exception;
		
	//공지사항 첨부파일 조회
	public List<Map<String, Object>> selectNotiFile(int noti_no)throws Exception;
	
	//첨부파일 추가
	public void insertNotiFile(Map<String, Object> map)throws Exception;
	
	//댓글 전부 불러오기
	public List<CommentModel> reportCmtList(CommentParam cmtParam);
	
	//댓글 삭제
	public void deleteCmt(CommentModel cmtModel)throws Exception;

}
