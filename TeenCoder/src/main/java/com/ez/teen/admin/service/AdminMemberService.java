package com.ez.teen.admin.service;

import java.util.List;

import com.ez.teen.admin.model.ReportParam;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.model.MemberParam;
import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;

public interface AdminMemberService {

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

	// 신고 게시글 수
	public int getReportCount(ReportParam reportParam);
	
	// 신고글 관리 리스트
	public List<BoardModel> reportList(ReportParam reportParam);
	
	// 신고글 삭제
	public void deleteReportBoard(BoardModel boardModel);
	
	// 공지글 리스트
	public List<NoticeModel> noticeBoard(NoticeParam noticeParam);
	
	// 공지글 삭제
	public void noticeBoardDelete(NoticeModel noticeModel);
	
	// 공지글 수정
	public void noticeBoardModify(NoticeModel noticeModel);

}