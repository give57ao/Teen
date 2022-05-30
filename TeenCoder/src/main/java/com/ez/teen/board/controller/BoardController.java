package com.ez.teen.board.controller;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.service.BoardService;


@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	//Get Main Page
	@GetMapping("/")
	public String main(BoardModel boardModel, Model model) {
		
		model.addAttribute("allMemberCount", boardService.getUserCount());
		model.addAttribute("allBoardCount", boardService.getBoardCount());
		model.addAttribute("allCommentCount", boardService.getCommentCount());
		
		return "main";
	}
	
	//게시글 작성 폼
	@GetMapping(value = "board/boardWrite")
	public String insertBoardForm() {
		

		return "board/boardWrite";
	}
	
	
	//게시글 작성 완료
	  
	@PostMapping(value = "board/boardWrite")
	public String insertBoard(BoardModel boardModel, HttpSession session, MultipartHttpServletRequest mpRequest) throws Exception{
//	HttpSession sesssion = request.getSession();
	//	session.setAttribute("member_no", 21);
	int member_no = (Integer)session.getAttribute("member_no");
	System.out.println(member_no);
	boardModel.setMember_no(member_no);
	
	boardService.insertBoard(boardModel, mpRequest);

	return "board/mainBoard"; 
	}
	
	
	// 게시글 목록 메인
	@RequestMapping(value = "board/mainBoard")
	public String mainBoard() {
		
		return "board/mainBoard";
	}
	 
	
}
