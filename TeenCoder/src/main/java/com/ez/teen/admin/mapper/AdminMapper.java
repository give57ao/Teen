package com.ez.teen.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.admin.model.ReportParam;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.model.MemberParam;
import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;

@Mapper
public interface AdminMapper {

	// 전체 회원 수
	public int getMemberCount(MemberParam memberParam);
	
	// 회원관리 리스트
	public List<MemberModel> memberList(MemberParam memberParam);
	
	// 회원정보 수정
	public List<MemberModel> memberModifyForm(MemberModel memberModel);
	
	public void memberModify(MemberModel memberModel);
	
	// 회원정보 삭제
	public void memberDelete(MemberModel memberModel);

	// 게시글 관리
	public List<BoardModel> adminBoard(BoardParam boardParam);

	public List<BoardModel> reportList(ReportParam reportParam);
	
	// 전체 게시글 수
	public int getReportCount(ReportParam reportParam);
	
	// 신고글 삭제
	public void deleteReportBoard(BoardModel boardModel);
	
	// 공지글 리스트
	public List<NoticeModel> noticeBoard(NoticeParam noticeParam);
		
	// 공지글 삭제
	public void noticeBoardDelete(NoticeModel noticeModel);
	
	// 공지글 수정
	public void noticeBoardModify(NoticeModel noticeModel);
	
	// 공지글 첨부파일 조회
	public List<Map<String, Object>> selectNotiFile(int noti_no);

	// 공지글 첨부파일 추가
	public void insertNotiFile(Map<String, Object> map);
	
	// 공지글 첨부파일 수정
	public void updateNotiFile(Map<String, Object> map);
	
	// 공지글 첨부파일 삭제
	public void deleteNotiFile(int file_no);
	
	// 공지글 첨부파일 다운로드
	public Map<String, Object> downNotiFile(Map<String, Object> map);
	
	// summernote
	public void insertSummerNote(String fileName);

}