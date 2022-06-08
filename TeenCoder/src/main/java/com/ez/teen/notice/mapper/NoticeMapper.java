package com.ez.teen.notice.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.board.model.CommentModel;
import com.ez.teen.board.model.CommentParam;
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

	//공지사항 파일 업로드
	public void insertNotiFile(Map<String, Object> map);
	
	//공지사항 파일 유무체크
	public void NotifileCk(NoticeModel noticeModel);

	//어드민 댓글리스트
	public List<CommentModel> reportCmtList(CommentParam cmtParam);

	//어드민 댓글 삭제
	public void deleteCmt(CommentModel cmtModel);
	

	
		
}
