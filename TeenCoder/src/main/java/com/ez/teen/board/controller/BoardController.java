package com.ez.teen.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.service.BoardService;
import com.ez.teen.member.model.MemberModel;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@GetMapping("/")
	public String main(BoardModel boardModel, MemberModel memberModel, Model model) {
		log.info("메인페이지 실행");
		
		int member_no = 0;
		
		model.addAttribute("allMemberCount", boardService.getUserCount());
		model.addAttribute("allBoardCount", boardService.getBoardCount(member_no));
		model.addAttribute("allCommentCount", boardService.getCommentCount(member_no));
		
		return "main";
	}
	
	@GetMapping("/member/modify")
	public String updateBoard(BoardModel boardModel, Model model , HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession();
		session.setAttribute("member_no", 2);
		int member_no = (Integer)session.getAttribute("member_no");
		boardModel.setMember_no(member_no);
		
		/* model.addAttribute("update", ); */
		return "board/boardModify";
	}
	
	@PostMapping("/member/modify")
	public String updateBoard(BoardModel boardModel, Model model , HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("member_no", 2);
		int member_no = (Integer)session.getAttribute("member_no");
		boardModel.setMember_no(member_no);
		
		boardService.updateBoard(boardModel);
		
		return "redirect:/board/main";
	}
}

