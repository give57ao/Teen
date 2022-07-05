package com.ez.teen.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.model.CommentParam;
import com.ez.teen.board.service.BoardService;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.LoginService;
import com.ez.teen.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MyPageController {
	@Autowired
	private MemberService memberService;

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private LoginService loginService;
	
	//비밀번호 암호화,복호화
	@Autowired
    PasswordEncoder passwordEncoder;

	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);

	@GetMapping("/")
	public String myPage(MemberModel memberModel, Model model, HttpServletRequest request, BoardParam boardParam,
			CommentParam commentParam) throws Exception {

		HttpSession session = request.getSession();
		int member_no = (Integer) session.getAttribute("member_no");
		memberModel.setMember_no(member_no);
		boardParam.setMember_no(member_no);
		commentParam.setMember_no(member_no);
		List<MemberModel> myPageList = memberService.myPageList(memberModel);
		
		System.out.println("==============================");
		System.out.println(myPageList);
		System.out.println("==============================");

		
		
		model.addAttribute("list", myPageList);
		model.addAttribute("path", "/profileImage/");

		model.addAttribute("allBoardCount", boardService.getBoardCount(boardParam));
		model.addAttribute("allCommentCount", boardService.getCommentCount(commentParam));

		System.out.println(member_no);

		return "member/myPage";

	}

	@GetMapping("/boardList")
	public String myBoardList(Model model, BoardParam boardParam,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword, HttpSession session) {

		int member_no = (Integer) session.getAttribute("member_no");
		boardParam.setMember_no(member_no);

		int total = boardService.getBoardCount(boardParam);

		System.out.println("total :" + total);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		boardParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if (total == 0) {
			boardParam.setEndPage(1);
		}
		boardParam.setMember_no(member_no);
		model.addAttribute("paging", boardParam);
		model.addAttribute("sort", sort);
		model.addAttribute("board", boardService.boardList(boardParam));

		System.out.println("total : " + total);
		System.out.println("startPage :" + boardParam.getStartPage());
		System.out.println("endPage :" + boardParam.getEndPage());
		System.out.println("cntPerPage :" + boardParam.getCntPerPage());
		System.out.println("nowPage :" + boardParam.getNowPage());
		System.out.println("lastPage :" + boardParam.getLastPage());

		return "member/myBoard";

	}

	@GetMapping("/commentList")
	public String myCommentList(Model model, CommentParam commentParam,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword, HttpSession session) {

		int member_no = (Integer) session.getAttribute("member_no");
		commentParam.setMember_no(member_no);
		
		int total = boardService.getCommentCount(commentParam);

		System.out.println("total :" + total);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		commentParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if (total == 0) {
			commentParam.setEndPage(1);
		}
		commentParam.setMember_no(member_no);
		model.addAttribute("paging", commentParam);
		model.addAttribute("sort", sort);
		model.addAttribute("comment", boardService.commentList(commentParam));

		System.out.println("total : " + total);

		return "member/myComment";

	}

// 회원정보 수정 폼
	@GetMapping(value = "/mypageModify")
	public String mypageModifyForm(MemberModel memberModel, Model model, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		int member_no = (Integer) session.getAttribute("member_no");
		memberModel.setMember_no(member_no);

		List<MemberModel> member = memberService.myPageList(memberModel);
		model.addAttribute("list", member);

		return "member/modifyForm";
	}

	// 회원정보 수정
	@PostMapping(value = "/mypageModify")
	public String mypageModify(MemberModel memberModel, HttpSession session) throws Exception {

		int member_no = (Integer) session.getAttribute("member_no");
		//암호화 적용
		memberModel.setMember_no(member_no);
		String encodePw = passwordEncoder.encode(memberModel.getMember_pw());
		
		memberModel.setMember_pw(encodePw);

		memberService.mypageModify(memberModel);


	return "redirect:/member/";

	}

	@GetMapping("/delete")
	public String deleteMemberForm() throws Exception {

		return "member/deleteForm";
	}


	@ResponseBody
	@PostMapping("/passChk")
	public int passChk(MemberModel memberModel, HttpSession session) throws Exception {
		int member_no = (Integer) session.getAttribute("member_no");
		memberModel.setMember_no(member_no);
		//암호화된 pw -> 복호화
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				String rawPw = memberModel.getMember_pw();
				
				String userPw = loginService.getUserPw((String)session.getAttribute("member_id"));
				
				memberModel.setMember_pw(userPw);
				MemberModel member = loginService.login(memberModel);
				
				System.out.println("==========================================");
				System.out.println("사용자가 입력한 pw : " + rawPw);
				System.out.println("DB에 저장된 암호화 pw :" + userPw);
				System.out.println("MEMBER :" + member);
				System.out.println("==========================================");

		    	if(encoder.matches(rawPw, userPw)) {
		    		System.out.println("회원탈퇴 로직 성공");
		    		
		    		int result = 1;
		    		return result;
		    		}else {
		    		System.out.println("회원탈퇴 로직 실패");
		    		int result = 0;
		    		return result;
		    	}
		
	}
	
	@RequestMapping("/deleteMember")
	public String deleteMember(MemberModel memberModel, RedirectAttributes rttr,HttpServletRequest request, HttpSession session) throws Exception{
    	System.out.println("deleteMember GetMapping!!!");
		memberModel.setMember_no((Integer)session.getAttribute("member_no"));
		session.invalidate();
    	memberService.deleteMember(memberModel);
		return "redirect:/member/login";
	}
	
	
	@GetMapping("/profile")
	public String profileMember(MemberModel memberModel, HttpSession session, Model model) throws Exception {
		
		int member_no = (Integer) session.getAttribute("member_no");
		memberModel.setMember_no(member_no);
		List<MemberModel> myPageList = memberService.myPageList(memberModel);


		model.addAttribute("profile", myPageList);
		model.addAttribute("path", "/profileImage/");
		return "member/profileModify";
	}
	
	@PostMapping("/updateProfile")
	public String profileModifyMember(MemberModel memberModel, HttpSession session, MultipartHttpServletRequest mpRequest) throws Exception {
	   

		int member_no = (Integer) session.getAttribute("member_no");	
		memberModel.setMember_no(member_no);
		
		
		memberService.profileModifyMember(memberModel, mpRequest);

		return "redirect:/member/";
	}
	
	
	
	

	
}