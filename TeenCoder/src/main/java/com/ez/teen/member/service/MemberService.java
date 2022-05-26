package com.ez.teen.member.service;

import java.util.List;

import com.ez.teen.member.model.MemberModel;

public interface MemberService {
	
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception;

	int checkId(String member_id);
	
	int checkNick(String member_nick);
	
	int checkEmail(String member_email);
	
	void deleteMember(MemberModel memberModel);
	
	void insertMember(MemberModel memberModel);
	
	void mypageModify(MemberModel memberModel);

}