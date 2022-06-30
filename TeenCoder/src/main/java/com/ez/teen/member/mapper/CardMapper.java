package com.ez.teen.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.chat.model.ChatModel;
import com.ez.teen.member.model.MemberCardModel;

@Mapper
public interface CardMapper {

	// 캐릭터 카드 내 정보
	List<MemberCardModel> myPageCardList(MemberCardModel cardModel);

	// 스크랩 게시글 총 수
	public int getScrapCount(MemberCardModel cardModel);
	
	// 팔로우한 회원 총 수
	public int getFollowCount(MemberCardModel cardModel);

	// 내가 쓴 글 총 수
	public int getBoardCount(MemberCardModel cardModel);

	// 내가 쓴 댓글 총 수
	public int getCommentCount(MemberCardModel cardModel);

	// 내가 팔로우 한 사람 정보
	List<MemberCardModel> getFollowList(MemberCardModel cardModel)throws Exception;

	// 내가 스크랩한 게시글 정보 
	List<MemberCardModel> getScrapList(MemberCardModel cardModel);
	
	public List<ChatModel> getRecvMessageList(MemberCardModel cardModel) throws Exception;
}
