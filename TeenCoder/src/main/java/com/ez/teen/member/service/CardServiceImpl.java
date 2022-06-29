package com.ez.teen.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.model.CommentParam;
import com.ez.teen.member.mapper.CardMapper;
import com.ez.teen.member.model.MemberCardModel;

@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardMapper cardMapper;

	// 캐릭터 카드 내 정보
	@Override
	public List<MemberCardModel> myPageCardList(MemberCardModel cardModel) throws Exception {

		return cardMapper.myPageCardList(cardModel);
	}

	// 스크랩 게시글 총 수
	@Override
	public int getScrapCount(MemberCardModel cardModel) {

		return cardMapper.getScrapCount(cardModel);
	}

	// 팔로우한 회원 총 수
	@Override
	public int getFollowCount(MemberCardModel cardModel) {

		return cardMapper.getFollowCount(cardModel);
	}
	
	// 내가 쓴 글 총 수
	public int getBoardCount(MemberCardModel cardModel) {
		
		return cardMapper.getBoardCount(cardModel);
	}

	// 내가 쓴 댓글 총 수
	public int getCommentCount(MemberCardModel cardModel) {
		
		return cardMapper.getCommentCount(cardModel);
	}

	// 내가 팔로우 한 사람 정보
	@Override
	public List<MemberCardModel> getFollowList(MemberCardModel cardModel) throws Exception {

		return cardMapper.getFollowList(cardModel);
	}

	// 내가 스크랩한 게시글 정보
	@Override
	public List<MemberCardModel> getScrapList(MemberCardModel cardModel) throws Exception {
		
		return cardMapper.getScrapList(cardModel);
	}
	
	
	
	
}
