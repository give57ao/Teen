package com.ez.teen.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.service.BoardService;

// 동혁 - 브랜치 만들고 확인작업
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	//Get Main Page
	@GetMapping("/")
	public String main(BoardModel boardModel, Model model) {
		log.info("메인페이지 실행");
		
		model.addAttribute("allMemberCount", boardService.getUserCount());
		model.addAttribute("allBoardCount", boardService.getBoardCount());
		model.addAttribute("allCommentCount", boardService.getCommentCount());
		
		return "main";
	}
}
