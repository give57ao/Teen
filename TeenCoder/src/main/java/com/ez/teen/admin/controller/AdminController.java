package com.ez.teen.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.admin.model.ChatParam;
import com.ez.teen.admin.model.ReportParam;
import com.ez.teen.admin.service.AdminMemberService;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.service.BoardService;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.model.MemberParam;
import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;
import com.ez.teen.notice.service.NoticeService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminMemberService adminMemberService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private NoticeService noticeService;
	
	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	// 회원관리 리스트
	@GetMapping("/memberList")
	public String memberList(MemberModel memberModel, MemberParam memberParam, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword) {
		
		int total = adminMemberService.getMemberCount(memberParam);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		} 
		
		memberParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if(total == 0) {
			memberParam.setEndPage(1);
		}
		
		model.addAttribute("paging", memberParam);
		model.addAttribute("member", adminMemberService.memberList(memberParam));
		
        return "admin/memberList";
	}
	
	// 회원정보 수정 폼
	@GetMapping("/memberModify")
	public String memberModifyForm(MemberModel memberModel, MemberParam memberParam, Model model) {
		int member_no = memberModel.getMember_no();
		memberModel.setMember_no(member_no);
		
		model.addAttribute("member", adminMemberService.memberModifyForm(memberModel));
		
		return "admin/memberModify";
	}
	
	// 회원정보 수정
	@PostMapping("/memberModify")
	public String memberModify(MemberModel memberModel, ChatParam chatParam, HttpSession session) {
		int member_no = memberModel.getMember_no();
		
		//기존 닉네임을 chatParam에 담기
		chatParam.setMember_nick(adminMemberService.getNick(member_no));
		//수정된 닉네임 chatParam에 담기
		chatParam.setMod_member_nick(memberModel.getMember_nick());
		
		System.out.println("==================================");
		System.out.println("기존닉네임 :"+chatParam.getMember_nick());
		System.out.println("변경될 닉네임 :"+chatParam.getMod_member_nick());
		System.out.println("==================================");

		
		adminMemberService.chatMemberModify(chatParam);
		adminMemberService.memberModify(memberModel);

		return "redirect:/admin/memberList";
	}
	
	// 회원정보 삭제
	@RequestMapping("/memberDelete")
	public String memberDelete(MemberModel memberModel) {	
		adminMemberService.memberDelete(memberModel);
		return "redirect:/admin/memberList";
	}
	
	// 게시글 관리
	@RequestMapping("/adminBoard")
	public String adminBoard(Model model, BoardParam boardParam, 
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value="board_tag_name", required = false)String board_tag_name,
			@RequestParam(value="board_group_no", required = false)String board_group_no) throws Exception {
		
		
		
		if(board_group_no == null) {
			boardParam.setBoard_group_no("1");
		}
		System.out.println("====================================");
		System.out.println("BOARD_TAG_NAME :" + board_tag_name );
		System.out.println("====================================");
		
		int total = boardService.getBoardCount(boardParam);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		} 
		
		boardParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if(total == 0) {
			boardParam.setEndPage(1);
		}
		
		model.addAttribute("paging", boardParam);
		model.addAttribute("sort", sort);
		model.addAttribute("adminBoard", adminMemberService.adminBoard(boardParam));
		
		
		return "admin/adminBoard";
	}
	
	@GetMapping("/reportBoard")
	public String myBoardList(Model model, ReportParam reportParam,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword, HttpSession session) {

		int total = adminMemberService.getReportCount(reportParam);
		
		System.out.println("total :" + total);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		reportParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if (total == 0) {
			reportParam.setEndPage(1);
		}
		model.addAttribute("paging", reportParam);
		model.addAttribute("sort", sort);
		model.addAttribute("reportList", adminMemberService.reportList(reportParam));

		System.out.println("total : " + total);
		System.out.println("startPage :" + reportParam.getStartPage());
		System.out.println("endPage :" + reportParam.getEndPage());
		System.out.println("cntPerPage :" + reportParam.getCntPerPage());
		System.out.println("nowPage :" + reportParam.getNowPage());
		System.out.println("lastPage :" + reportParam.getLastPage());

		return "admin/reportBoard";

	}
	
	@RequestMapping("admin/deleteReportBoard")
	public String deleteReportBoard(BoardModel boardModel) {
		
		adminMemberService.deleteReportBoard(boardModel);
		
		return "redirect:/admin/reportBoard";
	}
	
	// 공지글 관리
	@GetMapping("/noticeBoard")
	public String noticeBoard(Model model, BoardParam boardParam, NoticeParam noticeParam,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword) {

		int total = noticeService.getNoticeCount(noticeParam);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		} 
		
		noticeParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if(total == 0) {
			noticeParam.setEndPage(1);
		}
		
		model.addAttribute("paging", noticeParam);
		model.addAttribute("sort", sort);
		model.addAttribute("notice", adminMemberService.noticeBoard(noticeParam));
		
		return "admin/noticeBoard";
	}
	
	// 공지글 삭제
	@RequestMapping("/noticeBoardDelete")
	public String noticeBoardDelete(NoticeModel noticeModel) {	
		adminMemberService.noticeBoardDelete(noticeModel);
		return "redirect:/admin/noticeBoard";
	}
	
	// 공지글 수정 폼
	@GetMapping("/noticeBoardModify")
	public String noticeBoardModifyForm(
			@RequestParam(value = "noti_no") int noti_no,
			Model model, NoticeParam noticeParam) throws Exception {
		noticeParam.setNoti_no(noti_no);
		
		List<NoticeModel> noticeDetail = noticeService.selectNoticeDetail(noticeParam);
		List<Map<String, Object>> fileList = noticeService.selectNotiFile(noti_no);
		
		model.addAttribute("noticeBoardModify", noticeDetail);
		model.addAttribute("file", fileList);
		
		return "admin/noticeBoardModify";
	}
		
	// 공지글 수정
	@PostMapping("/noticeBoardModify")
	public String noticeBoardModify(NoticeModel noticeModel,
			@RequestParam(value="fileNoDel[]") String[] files,
	        @RequestParam(value="fileNameDel[]") String[] fileNames,
	        MultipartHttpServletRequest mpRequest, Map<String, Object> map) throws Exception {
		adminMemberService.noticeBoardModify(noticeModel, files, fileNames, mpRequest);
		
		return "redirect:/admin/noticeBoard";
	}
	
}