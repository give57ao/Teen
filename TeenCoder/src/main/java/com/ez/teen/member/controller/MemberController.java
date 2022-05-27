
package com.ez.teen.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	// uri가 처음으로 Form값으로 가는지 판별여부
	int firstIdCount = 0;
	int firstPwCount = 0;
	
	/*
	 * @Autowired private MemberService memberService; // 로그 설정 private static final
	 * Logger log = LoggerFactory.getLogger(MemberController.class);
	 */

	// 로그인

	/*
	 * @GetMapping("/login") public String login() throws Exception { return
	 * "member/loginForm"; }
	 */

	// 로그인 체크

	/*
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
	 * member.getMEMBER_NO()); mv.setViewName("redirect:/"); } else { //
	 * session.setAttribute("member_no", null); out.
	 * println("<script type='text/javascript'>alert('로그인 정보를 확인할 수 없습니다. 다시 로그인 해주세요.')</script>"
	 * ); out.flush(); mv.setViewName("member/loginForm"); mv.addObject("msg",
	 * false); }
	 * 
	 * return mv; }
	 */

	// 로그아웃

	/*
	 * @GetMapping("/logout") public String logout(HttpSession session) throws
	 * Exception { session.invalidate(); return "redirect:/"; }
	 */

	
	@RequestMapping("/findId")
	public ModelAndView FindId(MemberModel memberModel, HttpServletRequest req, HttpServletResponse response)
			throws Exception {
		ModelAndView mv = new ModelAndView(); // mv생성
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8"); // 두줄은 java에서 alert사용하기위해서
		

		MemberModel member = loginService.findId(memberModel);
		
		
		
		if (member != null) {
			mv.setViewName("member/findId");
			mv.addObject("findId", member);
			return mv;
		} else {
			if (firstIdCount == 0) {
				firstIdCount++;
				mv.setViewName("member/findIdForm");
				return mv;
			} else {
				out.println("<script type='text/javascript'>alert('입력정보 일치x')</script>");
				out.flush();
				mv.setViewName("member/findIdForm");
				return mv;
			}
			
		}
		

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
			if (firstPwCount==0) {
				firstPwCount++;
				mv.setViewName("member/findPwForm");
				return mv;
			} else {
				out.println("<script type='text/javascript'>alert('입력정보 일치x')</script>");
				out.flush();
				mv.setViewName("member/findPwForm");
				return mv;
			}
			
		}
	}

	// 마이페이지 가기

	/*
	 * @RequestMapping("/myPage") public String myPage() throws Exception {
	 * 
	 * return "member/myPage"; }
	 */

	// 회원탈퇴 홈페이지

	/*
	 * @GetMapping(value = "/delete") public String deleteMemberForm() throws
	 * Exception {
	 * 
	 * return "/member/deleteForm"; }
	 */

	// 회원 탈퇴 구현

	/*
	 * @PostMapping(value = "/delete") public String deleteMember(MemberModel
	 * memberModel, HttpSession session, RedirectAttributes rttr) throws Exception {
	 * 
	 * MemberModel member = (MemberModel) session.getAttribute("member");
	 * 
	 * String oldPass = member.getMEMBER_PW(); String newPass =
	 * memberModel.getMEMBER_PW();
	 * 
	 * if (!(oldPass.equals(newPass))) { rttr.addFlashAttribute("msg", false);
	 * return "redirect:/member/myPage"; }
	 * 
	 * memberService.deleteMember(memberModel);
	 * 
	 * session.invalidate();
	 * 
	 * return "redirect:/"; }
	 */

	// 회원정보 수정 폼

	/*
	 * @GetMapping(value = "mypageModifyForm") public String mypageModifyForm()
	 * throws Exception {
	 * 
	 * return "/member/modifyForm";
	 * 
	 * }
	 */

	// 회원정보 수정

	/*
	 * @PostMapping(value = "mypageModifyForm") public String
	 * mypageModify(MemberModel memberModel) throws Exception {
	 * 
	 * memberService.mypageModify(memberModel);
	 * 
	 * return "redirect:/member/myPage";
	 * 
	 * }
	 */

}
