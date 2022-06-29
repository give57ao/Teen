package com.ez.teen.follow.service;

import java.util.List;

import com.ez.teen.follow.model.MemberFollowModel;
import com.ez.teen.follow.model.MemberFollowParam;
import com.ez.teen.member.model.MemberCardModel;

public interface FollowService {

			
	//내가 팔로우 한 사람의 게시글 불러오기
	public List<MemberFollowModel> followBoardList(MemberFollowModel followModel)throws Exception;
	
	// 전체 댓글 수
	public int getFollowCount(MemberFollowParam followParam);
	
	//팔로우 하기
	public void insertFollow(MemberFollowModel followMdoel)throws Exception;
	
	//팔로우 중복확인
	public int countFollow(MemberFollowModel followModel)throws Exception;
	
	
	
}
