package com.ez.teen.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.service.BoardService;

@RestController
@RequestMapping("/member")
public class MyPageRestController {
	
	@Autowired
	private BoardService boardService;

	@PostMapping("/boardList/search")
	public List<BoardModel> myBoardList(BoardParam boardParam
//			,HttpSession session
			) {
//		session.setAttribute("member_no", 2);
		
		List<BoardModel> list = boardService.myBoardList(boardParam); 
		System.out.println(boardParam.getRecent());
		return list;
	}
	
	
}
