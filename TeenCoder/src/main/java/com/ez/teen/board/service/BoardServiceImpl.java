package com.ez.teen.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.board.mapper.BoardMapper;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.common.PagingModel;
import com.ez.teen.member.model.MemberModel;

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
	public int getCommentCount(MemberModel memberModel) {
		return boardMapper.getCommentCount(memberModel);
	}

	// 게시글 리스트 (BGROUP 구별 없이)
	@Override
	public List<BoardModel> boardList(PagingModel pm) {

		return boardMapper.boardList(pm);
	}

}
