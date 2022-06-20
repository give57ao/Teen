package com.ez.teen.follow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.follow.mapper.FollowMapper;
import com.ez.teen.follow.model.MemberFollowModel;
import com.ez.teen.follow.model.MemberFollowParam;

@Service
public class FollowServiceImpl implements FollowService{

	@Autowired
	private FollowMapper followMapper;
	

	
	//내가 팔로우 한 사람의 게시글 불러오기
	@Override
	public List<MemberFollowModel> followBoardList(MemberFollowModel followModel) throws Exception {

		return followMapper.followBoardList(followModel);
	}


	@Override
	public int getFollowCount(MemberFollowParam followParam) {
		
		return followMapper.getFollowCount(followParam);
	}

}
