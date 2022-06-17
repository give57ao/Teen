package com.ez.teen.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ez.teen.member.VerifyRecaptcha;
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
	public String insertMemberForm() throws Exception {
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

	// 회원가입 완료
	@PostMapping(value = "/join")
	public String insertMember(MemberModel memberModel, String member_id, String member_nick) throws Exception {

		int idResult = memberService.checkId(member_id);
		int nickResult = memberService.checkNick(member_nick);

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

	@ResponseBody
	@RequestMapping(value = "/VerifyRecaptcha", method = RequestMethod.POST)
	public int VerifyRecaptcha(HttpServletRequest request) {
		// 시크릿 키를 캡챠를 받아올수 있는 Class에 보내서 그곳에서 값을 출력한다
	    VerifyRecaptcha.setSecretKey("6Lda52AgAAAAAClp3Mh5WpeooyYLUtAroqOrzeCp");
	    String gRecaptchaResponse = request.getParameter("recaptcha");
	    try {
	    
	    	if(VerifyRecaptcha.verify(gRecaptchaResponse)) {
	    		System.out.println("캡차 로그인 성공");
	    		return 0; // 성공
	    	
	    	}
	       else

	    		System.out.println("캡차 로그인 실패");
	    	   return 1; // 실패
	    
	    } catch (Exception e) {
	        e.printStackTrace();
    		System.out.println("캡차 로그인 에러");
	        return -1; //에러
	    }
	}
}
