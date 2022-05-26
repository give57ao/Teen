package com.ez.teen.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/")
public class MyPageController {
	@Autowired
	private MemberService memberService;

	@Autowired
	private BoardService boardService;

	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);
	
	@GetMapping("member")
	public String myPageList(MemberModel memberModel, Model model , HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		session.setAttribute("member_no", 1);
		int member_no = (Integer)session.getAttribute("member_no");
		memberModel.setMember_no(member_no);
		List<MemberModel> myPageList = memberService.myPageList(memberModel);
		model.addAttribute("list", myPageList);

		model.addAttribute("allBoardCount", boardService.getBoardCount(member_no));
		model.addAttribute("allCommentCount", boardService.getCommentCount(member_no));

		System.out.println(member_no);
		
		return "member/myPage";

	}

	
	@GetMapping("member/boardList")
	public String myBoardList(Model model, PagingModel pm,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage, HttpSession session) {

		session.setAttribute("member_no", 2);
		int member_no = (Integer)session.getAttribute("member_no");
		
		int total = boardService.getBoardCount(member_no); 
		System.out.println("total :" + total);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		pm = new PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage)); 
		pm.setMember_no(member_no);
		// pm.setRecent("recent"); 최신순 클릭했을 때 recent가 보내지면서 쿼리문이 바뀜
		

		
		model.addAttribute("paging", pm);
		model.addAttribute("board", boardService.boardList(pm));

		return "member/myBoard";
	}

	
}
