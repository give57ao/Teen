package com.ez.teen.board.service;

import java.util.List;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.common.PagingModel;

public interface BoardService {

	//전체 이용자 수
	public int  getUserCount();
	
	//전체 게시글 수
	public int  getBoardCount(int member_no);

	public int  getCommentCount(int member_no);

	
	//게시글 리스트 (BGROUP 구별 없이)
	public List<BoardModel> boardList(PagingModel pm);

	//내가 작성한 게시글 
	public List<BoardModel> myBoardList(BoardParam boardParam);
	
	//05/26 병합
}
