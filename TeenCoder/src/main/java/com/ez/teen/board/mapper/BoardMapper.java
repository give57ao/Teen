package com.ez.teen.board.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.model.CommentParam;

@Mapper
public interface BoardMapper {

	// 전체 이용자 수
	public int getUserCount();

	//전체 게시글 수
	public int getBoardCount(BoardParam boardParam);
	
	// 전체 댓글 수
	public int getCommentCount(CommentParam commentParam);

	// 게시글 리스트 (BGROUP 구별 없이)
	public List<BoardModel> boardList(BoardParam boardParam);
	
	public void updateBoard(BoardModel boardModel);

	//05/26 병합

	

	
	//게시글 작성
	public void insertBoard(BoardModel boardModel) throws Exception;
	
	//첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;
	
	
}
