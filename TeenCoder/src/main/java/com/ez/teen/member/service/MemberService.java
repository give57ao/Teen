package com.ez.teen.member.service;

import com.ez.teen.member.model.MemberModel;

public interface MemberService {
	
	void insertMember(MemberModel model);
	
	int checkId(String member_id);
	
	int checkNick(String member_nick);
	
	int checkEmail(String member_email);
	
	void deleteMember(MemberModel model);

}