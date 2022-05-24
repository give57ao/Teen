package com.ez.teen.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.loginService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private loginService loginService;

	//로그 설정
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping("/findIdForm")
	public ModelAndView findIdForm(HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("member/findIdForm");
		return mv;
	}

	@RequestMapping("/findId")
	public ModelAndView FindId(MemberModel memberModel, HttpServletRequest req, RedirectAttributes rttr)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession(); // 없어도 될듯...
		
		MemberModel member = loginService.findId(memberModel);

		mv.setViewName("member/findId");
		mv.addObject("findId", member);

		return mv;
	}

	@RequestMapping(value="/findPw")
	public ModelAndView findPwForm(HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("member/findPwForm");
		return mv;
	}
	
	@RequestMapping("/findPw")
	public ModelAndView FindPw(MemberModel memberModel, HttpServletRequest req, RedirectAttributes rttr)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();

		MemberModel member = loginService.findPw(memberModel);

		mv.setViewName("member/findPw");
		mv.addObject("findPw", member);

		return mv;
	}
	
	// 무시하셔도 됩니다!
	/*
	 * @RequestMapping("/login/loginTest") public ModelAndView login(MemberModel
	 * memberModel) throws Exception { log.info("getMapping login �떎�뻾");
	 * 
	 * MemberModel member = loginService.login(memberModel);
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * mv.setViewName("member/test"); mv.addObject("list", member);
	 * 
	 * return mv;
	 * 
	 * }
	 */

	/*
	 * @PostMapping("/login") public String goLogin() { return "login/loginForm"; }
	 */

}
