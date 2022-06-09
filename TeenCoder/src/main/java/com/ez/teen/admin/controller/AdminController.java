package com.ez.teen.admin.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ez.teen.admin.model.ReportParam;
import com.ez.teen.admin.service.AdminMemberService;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.model.MemberParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminMemberService adminMemberService;
	
	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	// 회원관리 리스트
	@GetMapping("/memberList")
	public String memberList(MemberModel memberModel, MemberParam memberParam, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword) throws Exception {
		
		int total = adminMemberService.getMemberCount(memberParam);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		} 
		
		memberParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if(total == 0) {
			memberParam.setEndPage(1);
		}
		
		model.addAttribute("paging", memberParam);
		model.addAttribute("member", adminMemberService.memberList(memberParam));
		
        return "admin/memberList";
	}
	
	// 회원정보 수정 폼
	@GetMapping("/memberModify")
	public String memberModifyForm(MemberModel memberModel, MemberParam memberParam, Model model) throws Exception {
		int member_no = memberModel.getMember_no();
		memberModel.setMember_no(member_no);
		
		model.addAttribute("member", adminMemberService.memberModifyForm(memberModel));
		
		return "admin/memberModify";
	}
	
	// 회원정보 수정
	@PostMapping("/memberModify")
	public String memberModify(MemberModel memberModel) throws Exception {
		adminMemberService.memberModify(memberModel);
		return "redirect:/admin/memberList";
	}
	
	// 회원정보 삭제
	@ResponseBody
	@PostMapping("/memberDelete")
	public String memberDelete(MemberModel memberModel) throws Exception {	
		adminMemberService.memberDelete(memberModel);
		return "redirect:/admin/memberList";
	}
	
	@GetMapping("/reportBoard")
	public String myBoardList(Model model, ReportParam reportParam,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword, HttpSession session) {

		int total = adminMemberService.getReportCount(reportParam);

		System.out.println("total :" + total);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		reportParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if (total == 0) {
			reportParam.setEndPage(1);
		}
		model.addAttribute("paging", reportParam);
		model.addAttribute("sort", sort);
		model.addAttribute("reportList", adminMemberService.reportList(reportParam));
		
		System.out.println("reportList");
		System.out.println("total : " + total);
		System.out.println("startPage :" + reportParam.getStartPage());
		System.out.println("endPage :" + reportParam.getEndPage());
		System.out.println("cntPerPage :" + reportParam.getCntPerPage());
		System.out.println("nowPage :" + reportParam.getNowPage());
		System.out.println("lastPage :" + reportParam.getLastPage());

		return "admin/reportBoard";

	}
}