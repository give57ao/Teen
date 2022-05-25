package com.ez.teen.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.board.mapper.BoardMapper;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.common.PagingModel;

@Service
public class BoardServiceImpl  implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	//	전체 이용자 수
	@Override
	public int getUserCount() {
		return boardMapper.getUserCount();
	}

	//전체 게시글 수
	@Override
	public int getBoardCount() {
		return boardMapper.getBoardCount();
	}

	//전체 댓글 수
	@Override
	public int getCommentCount() {
		return boardMapper.getCommentCount();
	}

	//게시글 리스트 (BGROUP 구별 없이)
	@Override
	public List<BoardModel> boardList(PagingModel pm) {
		return boardMapper.boardList(pm);
	}

	

}
