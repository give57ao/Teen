package com.ez.teen.member.controller;

import java.util.List;

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
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MyPageController {
	@Autowired
	private MemberService memberService;

	@Autowired
	private BoardService boardService;

	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);
	
	@GetMapping("")
	public String myPageList(MemberModel memberModel, Model model) throws Exception {
		
		//session값 받아오는 로직으로 변경해야함
		int member_no = 1;
//		memberModel.setMember_no(member_no);

		List<MemberModel> myPageList = memberService.myPageList(memberModel);
		model.addAttribute("list", myPageList);

		model.addAttribute("allBoardCount", boardService.getBoardCount(member_no));
		model.addAttribute("allCommentCount", boardService.getCommentCount(member_no));

		System.out.println(myPageList);

		return "member/myPage";

	}

	
	@GetMapping("/boardList")
	public String myBoardList(Model model, PagingModel pm,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage, HttpSession session) {

		//세션값을 받아옴 -> int 타입으로 받는다 int a = 세션값
		int member_no = 2;
		
		int total = boardService.getBoardCount(member_no); //(이안에) <-- a
		System.out.println("total :" + total);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		pm = new PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage)); // 0,1,10
		pm.setMember_no(member_no);
		//session값 받아오는 로직으로 변경해야함
//		int member_no = 1;
//		memberModel.setMember_no(member_no);
		
		model.addAttribute("paging", pm);
		model.addAttribute("board", boardService.boardList(pm));
		
//		System.out.println("startPage :" + pm.getStartPage());
//		System.out.println("endPage :" + pm.getEndPage());
//		System.out.println("nowPage : " + pm.getNowPage());
//		System.out.println("lastPage : " +  pm.getLastPage());

		return "member/myBoard";
	}

	
}
