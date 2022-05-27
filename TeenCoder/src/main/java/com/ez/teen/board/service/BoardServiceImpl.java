package com.ez.teen.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.board.mapper.BoardMapper;
import com.ez.teen.board.model.BoardModel;

@Service
public class BoardServiceImpl  implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	//전체 이용자 수
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

	@Override
	public BoardModel getContent(BoardModel boardModel, int boardNum) throws Exception {
		return boardMapper.getContent(boardNum);
	}

}
