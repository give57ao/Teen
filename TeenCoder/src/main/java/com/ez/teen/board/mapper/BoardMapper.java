package com.ez.teen.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.common.PagingModel;

@Mapper
public interface BoardMapper {
	
	//전체 이용자 수
	public int getUserCount();
	
	//전체 게시글 수
	public int getBoardCount();
	
	//전체 댓글 수
	public int getCommentCount();

	//게시글 리스트 (BGROUP 구별 없이)
	public List<BoardModel> boardList(PagingModel pm);
	
	

}
