package com.ez.teen.member.service;

import java.util.List;

import com.ez.teen.chat.model.ChatModel;
import com.ez.teen.member.model.MemberCardModel;

public interface CardService {

	
	// 캐릭터 카드 내 정보
	public List<MemberCardModel> myPageCardList(MemberCardModel cardModel) throws Exception;
	
	// 스크랩 게시글 총 수
	public int getScrapCount(MemberCardModel cardModel);
	
	// 팔로우한 회원 총 수
	public int getFollowCount(MemberCardModel cardModel);
	
	// 내가 쓴 글 총 수
	public int getBoardCount(MemberCardModel cardModel);

	// 내가 쓴 댓글 총 수
	public int getCommentCount(MemberCardModel cardModel);
	
	// 내가 팔로우 한 사람 정보
	public List<MemberCardModel> getFollowList(MemberCardModel cardModel)throws Exception;

	// 내가 스크랩한 게시글 정보
	public List<MemberCardModel> getScrapList(MemberCardModel cardModel)throws Exception;
	
	//받은 쪽지 리스트 받아오기
	public List<ChatModel> getRecvMessageList(MemberCardModel cardModell) throws Exception;
}
