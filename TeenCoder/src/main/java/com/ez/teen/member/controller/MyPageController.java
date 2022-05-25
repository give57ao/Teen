package com.ez.teen.member.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.service.BoardService;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.MemberService;

@Controller
public class MyPageController {

	@Autowired
	MemberService memberService;
	@Autowired
	BoardService boardService;

	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);
	  
	  @RequestMapping("member")
	  public String myPageList(MemberModel memberModel, Model model) throws Exception{
		  
		  
		 int member_no = 1;
		 memberModel.setMember_no(member_no);
		 
		 List<MemberModel> myPageList = memberService.myPageList(memberModel);
		 model.addAttribute("list", myPageList);
		 
		 model.addAttribute("allBoardCount", boardService.getBoardCount(memberModel));
		 model.addAttribute("allCommentCount", boardService.getCommentCount(memberModel));
			
		 System.out.println(myPageList);
		 
		 return "member/myPage"; 
		 
	  }
	

}
