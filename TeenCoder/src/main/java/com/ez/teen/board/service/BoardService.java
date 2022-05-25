package com.ez.teen.board.service;

import java.util.List;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.common.PagingModel;
import com.ez.teen.member.model.MemberModel;

public interface BoardService {

	//전체 이용자 수
	public int  getUserCount();
	
	//전체 게시글 수
	public int  getBoardCount(MemberModel memberModel);

	public int  getCommentCount(MemberModel memberModel);

	
	//게시글 리스트 (BGROUP 구별 없이)
	public List<BoardModel> boardList(PagingModel pm);

}
