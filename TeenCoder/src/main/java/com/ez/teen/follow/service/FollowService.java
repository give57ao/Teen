package com.ez.teen.follow.service;

import java.util.List;

import com.ez.teen.follow.model.MemberFollowModel;
import com.ez.teen.follow.model.MemberFollowParam;

public interface FollowService {

			
	//내가 팔로우 한 사람의 게시글 불러오기
	public List<MemberFollowModel> followBoardList(MemberFollowModel followModel)throws Exception;
	
	// 전체 댓글 수
	public int getFollowCount(MemberFollowParam followParam);
	
}
