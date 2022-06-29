package com.ez.teen;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		HttpSession httpSession = request.getSession();
//
//		if (httpSession.getAttribute("member") == null) {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//
//			out.println("<script>alert('로그인이 필요합니다!'); location.href='../member/login';</script>");
//			out.flush();
//			response.sendRedirect("/member/login");
//			return false;
//		}
//		return true;
//	}
//
//	
//	
	

}
