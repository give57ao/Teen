package com.ez.teen.notice.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.board.model.CommentModel;
import com.ez.teen.board.model.CommentParam;
import com.ez.teen.board.service.BoardService;
import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;
import com.ez.teen.notice.service.NoticeService;


@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("board/notice")
	public String noticeBoard(Model model, NoticeModel noticeModel, NoticeParam noticeParam,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword
			) {
		
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
		model.addAttribute("notice", noticeService.noticeList(noticeParam));
		
		
		
		return "board/noticeBoard";
	}
	
	//공지사항 상세페이지
	@GetMapping("board/notice/detail")
	public String noticeDetail(NoticeModel noticeModel, HttpSession session, 
			HttpServletRequest rq, NoticeParam noticeParam, 
			Model model, @RequestParam(value="noti_no")int noti_no) throws Exception {
		
		noticeParam.setNoti_no(noti_no);
		
		List<NoticeModel> noticeDetail = noticeService.selectNoticeDetail(noticeParam);
		List<Map<String, Object>> fileList = noticeService.selectNotiFile(noti_no);
		noticeService.hitCount(noticeModel);

		
		model.addAttribute("file", fileList);
		model.addAttribute("noticeDetail", noticeDetail);

		
		return "board/noticeDetail";
	}
	
	
	
	//공지사항 작성 폼
	@GetMapping(value = "admin/noticeBoardWrite")
	public String insertNoticeForm() {
		return "admin/noticeBoardWrite";
	}
		
	//공지사항 작성 기능
	@PostMapping(value = "admin/noticeBoardWrite")
	public String insertNotice(NoticeModel noticeModel, HttpSession session, MultipartHttpServletRequest mpRequest)throws Exception {
				
		int member_no = (Integer)session.getAttribute("member_no");
			
		noticeModel.setMember_no(member_no);
			
		noticeService.insertNotice(noticeModel, mpRequest);
				
				
		return "redirect:/board/notice";
	}
	
	//댓글관리 리스트
	@GetMapping(value = "admin/reportCmtList")
	public String notiCmtListForm(Model model, CommentParam cmtParam,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword, HttpSession session) {
		
		int total = boardService.getCommentCount(cmtParam);
		
		System.out.println("total :" + total);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		cmtParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if (total == 0) {
			cmtParam.setEndPage(1);
		}
		
		
		model.addAttribute("paging", cmtParam);
		model.addAttribute("sort", sort);
		model.addAttribute("comment", noticeService.reportCmtList(cmtParam));
		
		
		System.out.println("total : " + total);
		
		
		
		return "admin/reportCmtList";
	}
	
	//댓글 관리 삭제 푸쉬
	@RequestMapping(value = "admin/deleteCmt")
	public String reportCmtList(CommentModel cmtModel) throws Exception{
		
		noticeService.deleteCmt(cmtModel);
		
		return "redirect:/admin/reportCmtList";
	}
	
}
