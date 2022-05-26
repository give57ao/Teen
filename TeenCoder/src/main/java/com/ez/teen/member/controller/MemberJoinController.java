package com.ez.teen.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberJoinController {

	@Autowired
	MemberService memberService;

	private static final Logger log = LoggerFactory.getLogger(MemberJoinController.class);

	// 회원가입 화면
	@GetMapping(value = "/joinForm")
	public String insertMember() throws Exception {
		return "/member/joinForm";
	}

	// 아이디 중복확인
	@PostMapping(value = "/checkId")
	@ResponseBody
	public int checkId(String member_id) throws Exception {

		int result = memberService.checkId(member_id);
		return result;
	}

	// 닉네임 중복확인
	@PostMapping(value = "/checkNick")
	@ResponseBody
	public int checkNick(String member_nick) throws Exception {

		int result = memberService.checkNick(member_nick);
		return result;
	}

	// 이메일 중복확인
	@PostMapping(value = "/checkEmail")
	@ResponseBody
	public int checkEmail(String member_email) throws Exception {

		int result = memberService.checkEmail(member_email);
		return result;
	}

	// 회원가입 완료
	@PostMapping(value = "/joinForm")
	public String insertMember(MemberModel memberModel, String member_id, String member_nick, String member_email)
			throws Exception {

		int idResult = memberService.checkId(member_id);
		int nickResult = memberService.checkNick(member_nick);
		int emailResult = memberService.checkEmail(member_email);

		try {
			if (idResult == 1 || nickResult == 1 || emailResult == 1) {
				return "/member/joinForm";

			} else if (idResult == 0 && nickResult == 0 && emailResult == 0) {

				memberService.insertMember(memberModel);
				return "/member/loginForm";
			}

		} catch (Exception e) {
			throw new RuntimeException();
		}

		return "redirect:/";

	}

	/*
	 * // 회원탈퇴 홈페이지
	 * 
	 * @GetMapping(value = "/delete") public String deleteMemberForm() throws
	 * Exception {
	 * 
	 * return "/member/deleteForm"; }
	 * 
	 * // 회원 탈퇴 구현
	 * 
	 * @PostMapping(value = "/delete") public String deleteMember(MemberModel model,
	 * HttpSession session, RedirectAttributes rttr) throws Exception {
	 * 
	 * MemberModel member = (MemberModel) session.getAttribute("member");
	 * 
	 * String sessionPw = member.getMember_pw(); String modelPw =
	 * model.getMember_pw();
	 * 
	 * if (!(sessionPw.equals(modelPw))) { rttr.addFlashAttribute("msg", false);
	 * 
	 * return "/member/delete"; }
	 * 
	 * memberService.deleteMember(model); session.invalidate();
	 * 
	 * return "redirect:/"; }
	 */

}
