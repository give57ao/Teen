package com.ez.teen.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;
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
   @GetMapping("board/modify")
   public String updateBoardForm(@RequestParam(value = "board_no") int board_no, 
         Model model, BoardParam boardParam)throws Exception{
      
      boardParam.setBoard_no(board_no);
      
      List<BoardModel> boardDetail = boardService.selectBoardDetail(boardParam);
      List<Map<String, Object>> fileList = boardService.selectFile(board_no);
      
      model.addAttribute("updateBoard", boardDetail);
      model.addAttribute("file", fileList);
      
      System.out.println("asdasd + = " + boardDetail);
      

      return "board/boardModify";
   }
   
   //게시글 수정 기능
   @PostMapping("board/modify")
   public String updateBoard(BoardModel boardModel, HttpSession session, 
         RedirectAttributes rttr, 
         @RequestParam(value="fileNoDel[]") String[] files,
         @RequestParam(value="fileNameDel[]") String[] fileNames,
         MultipartHttpServletRequest mpRequest) throws Exception{
      
      int member_no = (Integer)session.getAttribute("member_no");
      
      boardModel.setMember_no(member_no);
      String old_board_tag_name = boardModel.getBoard_tag_name();
      String init_board_tag_name = "";
      boardModel.setBoard_tag_name(init_board_tag_name);
      
      boardModel.setBoard_tag_name(old_board_tag_name);  //init이후 posting된 값 받아오기
      boardService.updateBoard(boardModel, files, fileNames, mpRequest);
      
      
      return "redirect:/board";
   }


   @PostMapping("board/modifyComment")
   public String modifyComment(HttpSession session, MultipartHttpServletRequest mpRequest,
		   CommentModel commentModel,
	         RedirectAttributes rttr, 
	         @RequestParam(value="fileNoDel[]") String[] files,
	         @RequestParam(value="fileNameDel[]") String[] fileNames) throws Exception {

	   
//	      commentParam.setBcomment_content("[수정] " +commentModel.getBcomment_content());

	      boardService.modifyComment(commentModel,files, fileNames, mpRequest);
	      
	   
	   
	   
	   return "redirect:/board/detail?board_no=" +commentModel.getBoard_no();
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
         
         List<BoardAnswerModel> boardAnswer = boardService.selectAnswer(boardParam);
         System.out.println(boardAnswer);
         List<Map<String, Object>> fileList = boardService.selectFile(board_no);
         int commentCount = boardService.commentCount(board_no);
         List<BoardAnswerModel> answerCount = boardService.answerCount(boardParam);
         
        
        int member_no = (Integer) session.getAttribute("member_no");
         
  	   	boardParam.setBoard_no(board_no);
  	   	boardParam.setMember_no(member_no);
         
         int boardLike = boardService.getBoardLike(boardParam);
         int boardReport = boardService.getBoardReport(boardParam);
         
         List<BoardCommentModel> boardComment = boardService.selectComment(boardParam);
                     
         System.out.println("*************************************");
         System.out.println("*************************************");
         System.out.println("*************************************");
         System.out.println("boardcomment : " +boardComment);
         System.out.println("*************************************");
         System.out.println("*************************************");
         System.out.println("*************************************");  
         
         
         
         model.addAttribute("boardComment", boardComment);
         model.addAttribute("board_no", board_no); //댓글 작성을 위해 board_no 받아오는 코드 추가
         model.addAttribute("file", fileList);
         model.addAttribute("boardDetail", boardDetail);
         model.addAttribute("boardAnswer", boardAnswer);
         model.addAttribute("commentNum", boardComment);
         model.addAttribute("commentCount", commentCount);
         model.addAttribute("answerCount", answerCount);
         model.addAttribute("boardLike", boardLike);
         model.addAttribute("boardReport", boardReport);
         boardService.hitCount(boardModel);

         
         
         
         String index = rq.getParameter("index");
         System.out.println("인덱스값: " + index);
         System.out.println(commentCount);
         
         return "board/boardDetail";
      }
      
      //댓글 작성
      @PostMapping("board/comment")
      public String insertComment(BoardModel boardModel, CommentModel commentModel, HttpSession session, MultipartHttpServletRequest mpRequest
         ,RedirectAttributes rttr) throws Exception {
         
         commentModel.setMember_no((int)session.getAttribute("member_no"));
         int board_no = commentModel.getBoard_no();
         
         //ref_step 구별 후 댓글 작성 로직
         int refStep = boardService.getRefStep(board_no);
         System.out.println("============================================================");
         System.out.println("board_no :"+board_no);
         System.out.println("refStep :" + refStep);
         System.out.println("============================================================");

         
         commentModel.setRef_step(refStep+1);
         boardService.insertComment(commentModel, mpRequest);
         
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

            
            //답글 수정
            @PostMapping("board/modifyRecomment")
            public String modifyReComment(BoardModel boardModel, CommentParam commentParam,CommentModel commentModel, HttpSession session, RedirectAttributes rttr) {
               
               
               int board_no = commentModel.getBoard_no();
              
               boardService.modifyReComment(commentModel);
               	
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
      String fileRoot = "C:\\summernote_image\\";   //저장될 외부 파일 경로
      String originalFileName = img.getOriginalFilename();   //오리지날 파일명
      String extension = originalFileName.substring(originalFileName.lastIndexOf("."));   //파일 확장자
            
      String savedFileName = UUID.randomUUID() + extension;   //저장될 파일 명
      
      File targetFile = new File(fileRoot + savedFileName);
      
      
      InputStream fileStream = img.getInputStream();
      FileUtils.copyInputStreamToFile(fileStream, targetFile);   //파일 저장
      
      System.out.println("===============SUMMER_IMAGE START================");
      System.out.println("/summernoteImage/"+savedFileName);
      System.out.println("===============SUMMER_IMAGE END==================");

      return ResponseEntity.ok().body("/summernoteImage/"+savedFileName);
      
   }   
   
   @RequestMapping("board/delete")
   public String deleteBoard(@RequestParam("board_no") int board_no, RedirectAttributes redirect) {
      
      try {
      boardService.updateBoardPkNo();
      boardService.deleteBoard(board_no);
      boardService.updateBoardPkYes();
      
      
      redirect.addFlashAttribute("msg", "삭제굿");
      
   } catch (Exception e) {
      
      redirect.addFlashAttribute("msg", "삭제에러");
   }
         
   return "redirect:/board/";
   }
   
// 댓글 삭제
   @RequestMapping("board/deleteComment")
   public String deleteBcomment(@RequestParam("board_no") int board_no, @RequestParam("bcomment_no") int bcomment_no,
		   @RequestParam("ref_step") int ref_step, RedirectAttributes redirect, CommentParam commentParam) {
      
    	  commentParam.setBoard_no(board_no);
    	  commentParam.setBcomment_no(bcomment_no);
    	  commentParam.setBcomment_no(ref_step);
    	  
    	  boardService.deleteComment(commentParam); // 삭제 및 업데이트 같이 작동
    
      return "redirect:/board/detail?board_no="+board_no;
   }
 
   @ResponseBody
   @PostMapping("board/detail/like")
   public int boardLike(HttpServletRequest request, HttpSession session,BoardModel boardModel, BoardParam boardParam) throws Exception{
	   
	   int board_no = Integer.parseInt(request.getParameter("board_no"));
	   int member_no = (Integer) session.getAttribute("member_no");
	   
	   boardParam.setBoard_no(board_no);
	   boardParam.setMember_no(member_no);
	   
	   int boardLike = boardService.getBoardLike(boardParam);
	   
	   System.out.println("boardLike = " + boardLike);
	   
	   boardModel.setBoard_no(board_no);
	   boardModel.setMember_no(member_no);
	   
	   if(boardLike >= 1) {
		   boardService.deleteBoardLike(boardModel);
		   boardLike = 0;
	   }else {
		   boardService.insertBoardLike(boardModel);
		   boardLike = 1;
	   }
	   
	   return boardLike;
   }
   
   @ResponseBody
   @PostMapping("board/detail/report")
   public int boardReport(HttpServletRequest request, HttpSession session,BoardModel boardModel, BoardParam boardParam) throws Exception{
	   
	   int board_no = Integer.parseInt(request.getParameter("board_no"));
	   int member_no = (Integer) session.getAttribute("member_no");
	   
	   boardParam.setBoard_no(board_no);
	   boardParam.setMember_no(member_no);
	   
	   int boardReport = boardService.getBoardReport(boardParam);
	   
	   System.out.println("Report = " + boardReport);
	   
	   boardModel.setBoard_no(board_no);
	   boardModel.setMember_no(member_no);
	   
	   if(boardReport >= 1) {
		   boardService.deleteBoardReport(boardModel);
		   boardReport = 0;
	   }else {
		   boardService.insertBoardReport(boardModel);
		   boardReport = 1;
	   }
	   
	   return boardReport;
   }
   
}

   

   