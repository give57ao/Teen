package com.ez.teen.follow.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ez.teen.follow.model.MemberFollowModel;
import com.ez.teen.follow.model.MemberFollowParam;
import com.ez.teen.follow.service.FollowService;


@Controller
@RequestMapping(value = "/follow")
public class FollowController {

	@Autowired
	FollowService followService;
	
	
	
	//팔로우 한 사람들의 게시글 보기
	@RequestMapping(value = "/followList")
	public String followListForm(MemberFollowModel followModel,Model model, HttpServletRequest request,
			@RequestParam(value = "nowPage", required = false) String nowPage,
	         @RequestParam(value = "cntPerPage", required = false) String cntPerPage,
	         @RequestParam(value = "sort", required = false) String sort,
	         @RequestParam(value = "search", required = false) String search,
	         @RequestParam(value = "keyword", required = false) String keyword,
	         @RequestParam(value = "member_no" , required = false)int member_no,
	         MemberFollowParam followParam )throws Exception {
		
		followModel.setMember_no(member_no);
		List<MemberFollowModel> followList = followService.followBoardList(followModel);	

		
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
	
	//팔로우 하기
	@PostMapping(value = "/insertFollow")
	@ResponseBody
	public String insertFollow(HttpServletRequest rqRequest,MemberFollowModel followModel, HttpSession session)throws Exception {
		
		int follow_no = (Integer)session.getAttribute("member_no");
		int member_no = Integer.parseInt(rqRequest.getParameter("member_no"));
		String member_nick = (String)rqRequest.getParameter("member_nick");
		
		followModel.setFollow_no(follow_no);
		followModel.setMember_no(member_no);
		followModel.setMember_nick(member_nick);
		
		int followResult = followService.countFollow(followModel);
		
		try {
			if (followResult == 0) {

				followService.insertFollow(followModel);

				return "1";

			} else if (followResult > 0) {

				return "0";
			}

		} catch (Exception e) {
			throw new RuntimeException();

		}

		return "redirect:/follow/myFollowPage";
	}
	
	@RequestMapping(value = "myFollowPage")
	public String myFollowPageForm(MemberFollowModel followModel, HttpSession session, Model model)throws Exception {
		
		int member_no = (Integer)session.getAttribute("member_no");
		followModel.setMember_no(member_no);
		
		List<MemberFollowModel> myFollowPage = followService.myFollowPage(followModel);
		
		model.addAttribute("followPage", myFollowPage);
		
		
		
		return "member/myFollowPage";
	}
	
	
	@RequestMapping(value = "myFollowDelete")
	public String myFollowDelete(HttpSession session, MemberFollowModel followModel,
			@RequestParam(value = "following_member_no")int following_member_no, HttpServletRequest request ) throws Exception {
		
		int member_no = (Integer)session.getAttribute("member_no");
		followModel.setMember_no(member_no);
		followModel.setFollowing_member_no(following_member_no);
		
		followService.myFollowDelete(followModel);
		
		
		return "redirect:/follow/myFollowPage";
		
	}
	
	
}
