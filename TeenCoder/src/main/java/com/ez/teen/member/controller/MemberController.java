package com.ez.teen.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

	// 컨트롤 시작
	// 로그인

	
	/*
	 * @GetMapping("/login") public String login() throws Exception { return
	 * "member/loginForm"; }
	 * 
	 * // 로그인 체크
	 * 
	 * @RequestMapping("/login") public ModelAndView loginCheck(MemberModel
	 * memberModel, HttpSession session, HttpServletResponse response) throws
	 * Exception { ModelAndView mv = new ModelAndView(); MemberModel member =
	 * loginService.login(memberModel);
	 * response.setContentType("text/html; charset=utf-8"); PrintWriter out =
	 * response.getWriter();
	 * 
	 * session.setAttribute("member_no", 1); int member_no = (Integer)
	 * session.getAttribute("member_no");
	 * 
	 * if (member != null) { session.setAttribute("member_no",
	 * member.getMember_no()); mv.setViewName("redirect:/"); } else { //
	 * session.setAttribute("member_no", null); out.
	 * println("<script type='text/javascript'>alert('로그인 정보를 확인할 수 없습니다. 다시 로그인 해주세요.')</script>"
	 * ); out.flush(); mv.setViewName("member/loginForm"); mv.addObject("msg",
	 * false); }
	 * 
	 * return mv; }
	 */
	 

	@RequestMapping("/findIdForm")
	public ModelAndView findIdForm(MemberModel memberModel, HttpServletRequest req)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberModel member = loginService.findId(memberModel);
		

		mv.setViewName("member/findIdForm");
		mv.addObject("findId", member);

		return mv;
	}

	@RequestMapping("/findId")
	public ModelAndView FindId(MemberModel memberModel, HttpServletRequest req, HttpServletResponse response)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		//HttpSession session = req.getSession(); // 없어도 될듯...
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		MemberModel member = loginService.findId(memberModel);
		
		/*
		 * List<MemberModel> member_id = loginService.findMemberId(memberModel);
		 * MemberModel member_name = loginService.findMemberName(memberModel);
		 * MemberModel member_email = loginService.findMemberEmail(memberModel);
		 */
		
		
		if (member != null) {
			mv.setViewName("member/findId");
			mv.addObject("findId", member);
			return mv;
		} else {
			/*
			 * if(member_email.getMEMBER_EMAIL() != req.getParameter("MEMBER_EMAIL")) {
			 * System.out.println(member_id.getMEMBER_ID());
			 * out.println("<script type='text/javascript'>alert('이메일 불일치.')</script>");
			 * mv.setViewName("member/findIdForm"); return mv; }
			 * if(member_name.getMEMBER_NAME() != req.getParameter("MEMBER_NAME")) {
			 * System.out.println(member_id.getMEMBER_ID());
			 * out.println("<script type='text/javascript'>alert('이름 불일치.')</script>");
			 * mv.setViewName("member/findIdForm"); return mv; }
			 */
			out.println("<script type='text/javascript'>alert('입력정보 일치x')</script>");
			out.flush();
			mv.setViewName("member/findIdForm");
			return mv;
		}
		
	}

	@RequestMapping(value = "/findPwForm")
	public ModelAndView findPwForm(HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("member/findPwForm");
		return mv;
	}

	@RequestMapping("/findPw")
	public ModelAndView FindPw(MemberModel memberModel, HttpServletRequest req, HttpServletResponse response)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberModel member = loginService.findPw(memberModel);

		if (member != null) {
			mv.setViewName("member/findPw");
			mv.addObject("findPw", member);
			return mv;
		} else {
			out.println("<script type='text/javascript'>alert('입력정보 일치x')</script>");
			out.flush();
			mv.setViewName("member/findPwForm");
			return mv;
		}
	}

	// 무시하셔도 됩니다!
	@RequestMapping("/testForm")
	public ModelAndView testCheck(MemberModel memberModel, HttpServletRequest req) throws Exception {
		log.info("getMapping login �떎�뻾");
		String id = req.getParameter("testId");
		MemberModel member = loginService.test(memberModel);
		ModelAndView mv = new ModelAndView();
		
		if (id == member.getMEMBER_ID()) {
			
		}
		
		

		mv.setViewName("member/testForm");
		mv.addObject("test", member);
		
		return mv;

	}

	@RequestMapping("/testOk")
	public ModelAndView test(MemberModel memberModel) throws Exception {
		log.info("getMapping login �떎�뻾");

		MemberModel member = loginService.login(memberModel);

		ModelAndView mv = new ModelAndView();

		mv.setViewName("member/testOk");
		mv.addObject("test", member);

		return mv;

	}

}
