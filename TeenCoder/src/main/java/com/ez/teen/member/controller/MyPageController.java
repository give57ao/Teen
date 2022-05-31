<<<<<<< HEAD
package com.ez.teen.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.model.CommentParam;
import com.ez.teen.board.service.BoardService;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MyPageController {
	@Autowired
	private MemberService memberService;
  
	@Autowired
	private BoardService boardService;

	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);
	
	@GetMapping("/")
	public String myPageList(MemberModel memberModel, Model model , HttpServletRequest request, BoardParam boardParam, CommentParam commentParam) throws Exception {
		
		HttpSession session = request.getSession();
		int member_no = (Integer)session.getAttribute("member_no");
		memberModel.setMember_no(member_no);
		boardParam.setMember_no(member_no);
		commentParam.setMember_no(member_no);
		List<MemberModel> myPageList = memberService.myPageList(memberModel);
		model.addAttribute("list", myPageList);

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
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpSession session) {
		
		//session.setAttribute("member_no", 1);
		int member_no = (Integer)session.getAttribute("member_no");
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
		if(total == 0) {
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
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpSession session) {
		
		
		int member_no = (Integer)session.getAttribute("member_no");
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
		if(total == 0) {
			commentParam.setEndPage(1);
		}
		commentParam.setMember_no(member_no);
		model.addAttribute("paging", commentParam);
		model.addAttribute("sort", sort);
//		model.addAttribute("comment", boardService.commentList(commentParam));
		
		
		System.out.println("total : " + total);
        
		return "member/myComment";
		
		
	}
	
	
	// 회원정보 수정 폼
		@GetMapping(value = "/mypageModifyForm")
		public String mypageModifyForm(MemberModel memberModel, Model model,HttpServletRequest request) throws Exception {
			
			HttpSession session = request.getSession();
			int member_no = (Integer)session.getAttribute("member_no");
			memberModel.setMember_no(member_no);
			
			List<MemberModel> member = memberService.myPageList(memberModel);
			model.addAttribute("list", member);
			
			return "member/modifyForm";
		}
		
		// 회원정보 수정
		@PostMapping(value = "/mypageModifyForm")
		public String mypageModify(MemberModel memberModel, HttpSession session) throws Exception {
			
			int member_no = (Integer)session.getAttribute("member_no");
			memberModel.setMember_no(member_no);
			
			memberService.mypageModify(memberModel);
			
			return "redirect:/member/";
		}


	
}
=======
/*
 * package com.ez.teen.member.controller;
 * 
 * import java.util.List;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.ez.teen.board.model.BoardParam; import
 * com.ez.teen.board.service.BoardService; import
 * com.ez.teen.common.PagingModel; import com.ez.teen.member.model.MemberModel;
 * import com.ez.teen.member.service.MemberService;
 * 
 * @Controller
 * 
 * @RequestMapping("/") public class MyPageController {
 * 
 * @Autowired private MemberService memberService;
 * 
 * @Autowired private BoardService boardService;
 * 
 * private static final Logger log =
 * LoggerFactory.getLogger(MyPageController.class);
 * 
 * @GetMapping("member") public String myPageList(MemberModel memberModel, Model
 * model , HttpServletRequest request) throws Exception {
 * 
 * HttpSession session = request.getSession(); session.setAttribute("member_no",
 * 2); int member_no = (Integer)session.getAttribute("member_no");
 * memberModel.setMEMBER_NO(member_no);
 * 
 * List<MemberModel> myPageList = memberService.myPageList(memberModel);
 * model.addAttribute("list", myPageList);
 * 
 * model.addAttribute("allBoardCount", boardService.getBoardCount(member_no));
 * model.addAttribute("allCommentCount",
 * boardService.getCommentCount(member_no));
 * 
 * System.out.println(member_no);
 * 
 * return "member/myPage";
 * 
 * }
 * 
 * 
 * 
 * @GetMapping("member/boardList") public String myBoardList(Model model,
 * BoardParam boardParam,
 * 
 * @RequestParam(value = "nowPage", required = false) String nowPage,
 * 
 * @RequestParam(value = "cntPerPage", required = false) String cntPerPage,
 * HttpSession session) {
 * 
 * session.setAttribute("member_no", 1); int member_no =
 * (Integer)session.getAttribute("member_no");
 * 
 * int total = boardService.getBoardCount(member_no);
 * System.out.println("total :" + total);
 * 
 * if (nowPage == null && cntPerPage == null) { nowPage = "1"; cntPerPage =
 * "10"; } else if (nowPage == null) { nowPage = "1"; } else if (cntPerPage ==
 * null) { cntPerPage = "10"; } boardParam.PagingModel(total,
 * Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
 * boardParam.setMember_no(member_no);
 * 
 * model.addAttribute("paging", boardParam); model.addAttribute("board",
 * boardService.boardList(boardParam));
 * 
 * return "member/myBoard"; }
 * 
 * 
 * @GetMapping("member/boardList") public String myBoardListRecent(Model model,
 * BoardParam boardParam,
 * 
 * @RequestParam(value = "nowPage", required = false) String nowPage,
 * 
 * @RequestParam(value = "sort", required = false) String sort,
 * 
 * @RequestParam(value = "cntPerPage", required = false) String cntPerPage,
 * HttpSession session) {
 * 
 * session.setAttribute("member_no", 2); int member_no =
 * (Integer)session.getAttribute("member_no");
 * 
 * int total = boardService.getBoardCount(member_no);
 * System.out.println("total :" + total);
 * 
 * if (nowPage == null && cntPerPage == null) { nowPage = "1"; cntPerPage =
 * "10"; } else if (nowPage == null) { nowPage = "1"; } else if (cntPerPage ==
 * null) { cntPerPage = "10"; } boardParam.PagingModel(total,
 * Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
 * boardParam.setMember_no(member_no); boardParam.setRecent("recent");
 * model.addAttribute("paging", boardParam); model.addAttribute("board",
 * boardService.boardList(boardParam));
 * 
 * System.out.println(sort); return "member/myBoard"; }
 * 
 * 
 * }
 */
>>>>>>> refs/remotes/origin/dong_hyuk
