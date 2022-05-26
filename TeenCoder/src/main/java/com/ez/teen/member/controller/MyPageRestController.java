package com.ez.teen.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<BoardModel> myBoardList(BoardParam boardParam, HttpSession session,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage
			) {
		
		session.setAttribute("member_no", 2);
		int member_no = (Integer)session.getAttribute("member_no");
		
		int total = boardService.getBoardCount(member_no); 
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		boardParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		boardParam.setMember_no(member_no);
		
		List<BoardModel> list = boardService.myBoardList(boardParam); 
		
		System.out.println(boardParam.getRecent());
		
		return list;
	}
	
	
}
