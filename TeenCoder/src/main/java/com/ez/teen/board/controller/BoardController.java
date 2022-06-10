package com.ez.teen.board.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ez.teen.board.model.BoardAnswerModel;
import com.ez.teen.board.model.BoardCommentModel;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.model.CommentModel;
import com.ez.teen.board.model.CommentParam;
import com.ez.teen.board.service.BoardService;
import com.ez.teen.common.file.FileUtil;
import com.ez.teen.common.file.WebMvcConfig;
import com.ez.teen.member.model.MemberModel;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	WebMvcConfig webMvcConfig;
	
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
	@GetMapping("board/modify")
	public String updateBoardForm(@RequestParam(value = "board_no") int board_no, 
			Model model, BoardParam boardParam)throws Exception{
		
		boardParam.setBoard_no(board_no);
		
		List<BoardModel> boardDetail = boardService.selectBoardDetail(boardParam);
		
		model.addAttribute("updateBoard", boardDetail);
		
		System.out.println("asdasd + = " + boardDetail);
		
		return "board/boardModify";
	}
	
	//게시글 수정 기능
	@PostMapping("board/modify")
	public String updateBoard(BoardModel boardModel, HttpSession session, MultipartHttpServletRequest mpRequest) {
		
		int member_no = (Integer)session.getAttribute("member_no");
		
		boardModel.setMember_no(member_no);
		
		boardService.updateBoard(boardModel);
		
		
		return "redirect:/board";
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

	return "redirect:/board"; 
	}
	
	
	// 게시글 목록 메인
	@RequestMapping(value = "board/mainBoard")
	public String mainBoard() {
		
		return "board/mainBoard";
	}
	 
	//게시글 내용 디테일
		@RequestMapping("board/detail")
		public String selectBoardDetail(BoardModel boardModel, HttpSession session,
				HttpServletResponse response, HttpServletRequest rq, BoardParam boardParam, Model model,
				@RequestParam(value="board_no")int board_no, CommentModel commentModel) throws Exception{

			boardParam.setBoard_no(board_no); 
			
			List<BoardModel> boardDetail = boardService.selectBoardDetail(boardParam);
			List<BoardCommentModel> boardComment = boardService.selectComment(boardParam);
			List<BoardAnswerModel> boardAnswer = boardService.selectAnswer(boardParam);
			int boardCommentCount = boardService.getRefStep(board_no) + 1;
			
			
			System.out.println(boardDetail);
			System.out.println(boardComment);
			System.out.println(boardAnswer);
						
			List<Map<String, Object>> fileList = boardService.selectFile(board_no);
			model.addAttribute("board_no", board_no); //댓글 작성을 위해 board_no 받아오는 코드 추가
			model.addAttribute("file", fileList);
			model.addAttribute("boardDetail", boardDetail);
			model.addAttribute("boardComment", boardComment);
			model.addAttribute("boardAnswer", boardAnswer);
			model.addAttribute("commentNum", boardComment);
			model.addAttribute("boardCommentCount", boardCommentCount);
			boardService.hitCount(boardModel);
			
			String index = rq.getParameter("index");
			System.out.println("인덱스값: " + index);
			System.out.println(boardCommentCount);
			
			return "board/boardDetail";
		}
		
		//댓글 작성
		@PostMapping("board/comment")
		public String insertComment(BoardModel boardModel, CommentModel commentModel, HttpSession session, MultipartHttpServletRequest mpRequest
			,RedirectAttributes rttr) {
			
			commentModel.setMember_no((int)session.getAttribute("member_no"));
			int board_no = commentModel.getBoard_no();
			
			//ref_step 구별 후 댓글 작성 로직
			int refStep = boardService.getRefStep(board_no);
			System.out.println("============================================================");
			System.out.println("board_no :"+board_no);
			System.out.println("refStep :" + refStep);
			System.out.println("============================================================");

			
			commentModel.setRef_step(refStep+1);
			boardService.insertComment(commentModel);
			
			rttr.addAttribute("board_no", board_no);
			return "redirect:/board/detail";
		}

				//답글 작성
				@PostMapping("board/recomment")
				public String insertReComment(BoardModel boardModel, CommentParam commentParam,CommentModel commentModel, HttpSession session, RedirectAttributes rttr) {
					
					commentModel.setMember_no((int)session.getAttribute("member_no"));
					
					int board_no = commentParam.getBoard_no();
					int ref_step = commentModel.getRef_step();
					
					commentParam.setBoard_no(board_no);
					commentParam.setRef_step(ref_step);
					
					//ref_step 구별 후 답글 작성 로직
					int ref_level = boardService.getRefLevel(commentParam);
					System.out.println("============================================================");
					System.out.println("board_no :"+board_no);
					System.out.println("ref_step :"+ref_step);
					System.out.println("ref_level :" + ref_level);
					System.out.println("============================================================");


						commentModel.setRef_level(ref_level+1);
						boardService.insertReComment(commentModel);
					
						rttr.addAttribute("board_no", board_no);
						return "redirect:/board/detail";
				}

		

	//첨부파일 다운로드 구현
		@RequestMapping(value = "board/downFile")
		public void downFile(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception{
			Map<String, Object> resultMap = boardService.downFile(map);
			
			String storedFileName = (String)resultMap.get("STORED_FILE_NAME");
			String originalFileName = (String)resultMap.get("ORG_FILE_NAME");
			
			FileUtil fileUtils = new FileUtil();
			byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File(fileUtils.getFilePath()+storedFileName));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		}
	
	
	//게시판
	@GetMapping("/board")
	public String goBoard(Model model, BoardParam boardParam, 
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value="board_tag_name", required = false)String board_tag_name,
			@RequestParam(value="board_group_no", required = false)String board_group_no) {
		

			if(board_group_no == null) {
				boardParam.setBoard_group_no("1");
			}
			System.out.println("====================================");
			System.out.println("BOARD_TAG_NAME :" + board_tag_name );
			System.out.println("====================================");

			
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
			model.addAttribute("board_group_no",board_group_no);
			
			
			return "board/mainBoard";
	}
	
	@RequestMapping("/board/recommend")
    public String recommendBoard(BoardModel boardModel) throws Exception {
        
        boardService.recommendBoard(boardModel);
    
        return "forward:/board/detail";
    }

	@RequestMapping(value="/uploadSummernoteImageFile", method=RequestMethod.POST)
	public ResponseEntity<?> summerimage(@RequestParam("file") MultipartFile img, HttpServletRequest request) 
	throws IOException {
		String path = "/board/summer";
		String realname = request.getServletContext().getRealPath(path);
		
		
		Random random = new Random();
	
		long currentTime = System.currentTimeMillis();
		int	randomValue = random.nextInt(100);
		String fileName = Long.toString(currentTime) + "_"+randomValue;
		
		boardService.insertSummerNote(fileName);
		
		File file = new File(realname , fileName);
		img.transferTo(file);
		
		//db에 저장
		
		return ResponseEntity.ok().body("summer/"+fileName);

	}	
	
	

	
}
