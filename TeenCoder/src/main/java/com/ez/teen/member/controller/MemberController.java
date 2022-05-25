package com.ez.teen.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.LoginService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private LoginService loginService;
	
	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
   
    // 로그인
    @GetMapping("/login")
    public String login() throws Exception {
    	return "member/loginForm";
    }
    
    // 로그인 체크
    @PostMapping("/login")
    public String loginCheck(MemberModel memberModel, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
    	HttpSession session = req.getSession();
    	MemberModel member = loginService.login(memberModel);
    	
    	if(session.getAttribute("member") != null) {
    		session.removeAttribute("member");
    	}
    	
    	if(member != null) { // 로그인 성공
    		session.setAttribute("member", member);
    		rttr.addFlashAttribute("msg", "success");
    	} else { // 로그인 실패
    		session.setAttribute("member", null);
    		rttr.addFlashAttribute("msg", "failure");
    		return "redirect:/member/login";
    	}
    	
		return "redirect:/";
    }
    
    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) throws Exception {
    	session.invalidate();
    	return "redirect:/";
    }
	
	// 아이디 입력
	@RequestMapping("/findIdForm")
	public ModelAndView findIdForm() throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("member/findIdForm");
		
		return mv;
	}
	
	// 아이디 찾기
	@RequestMapping("/findId")
	public ModelAndView findId(MemberModel memberModel) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberModel member = loginService.findId(memberModel);

		mv.setViewName("member/findId");
		mv.addObject("findId", member);

		return mv;
	}
	
	// 비밀번호 입력
	@RequestMapping("/findPwForm")
	public ModelAndView findPwForm() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/findPwForm");
		
		return mv;
	}
	
	// 비밀번호 찾기
	@RequestMapping("/findPw")
	public ModelAndView findPw(MemberModel memberModel) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberModel member = loginService.findPw(memberModel);

		mv.setViewName("member/findPw");
		mv.addObject("findPw", member);

		return mv;
	}
    
}