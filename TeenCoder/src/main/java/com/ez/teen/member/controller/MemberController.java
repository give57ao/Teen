package com.ez.teen.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.LoginService;
import com.ez.teen.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MemberService memberService;
	
	//비밀번호 암호화,복호화
	@Autowired
    PasswordEncoder passwordEncoder;
	
	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	// 로그인
	@GetMapping("/login")
	public String login() throws Exception {
		return "member/loginForm";
	}
	
	// 로그인 체크
	@RequestMapping("/login")
	public ModelAndView loginCheck(MemberModel memberModel, HttpSession session, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		//암호화된 pw -> 복호화
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPw = memberModel.getMember_pw();
		
		String userPw = loginService.getUserPw(memberModel.getMember_id());
		
		memberModel.setMember_pw(userPw);
		MemberModel member = loginService.login(memberModel);
		
		System.out.println("==========================================");
		System.out.println("사용자가 입력한 pw : " + rawPw);
		System.out.println("DB에 저장된 암호화 pw :" + userPw);
		System.out.println("MEMBER :" + member);
		System.out.println("==========================================");

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
				
    	if(encoder.matches(rawPw, userPw) || rawPw == userPw) {
            session.setAttribute("member_no", member.getMember_no());
            session.setAttribute("member_admin", member.getMember_admin());
            session.setAttribute("member_id", member.getMember_id());
            session.setAttribute("member_nick", member.getMember_nick());
            session.setAttribute("member", member);
    		mv.setViewName("redirect:/");
    	} else {
    		session.setAttribute("member_no", null);
    		out.println("<script type='text/javascript'>alert('로그인 정보를 확인할 수 없습니다. 다시 로그인 해주세요.')</script>");
    		out.flush();
	    	mv.setViewName("member/loginForm");
	    	mv.addObject("msg", false);
    	}    			
    	return mv;
	}
	
    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) throws Exception {
		session.invalidate();
        return "redirect:/";
    }


    @GetMapping("/findId")
    public String findId() {
    	return "member/findIdForm";
    }
    
    @PostMapping("/findId")
    public String findIdResult(Model model, MemberModel memberModel) throws Exception {
    	
    	model.addAttribute("findId", loginService.findId(memberModel));
    	System.out.println(loginService.findId(memberModel));
    	return "member/findId";
    }
    
    
    @GetMapping("/findPw")
    public String findPw() {
    	return "member/findPwForm";
    }
    
    @PostMapping("/findPw")
    public String findPwResult(Model model, MemberModel memberModel) throws Exception {
    	
    	String randomPw = getRandom(10); //사용자에게 보여줄 임시 비밀번호
    	String temPw = passwordEncoder.encode(randomPw); //db에 들어갈 암호화된 비밀번호
    	
    	memberModel.setMember_pw(temPw);
    	memberService.temPwUpdate(memberModel);
    	
    	System.out.println("=================================================");
    	System.out.println("임시 PW : " + randomPw + "실제 암호화 PW :" + temPw);
    	System.out.println("=================================================");

    	model.addAttribute("findPw", randomPw);
    	return "member/findPw";
    }
    
	private String getRandom(int i) {
		String theAlphaNumericS;
		StringBuilder builder;

		theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

		// create the StringBuffer
		builder = new StringBuilder(i);

		for (int m = 0; m < i; m++) {

			// generate numeric
			int myindex = (int) (theAlphaNumericS.length() * Math.random());

			// add the characters
			builder.append(theAlphaNumericS.charAt(myindex));
		}

		return builder.toString();
	}    
   


}
