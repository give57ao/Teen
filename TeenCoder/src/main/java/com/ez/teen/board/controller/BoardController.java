package com.ez.teen.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.model.CommentParam;
import com.ez.teen.board.service.BoardService;
import com.ez.teen.member.model.MemberModel;

// 동혁 - 브랜치 만들고 확인작업
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	//Get Main Page
	// 메인 홈
	@GetMapping("/")
	public String main(BoardModel boardModel, MemberModel memberModel, Model model, BoardParam boardParam, CommentParam commentParam) {
		log.info("메인페이지 실행");
		
		int member_no =0;
		boardParam.setMember_no(0);
		commentParam.setMember_no(0);
		
		model.addAttribute("allMemberCount", boardService.getUserCount());
		model.addAttribute("allBoardCount", boardService.getBoardCount(boardParam));
		model.addAttribute("allCommentCount", boardService.getCommentCount(commentParam));
		
		return "main";
	}

	//
	@GetMapping("/member/modify")
	public String updateBoardForm(BoardModel boardModel, Model model , HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession();
		session.setAttribute("member_no", 2);
		int member_no = (Integer)session.getAttribute("member_no");
		boardModel.setMember_no(member_no);
		
		/* model.addAttribute("update", ); */
		return "board/boardModify";
	}
	
	@PostMapping("/member/modify")
	public String updateBoard(BoardModel boardModel, Model model , HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("member_no", 2);
		int member_no = (Integer)session.getAttribute("member_no");
		boardModel.setMember_no(member_no);
		
		boardService.updateBoard(boardModel);
		
		return "redirect:/board/main";
	}

	//게시글 작성 폼
	@GetMapping(value = "board/boardWrite")
	public String insertBoardForm() {
		

		return "board/boardWrite";
	}
	
	
	//게시글 작성 완료
	  
	@PostMapping(value = "board/boardWrite")
	public String insertBoard(BoardModel boardModel, HttpSession session, MultipartHttpServletRequest mpRequest) throws Exception{

		
	int member_no = (Integer)session.getAttribute("member_no");

	boardModel.setMember_no(member_no);
	
	boardService.insertBoard(boardModel, mpRequest);

	return "board/mainBoard"; 
	}
	
	
	// 게시글 목록 메인
	@RequestMapping(value = "board/mainBoard")
	public String mainBoard() {
		
		return "board/mainBoard";
	}
	 

	@RequestMapping("/board/detail")
	public ModelAndView selectBoardDetail(BoardModel boardModel, HttpSession session, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		int boardNum = (int) session.getAttribute("member_no");
		
		BoardModel model = boardService.selectBoardDetail(boardModel, boardNum);
		
		
		mv.addObject("content", model);
		mv.setViewName("board/boardDetail");
		return mv;
	}
	
	//게시판
	@GetMapping("/board")
	public String goBoard(Model model, BoardParam boardParam, HttpSession session,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword) {
		
			int total = boardService.getBoardCount(boardParam);
			
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
			
			model.addAttribute("paging", boardParam);
			model.addAttribute("sort", sort);
			model.addAttribute("board", boardService.boardList(boardParam));
			
			
			
			return "board/mainBoard";
	}
	
	
	
}
