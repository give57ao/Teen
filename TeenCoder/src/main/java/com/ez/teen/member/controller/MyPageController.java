package com.ez.teen.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ez.teen.board.service.BoardService;
import com.ez.teen.common.PagingModel;

@Controller
@RequestMapping("/member")
public class MyPageController {

//	@Autowired
//	private MemberService memberService;

	@Autowired
	private BoardService boardService;

	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);

	@GetMapping("/boardList")
	public String myBoardList(PagingModel pm, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage, HttpSession session) {

		int total = boardService.getBoardCount();
		//userno 를 받아야함
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		pm = new PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage)); //0,1,10
		int member_no = 1;
		pm.setMember_no(member_no);
		model.addAttribute("paging", pm);
		model.addAttribute("board", boardService.boardList(pm));	
//		System.out.println("startPage :" + pm.getStartPage());
//		System.out.println("endPage :" + pm.getEndPage());
//		System.out.println("nowPage : " + pm.getNowPage());
//		System.out.println("lastPage : " +  pm.getLastPage());
		
		
		
		return "member/myBoard";
	}
	
	

}
