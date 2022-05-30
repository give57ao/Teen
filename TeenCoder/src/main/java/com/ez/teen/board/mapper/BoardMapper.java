package com.ez.teen.board.mapper;



import java.util.Map;

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
	
	//게시글 작성
	public void insertBoard(BoardModel boardModel) throws Exception;
	
	//첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;
	
	
}
