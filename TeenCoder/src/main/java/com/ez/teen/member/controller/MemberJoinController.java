package com.ez.teen.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberJoinController {

	@Autowired
	private MemberService memberService;

	private static final Logger log = LoggerFactory.getLogger(MemberJoinController.class);

	// 회원가입 화면
	@GetMapping(value = "/join")
	public String insertMember() throws Exception {
		return "/member/joinForm";
	}

	// 아이디 중복확인
	@ResponseBody
	@PostMapping(value = "/checkId")
	public int checkId(MemberModel memberModel) throws Exception {

		int result = memberService.checkId(memberModel);
		
		return result;
	}

	// 닉네임 중복확인
	@ResponseBody
	@PostMapping(value = "/checkNick")
	public int checkNick(MemberModel memberModel) throws Exception {

		int result = memberService.checkNick(memberModel);

		return result;
	}

	// 회원가입 완료
	@PostMapping(value = "/join")
	public String insertMember(MemberModel memberModel) throws Exception {

		int idResult = memberService.checkId(memberModel);
		int nickResult = memberService.checkNick(memberModel);

		try {
			if (idResult == 1 || nickResult == 1) {
				return "/member/joinForm";

			} else if (idResult == 0 && nickResult == 0) {

				memberService.insertMember(memberModel);
				return "/member/loginForm";
			}

		} catch (Exception e) {
			throw new RuntimeException();
			
		}

		return "redirect:/";

	}


}