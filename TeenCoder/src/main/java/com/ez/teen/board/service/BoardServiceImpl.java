package com.ez.teen.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.board.mapper.BoardMapper;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	// 전체 이용자 수
	@Override
	public int getUserCount() {
		return boardMapper.getUserCount();
	}

	// 전체 게시글 수
	@Override
	public int getBoardCount(int member_no) {
		return boardMapper.getBoardCount(member_no);
	}

	// 전체 댓글 수
	@Override
	public int getCommentCount(int member_no) {
		return boardMapper.getCommentCount(member_no);
	}

	// 게시글 리스트 (BGROUP 구별 없이)
	@Override
	public List<BoardModel> boardList(BoardParam boardParam) {

		return boardMapper.boardList(boardParam);
	}
	
	// 게시글 수정
	@Override
	public void updateBoard(BoardModel boardModel) {
		
		boardMapper.updateBoard(boardModel);
	}



	//05/26 병합
}
