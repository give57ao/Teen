package com.ez.teen.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import com.ez.teen.board.model.BoardCommentModel;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.model.CommentParam;
import com.ez.teen.board.service.BoardService;
import com.ez.teen.member.model.MemberModel;

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
		
		boardParam.setMember_no(0);
		commentParam.setMember_no(0);
		
		model.addAttribute("allMemberCount", boardService.getUserCount());
		model.addAttribute("allBoardCount", boardService.getBoardCount(boardParam));
		model.addAttribute("allCommentCount", boardService.getCommentCount(commentParam));
		
		return "main";
	}

	//게시글 수정 폼
	@GetMapping("/board/modify")
	public String updateBoardForm(BoardModel boardModel, Model model , HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession();
		int member_no = (Integer)session.getAttribute("member_no");
		boardModel.setMember_no(member_no);
		
		
		return "board/boardModify";
	}
	
	//게시글 수정 기능
	@PostMapping("/board/modify")
	public String updateBoard(BoardModel boardModel, Model model , HttpServletRequest request) {
		
		HttpSession session = request.getSession();
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
	 
	//게시글 내용 디테일
	@RequestMapping("board/detail")
	public String selectBoardDetail(BoardModel boardModel, HttpSession session,
			HttpServletResponse response, BoardParam boardParam, Model model,
			@RequestParam(value="board_no")int board_no) throws Exception{
		// 파라미터 분석 : BoardParam의 board_no로 게시글 특정지음
		// @RequestParam으로 uri의 board_no? 뒤의 값을 가져옴
		
//		int member_no = (int)session.getAttribute("member_no"); // member_no가져옴
		boardParam.setBoard_no(board_no); // 위 파라미터에서 선언한 board_no(uri파라미터)를 setter를 통해 값 설정
//		boardParam.setMember_no(member_no);
		List<BoardModel> boardDetail = boardService.selectBoardDetail(boardParam);
		List<BoardCommentModel> boardComment = boardService.selectComment(boardParam);
				
		System.out.println(boardDetail);

		List<Map<String, Object>> fileList = boardService.selectFile(board_no);
		
		model.addAttribute("file", fileList);
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("boardComment", boardComment);
		
		return "board/boardDetail";
	}

	//첨부파일 다운로드 구현
		@RequestMapping(value = "board/downFile")
		public void downFile(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception{
			Map<String, Object> resultMap = boardService.downFile(map);
			
			String storedFileName = (String)resultMap.get("STORED_FILE_NAME");
			String originalFileName = (String)resultMap.get("ORG_FILE_NAME");
			
			byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("E:\\JAVA\\SpringTool"+storedFileName));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		}
	
	
	//게시판
	@GetMapping("/board")
	public String goBoard(Model model, BoardParam boardParam, HttpSession session,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value="board_tag_no", required = false)String board_tag_no,
			@RequestParam(value="board_group_no", required = false)String board_group_no) {
		

			if(board_group_no == null) {
				boardParam.setBoard_group_no("1");
			}
			
			
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
