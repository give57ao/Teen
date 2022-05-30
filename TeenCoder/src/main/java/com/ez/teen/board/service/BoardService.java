package com.ez.teen.board.service;

import java.util.List;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;


import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

 
public interface BoardService {

	//전체 이용자 수
	public int  getUserCount();
	
	//전체 게시글 수
	public int  getBoardCount(BoardParam boardParam);

	//전체 댓글 수
	public int  getCommentCount(int member_no);

	
	//게시글 리스트 (BGROUP 구별 없이)
	public List<BoardModel> boardList(BoardParam boardParam);
	
	// 게시글 수정
	public void updateBoard(BoardModel boardModel);

	//게시글 작성
	public void insertBoard(BoardModel boardModel, MultipartHttpServletRequest mpRequest) throws Exception;
	
	//첨부파일 추가
	public void insertFile(Map<String, Object> map) throws Exception;
		
}
