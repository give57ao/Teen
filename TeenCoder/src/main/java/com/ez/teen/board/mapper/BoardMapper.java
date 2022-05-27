package com.ez.teen.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.board.model.BoardModel;

@Mapper
public interface BoardMapper {
	
	//전체 이용자 수
	public int getUserCount();
	
	//전체 게시글 수
	public int getBoardCount();
	
	//전체 댓글 수
	public int getCommentCount();

	BoardModel getContent(int boardNum)throws Exception;
	
}
