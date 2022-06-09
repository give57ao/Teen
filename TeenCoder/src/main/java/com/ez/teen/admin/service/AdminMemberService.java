package com.ez.teen.admin.service;

import java.util.List;

import com.ez.teen.admin.model.ReportParam;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.model.MemberParam;

public interface AdminMemberService {

	// 전체 회원 수
	public int getMemberCount(MemberParam memberParam);
		
	// 회원관리 리스트
	public List<MemberModel> memberList(MemberParam memberParam) throws Exception;
	
	// 회원정보 수정
	public List<MemberModel> memberModifyForm(MemberModel memberModel) throws Exception;
	
	public void memberModify(MemberModel memberModel) throws Exception;
	
	// 회원정보 삭제
	public void memberDelete(MemberModel memberModel) throws Exception;

	// 게시글 관리
	public List<BoardModel> adminBoard(BoardParam boardParam);

	//신고 게시글 수
	public int getReportCount(ReportParam reportParam);
	
	//신고글 관리 리스트
	public List<BoardModel> reportList(ReportParam reportParam);
	
	//신고글 삭제
	public void deleteReportBoard(BoardModel boardModel);

}