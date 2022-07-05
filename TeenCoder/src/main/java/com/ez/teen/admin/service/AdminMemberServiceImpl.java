package com.ez.teen.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.admin.mapper.AdminMapper;
import com.ez.teen.admin.model.ChatParam;
import com.ez.teen.admin.model.ReportParam;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.common.file.FileUtil;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.model.MemberParam;
import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private FileUtil fileUtils;
	
	// 전체 회원 수
	@Override
	public int getMemberCount(MemberParam memberParam) {
		return adminMapper.getMemberCount(memberParam);
	}
	
	// 회원관리 리스트
	@Override
	public List<MemberModel> memberList(MemberParam memberParam) {
		return adminMapper.memberList(memberParam);
	}
	
	// 회원정보 수정
	@Override
	public List<MemberModel> memberModifyForm(MemberModel memberModel) {
		return adminMapper.memberModifyForm(memberModel);
	}
	
	@Override
	public void memberModify(MemberModel memberModel) {
		adminMapper.memberModify(memberModel);
	}
	
	// 회원정보 삭제
	@Override
	public void memberDelete(MemberModel memberModel) {
		adminMapper.memberDelete(memberModel);
	}

	// 게시글 관리
	@Override
	public List<BoardModel> adminBoard(BoardParam boardParam) {
		return adminMapper.adminBoard(boardParam);
	}
	// 신고글 관리 리스트
	@Override
	public List<BoardModel> reportList(ReportParam reportParam) {
		return adminMapper.reportList(reportParam);
	}
	
	// 신고 게시글 수
	@Override
	public int getReportCount(ReportParam reportParam) {
		return adminMapper.getReportCount(reportParam);
	}
	
	// 신고글 삭제
	@Override
	public void deleteReportBoard(BoardModel boardModel) {
		adminMapper.deleteReportBoard(boardModel);
	}
	

	// 공지글 리스트
	@Override
	public List<NoticeModel> noticeBoard(NoticeParam noticeParam) {
		return adminMapper.noticeBoard(noticeParam);
	}
	
	// 공지글 삭제
	@Override
	public void noticeBoardDelete(NoticeModel noticeModel) {
		adminMapper.noticeBoardDelete(noticeModel);
	}
	
	// 공지글 수정
	@Override
	public void noticeBoardModify(NoticeModel noticeModel, String[] files, String[] fileNames,
			MultipartHttpServletRequest mpRequest) throws Exception {
		adminMapper.noticeBoardModify(noticeModel);

		List<Map<String, Object>> list = fileUtils.parseUpdateNoticeFileInfo(noticeModel, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			tempMap = list.get(i);
			if (tempMap.get("NEW_FILE").equals("Y")) {
				adminMapper.insertNotiFile(tempMap);
			} else {
				adminMapper.updateNotiFile(tempMap);
			}
		}
	}
	
	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectNotiFile(int noti_no) {
		return adminMapper.selectNotiFile(noti_no);
	}

	// 첨부파일 추가
	@Override
	public void insertNotiFile(Map<String, Object> map) {
		adminMapper.insertNotiFile(map);
	}
	
	// 첨부파일 수정
	@Override
	public void updateNotiFile(Map<String, Object> map) {
		adminMapper.updateNotiFile(map);
	}
	
	// 첨부파일 다운로드
	@Override
	public Map<String, Object> downNotiFile(Map<String, Object> map) {
		return adminMapper.downNotiFile(map);
	}
	
	// summernote
	@Override
	public void insertSummerNote(String fileName) {
		adminMapper.insertSummerNote(fileName);
	}

	//채팅 닉네임 변경
	@Override
	public void chatMemberModify(ChatParam chatParam) {
		adminMapper.chatMemberModify(chatParam);
		adminMapper.chatMemberModify2(chatParam);
	}

	@Override
	public String getNick(int member_no) {
		return adminMapper.getNick(member_no);
	}
	
}