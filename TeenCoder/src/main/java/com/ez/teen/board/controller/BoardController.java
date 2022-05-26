package com.ez.teen.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
}

