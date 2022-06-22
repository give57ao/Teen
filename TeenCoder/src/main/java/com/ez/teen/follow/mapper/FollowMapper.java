package com.ez.teen.follow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.follow.model.MemberFollowModel;
import com.ez.teen.follow.model.MemberFollowParam;

@Mapper
public interface FollowMapper {
	

	//내가 팔로우 한 사람의 게시글 불러오기
	public List<MemberFollowModel> followBoardList(MemberFollowModel followModel)throws Exception;

	public int getFollowCount(MemberFollowParam followParam);

	public void insertFollow(MemberFollowModel followMdoel)throws Exception;

	public int countFollow(MemberFollowModel followModel)throws Exception;

}