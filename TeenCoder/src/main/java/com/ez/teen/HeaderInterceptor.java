package com.ez.teen;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ez.teen.chat.model.ChatModel;
import com.ez.teen.member.model.MemberCardModel;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.CardService;
import com.ez.teen.member.service.MemberService;

public class HeaderInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	CardService cardService;
	
	//캐릭터 카드 정보 셋팅 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		MemberModel memberModel = new MemberModel();
		MemberCardModel cardModel = new MemberCardModel();
		
		if (session.getAttribute("member_no") != null) {
			memberModel.setMember_no((Integer) session.getAttribute("member_no"));
			cardModel.setMember_no((Integer)session.getAttribute("member_no"));
			request.setAttribute("icon", memberService.myPageList(memberModel));
			request.setAttribute("path", "/profileImage/");
			request.setAttribute("list", cardService.myPageCardList(cardModel));
			request.setAttribute("allFollowCount", cardService.getFollowCount(cardModel));
			request.setAttribute("allScrapCount", cardService.getScrapCount(cardModel));
			request.setAttribute("allBoardCount", cardService.getBoardCount(cardModel));
			request.setAttribute("allCommentCount", cardService.getCommentCount(cardModel));
			request.setAttribute("followList", cardService.getFollowList(cardModel));
			request.setAttribute("scrapList", cardService.getScrapList(cardModel));
			cardModel.setMember_nick((String)session.getAttribute("member_nick"));
			request.setAttribute("recvChatList", cardService.getRecvMessageList(cardModel));
		}

		System.out.println("===================================");
		System.out.println(cardService.getRecvMessageList(cardModel));
		System.out.println("===================================");

	}	

}
