package com.ez.teen.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.member.model.MemberModel;

@Mapper
public interface BoardMapper {
	
	//전체 이용자 수
	public int getUserCount();
	
	//전체 게시글 수
	public int getBoardCount(MemberModel memberModel);
	
	//전체 댓글 수
	public int getCommentCount(MemberModel memberModel);
	
	

}
