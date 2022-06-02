package com.ez.teen.admin.controller;

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

import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.model.MemberParam;
import com.ez.teen.member.service.MemberService;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.service.BoardService;
import com.ez.teen.admin.service.AdminMemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminMemberService adminMemberService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	// 회원 관리
	@GetMapping("/memberList")
	public String memberList(Model model, MemberParam memberParam, BoardParam boardParam,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpSession session) {
		
		int member_no = (Integer)session.getAttribute("member_no");
		memberParam.setMember_no(member_no);
		
		int total = boardService.getUserCount();
		
		System.out.println("total :" + total);
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
		memberParam.setMember_no(member_no);
		model.addAttribute("paging", memberParam);
		model.addAttribute("member", boardService.getUserCount());
		
		System.out.println("total : " + total);
        System.out.println("startPage :" + memberParam.getStartPage());
        System.out.println("endPage :" + memberParam.getEndPage());
        System.out.println("cntPerPage :" + memberParam.getCntPerPage());
        System.out.println("nowPage :" + memberParam.getNowPage());
        System.out.println("lastPage :" + memberParam.getLastPage());
        
        return "admin/memberList";
	}
	
}