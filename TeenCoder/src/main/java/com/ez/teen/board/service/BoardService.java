package com.ez.teen.board.service;


import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.ez.teen.board.model.BoardModel;

public interface BoardService {

	//전체 이용자 수
	public int  getUserCount();
	
	//전체 게시글 수
	public int  getBoardCount();
	
	//전체 댓글 수
	public int  getCommentCount();
	
	//게시글 작성
	public void insertBoard(BoardModel boardModel, MultipartHttpServletRequest mpRequest) throws Exception;
	
	//첨부파일 추가
	public void insertFile(Map<String, Object> map) throws Exception;
		
}
