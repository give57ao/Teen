package com.ez.teen.member.service;

import java.util.List;

import com.ez.teen.member.model.MemberModel;

public interface MemberService {

	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception;
	
}
