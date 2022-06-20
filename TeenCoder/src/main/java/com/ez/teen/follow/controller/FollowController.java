package com.ez.teen.follow.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ez.teen.follow.model.MemberFollowModel;
import com.ez.teen.follow.model.MemberFollowParam;
import com.ez.teen.follow.service.FollowService;

@Controller
@RequestMapping(value = "/follow")
public class FollowController {

	@Autowired
	FollowService followService;
	
	@RequestMapping("/followList")
	public String followListForm(MemberFollowModel followModel,Model model, HttpSession session,
			@RequestParam(value = "nowPage", required = false) String nowPage,
	         @RequestParam(value = "cntPerPage", required = false) String cntPerPage,
	         @RequestParam(value = "sort", required = false) String sort,
	         @RequestParam(value = "search", required = false) String search,
	         @RequestParam(value = "keyword", required = false) String keyword,
	         MemberFollowParam followParam )throws Exception {
		
		int member_no = (Integer)session.getAttribute("member_no");
		followModel.setMember_no(member_no);
		List<MemberFollowModel> followList = followService.followBoardList(followModel);	
		
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("*********************************************");
			
		
		
		
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println(followList);
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		
		
		
		
		int total = followService.getFollowCount(followParam);

		System.out.println("total :" + total);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		followParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if (total == 0) {
			followParam.setEndPage(1);
		}
		
		
		model.addAttribute("paging", followParam);
		model.addAttribute("sort", sort);
		model.addAttribute("followBoardList", followList);
		
		
		return "member/myFollow";
		
	}
}
