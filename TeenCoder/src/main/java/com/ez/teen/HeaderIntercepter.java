package com.ez.teen;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.MemberService;

public class HeaderIntercepter extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	
	@Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		MemberModel memberModel = new MemberModel();
		if(session.getAttribute("member_no") != null) {
			      memberModel.setMember_no((Integer)session.getAttribute("member_no"));
			      request.setAttribute("icon", memberService.myPageList(memberModel));
			      request.setAttribute("path", "/profileImage/");			     
		}
		
		   System.out.println("===================================");
		   System.out.println(memberModel);
		   System.out.println(session.getAttribute("member_no") );
		   System.out.println(memberService.myPageList(memberModel));
		   System.out.println("===================================");

	   }

}
