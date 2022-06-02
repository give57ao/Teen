package com.ez.teen.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	

	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	// 로그인
	@GetMapping("/login")
	public String login() throws Exception {
		return "member/loginForm";
	}

	// 로그인 체크
	@RequestMapping("/login")
	public ModelAndView loginCheck(MemberModel memberModel, HttpSession session, HttpServletResponse response)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberModel member = loginService.login(memberModel);
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
			
    	if(member != null) {
    		session.setAttribute("member", member);
            session.setAttribute("member_no", member.getMember_no());
            session.setAttribute("member_admin", member.getMember_admin());
    		mv.setViewName("redirect:/");
    	} else {
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
	
	//아이디 찾기 폼
    @GetMapping("/findId")
    public String findId() {
    	return "member/findIdForm";
    }
    
	// 아이디 찾기 기능
    @PostMapping("/findId")
    public String findIdResult(Model model, MemberModel memberModel) throws Exception {
    	
    	model.addAttribute("findId", loginService.findId(memberModel));
    	System.out.println(loginService.findId(memberModel));
    	return "member/findId";
    }
    
    //비밀번호 찾기 폼
    @GetMapping("/findPw")
    public String findPw() {
    	return "member/findPwForm";
    }
    
    // 비밀번호 찾기 기능
    @PostMapping("/findPw")
    public String findPwResult(Model model, MemberModel memberModel) throws Exception {
    	
    	model.addAttribute("findPw", loginService.findPw(memberModel));
    	System.out.println(loginService.findPw(memberModel));
    	return "member/findPw";
    }

    

}