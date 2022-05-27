package com.ez.teen.board.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/board/detail")
	public ModelAndView boardDetail(BoardModel boardModel, HttpSession session, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		int boardNum = (int) session.getAttribute("member_no");
		
		BoardModel model = boardService.getContent(boardModel, boardNum);
		
		
		mv.addObject("Content", model);

		return mv;
	}
}
