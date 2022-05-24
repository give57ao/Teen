package com.ez.teen.member.controller;



import javax.servlet.http.HttpSession;

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
	
	
	
		@GetMapping("/boardList")
		public String myBoardList(PagingModel pm, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage, HttpSession session) { 
	
	int total = boardService.getBoardCount();
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		pm = new PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		int memberNo = 1; 
		pm.setMemberNo(memberNo); 
		model.addAttribute("paging", pm);
		model.addAttribute("board", boardService.boardList(pm));
		
		
		return "member/myBoard";
	}
	
	
}
