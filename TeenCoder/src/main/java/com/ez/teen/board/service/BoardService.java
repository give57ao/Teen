package com.ez.teen.board.service;

public interface BoardService {

	//전체 이용자 수
	public int  getUserCount();
	
	//전체 게시글 수
	public int  getBoardCount();
	
	//전체 댓글 수
	public int  getCommentCount();
		
}
